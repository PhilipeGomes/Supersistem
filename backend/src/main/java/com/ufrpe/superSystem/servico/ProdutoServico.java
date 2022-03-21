package com.ufrpe.superSystem.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		
		@Transactional(readOnly=true)
		public List<ProdutoDTO> buscarTodos(){
			List <Produto> resultado = produtoRepositorio.findAll();
			List<ProdutoDTO> lista = new ArrayList<ProdutoDTO>();
			resultado.forEach(x -> lista.add(new ProdutoDTO(x)));
			return lista;
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
			produto.setQuantidadeEstoque(produtoDTO.getQuantidadeEstoque());
			produto.setValor(produtoDTO.getValor());
			produto.setMarca(produtoDTO.getMarca());
			
			produtoRepositorio.save(produto);
			return new ProdutoDTO(produto);
		}

		@Transactional
		public ProdutoDTO editar(Long id, ProdutoDTO produtoDTO) {
			Produto produto = produtoRepositorio.findById(id).get();
			produto.setNome(produtoDTO.getNome());
			produto.setQuantidadeEstoque(produtoDTO.getQuantidadeEstoque());
			produto.setValor(produtoDTO.getValor());
			produto.setMarca(produtoDTO.getMarca());
			
			produtoRepositorio.save(produto);
			return new ProdutoDTO(produto);
		}
}
