package com.ufrpe.superSystem.modelos;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Embeddable
public class ItemPedidoChavePrimaria implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	
	public ItemPedidoChavePrimaria() {
		
	}
	
	public ItemPedidoChavePrimaria(Pedido pedido, Produto produto) {		
		this.pedido = pedido;
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pedido, produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedidoChavePrimaria other = (ItemPedidoChavePrimaria) obj;
		return Objects.equals(pedido, other.pedido) && Objects.equals(produto, other.produto);
	}

	@Override
	public String toString() {
		return "ItemPedidoChavePrimaria [pedido=" + pedido + ", produto=" + produto + "]";
	}
}
