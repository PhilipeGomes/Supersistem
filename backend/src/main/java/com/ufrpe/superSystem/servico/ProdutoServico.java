package com.ufrpe.superSystem.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufrpe.superSystem.dto.ProdutoDTO;
import com.ufrpe.superSystem.modelos.Produto;
import com.ufrpe.superSystem.repositorio.ProdutoRepositorio;

@Service
@Transactional
public class ProdutoServico {
	
	//como o framework ja tem um gerenciador de depedencia pra gente essa anotação da conta de instanciar os objetos para chamar os metodos da interface
		@Autowired
		private ProdutoRepositorio produtoRepositorio;
		
		@Transactional(readOnly = true)
		public Page<ProdutoDTO> buscarTodos(Pageable pageable) {			
			Page<Produto> resultado = produtoRepositorio.findAll(pageable);
		    return resultado.map(res -> new ProdutoDTO(res));
		}
		
		@Transactional(readOnly=true)
		public ProdutoDTO buscarPeloId(Long id){
			Produto resultado = produtoRepositorio.findById(id).get();
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
			produto.setNome(produtoDTO.getNome());
			produto.setQtdEstoque(produtoDTO.getQtdEstoque());
			produto.setValor(produtoDTO.getValor());
			produto.setMarca(produtoDTO.getMarca());
			produto.setImgUrl(produtoDTO.getImgUrl());
			produto.setDescricao(produtoDTO.getDescricao());
			produto.setUndVenda(produtoDTO.getUndVenda());
			
			produtoRepositorio.save(produto);
			return new ProdutoDTO(produto);
		}

		@Transactional
		public ProdutoDTO editar(Long id, ProdutoDTO produtoDTO) {
			Produto produto = produtoRepositorio.findById(id).get();
			produto.setNome(produtoDTO.getNome());
			produto.setQtdEstoque(produtoDTO.getQtdEstoque());
			produto.setValor(produtoDTO.getValor());
			produto.setMarca(produtoDTO.getMarca());
			produto.setImgUrl(produtoDTO.getImgUrl());
			produto.setDescricao(produtoDTO.getDescricao());
			produto.setUndVenda(produtoDTO.getUndVenda());
			
			produtoRepositorio.save(produto);
			return new ProdutoDTO(produto);
		}
}
