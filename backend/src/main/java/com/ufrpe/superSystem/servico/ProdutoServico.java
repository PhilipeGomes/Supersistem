package com.ufrpe.superSystem.servico;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufrpe.superSystem.dto.CategoriaDTO;
import com.ufrpe.superSystem.dto.ProdutoDTO;
import com.ufrpe.superSystem.modelos.Categoria;
import com.ufrpe.superSystem.modelos.Produto;
import com.ufrpe.superSystem.repositorio.CategoriaRepositorio;
import com.ufrpe.superSystem.repositorio.ProdutoRepositorio;
import com.ufrpe.superSystem.servico.excecao.RecursoNaoLocalizadoExcecao;

@Service
@Transactional
public class ProdutoServico {
	
	// como o framework ja tem um gerenciador de depedencia pra gente essa anota��o
	// da conta de instanciar os objetos para chamar os metodos da interface
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;

	@Transactional(readOnly = true)
	public Page<ProdutoDTO> buscarTodos(Long idCategoria, String nome, Pageable pageable) {
		List<Categoria> categorias = (idCategoria == 0) ? null
				: Arrays.asList(categoriaRepositorio.getById(idCategoria));
		Page<Produto> resultado = produtoRepositorio.buscar(categorias, nome, pageable);
		// transformo a pagina em lista -> usa stream porque apesar de page ser um
		// stream lista n�o �
		produtoRepositorio.buscarCategoriasProdutos(resultado.getContent());
		return resultado.map(x -> new ProdutoDTO(x, x.getCategorias()));
	}

	@Transactional(readOnly = true)
	public ProdutoDTO buscarPeloId(Long id) {
		// Produto resultado = produtoRepositorio.findById(id).get();
		// ProdutoDTO dto = new ProdutoDTO(resultado, resultado.getCategorias());
		Optional<Produto> resultado = produtoRepositorio.findById(id);
		Produto entidade = resultado.orElseThrow(() -> new RecursoNaoLocalizadoExcecao("Entidade nao localizada"));
		return new ProdutoDTO(entidade, entidade.getCategorias());
	}

	@Transactional
	public void deletar(Long id) {
		try {
			produtoRepositorio.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new RecursoNaoLocalizadoExcecao("Id nao localizado " + id);
		}
	}

	@Transactional
	public ProdutoDTO salvar(ProdutoDTO produtoDTO) {
		Produto produto = new Produto();
		copiarDtoParaPrduto(produtoDTO, produto);
		produtoRepositorio.save(produto);
		return new ProdutoDTO(produto);
	}

	@Transactional
	public ProdutoDTO editar(Long id, ProdutoDTO produtoDTO) {
		
		try {
			Produto produto = produtoRepositorio.getById(id);
			copiarDtoParaPrduto(produtoDTO, produto);
			produto = produtoRepositorio.save(produto);
			return new ProdutoDTO(produto);			
		} catch(EntityNotFoundException e) {
			throw new RecursoNaoLocalizadoExcecao("Id nao localizado " + id);
		}
		
	}

	private void copiarDtoParaPrduto(ProdutoDTO produtoDTO, Produto produto) {
		produto.setNome(produtoDTO.getNome());
		produto.setQtdEstoque(produtoDTO.getQtdEstoque());
		produto.setValor(produtoDTO.getValor());
		produto.setMarca(produtoDTO.getMarca());
		produto.setImgUrl(produtoDTO.getImgUrl());
		produto.setDescricao(produtoDTO.getDescricao());
		produto.setUndVenda(produtoDTO.getUndVenda());

		produto.getCategorias().clear();
		for (CategoriaDTO catDto : produtoDTO.getCategorias()) {
			Categoria categoria = categoriaRepositorio.getById(catDto.getId());
			produto.getCategorias().add(categoria);
		}
	}
}
