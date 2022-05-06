package com.ufrpe.superSystem.servico;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufrpe.superSystem.dto.CategoriaDTO;
import com.ufrpe.superSystem.dto.ProdutoDTO;
import com.ufrpe.superSystem.modelos.Categoria;
import com.ufrpe.superSystem.modelos.Produto;
import com.ufrpe.superSystem.repositorio.CategoriaRepositorio;
import com.ufrpe.superSystem.repositorio.ProdutoRepositorio;

@Service
@Transactional
public class ProdutoServico {
	
	//como o framework ja tem um gerenciador de depedencia pra gente essa anotação da conta de instanciar os objetos para chamar os metodos da interface
		@Autowired
		private ProdutoRepositorio produtoRepositorio;
		@Autowired
		private CategoriaRepositorio categoriaRepositorio;
		
		@Transactional(readOnly = true)
		public Page<ProdutoDTO> buscarTodos(Long idCategoria, String nome, Pageable pageable) {		
			List<Categoria> categorias = (idCategoria == 0) ? null : Arrays.asList(categoriaRepositorio.getById(idCategoria));
			Page<Produto> resultado = produtoRepositorio.buscar(categorias, nome,pageable);
			//transformo a pagina em lista -> usa stream porque apesar de page ser um stream lista não é
			produtoRepositorio.buscarCategoriasProdutos(resultado.getContent());
		    return resultado.map(x -> new ProdutoDTO(x,  x.getCategorias()));
		}
		
		@Transactional(readOnly=true)
		public ProdutoDTO buscarPeloId(Long id){
			Produto resultado = produtoRepositorio.findById(id).get();
			//ProdutoDTO dto = new ProdutoDTO(resultado, resultado.getCategorias());
			ProdutoDTO dto = new ProdutoDTO(resultado);
			return dto;
		}
		
		@Transactional
		public void deletar(Long id) {
			produtoRepositorio.deleteById(id);
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
				Produto produto = produtoRepositorio.getById(id);
				copiarDtoParaPrduto(produtoDTO, produto);
				produto = produtoRepositorio.save(produto);
				return new ProdutoDTO(produto);
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
