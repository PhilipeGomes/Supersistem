package com.ufrpe.superSystem.servico;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrpe.superSystem.dto.CategoriaDTO;
import com.ufrpe.superSystem.dto.ProdutoDTO;
import com.ufrpe.superSystem.modelos.Categoria;
import com.ufrpe.superSystem.modelos.ItemCesta;
import com.ufrpe.superSystem.modelos.Produto;
import com.ufrpe.superSystem.repositorio.ItemCestaRepositorio;
import com.ufrpe.superSystem.servico.excecao.RecursoNaoLocalizadoExcecao;

@Service
@Transactional
public class ItemCestaServico {

	@Autowired
	private ItemCestaRepositorio itemCestaRepositorio;

	public List<ItemCesta> buscarTodos() {
		return itemCestaRepositorio.findAll();
	}

	public ItemCesta buscarPeloId(Long usuarioId, Long produtoId) {

		for (ItemCesta item : buscarTodos()) {
			if (item.getPk().getUsuario().getId() == usuarioId && item.getPk().getProduto().getId() == produtoId) {
				return new ItemCesta(item);
			}
		}

		throw new RecursoNaoLocalizadoExcecao("Id nao localizado " + usuarioId + " " + produtoId);

	}

	public ItemCesta salvar(ItemCesta cartItem) {

		for (ItemCesta item : buscarTodos()) {
			itemCestaRepositorio.save(cartItem);
			return new ItemCesta(item);
		}

		throw new RecursoNaoLocalizadoExcecao("Item nao localizado");

	}

	public ItemCesta atualizar(ItemCesta cartItem) {

		for (ItemCesta item : buscarTodos()) {
			if (item.equals(cartItem)) {
				item.setQuantidade(cartItem.getQuantidade());
				itemCestaRepositorio.save(item);
				return new ItemCesta(item);
			}
		}

		throw new RecursoNaoLocalizadoExcecao("Item nao localizado");

	}

	public void deletar(Long usuarioId, Long produtoId) {

		try {
			for (ItemCesta item : buscarTodos()) {
				if (item.getPk().getUsuario().getId() == usuarioId && item.getPk().getProduto().getId() == produtoId) {
					itemCestaRepositorio.delete(item);
					return;
				}
			}

		} catch (EntityNotFoundException e) {
			throw new RecursoNaoLocalizadoExcecao("Item nao localizado");

		}

	}
	
	private void copiarDtoParaItemCesta(ProdutoDTO produtoDTO, Produto produto) {
		produto.setNome(produtoDTO.getNome());
		produto.setQtdEstoque(produtoDTO.getQtdEstoque());
		produto.setValor(produtoDTO.getValor());
		produto.setMarca(produtoDTO.getMarca());
		produto.setImgUrl(produtoDTO.getImgUrl());
		produto.setDescricao(produtoDTO.getDescricao());
		produto.setUndVenda(produtoDTO.getUndVenda());

		
	}

}
