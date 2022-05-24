package com.ufrpe.superSystem.modelos;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "item_cesta")
public class ItemCesta {

	@EmbeddedId
	@JsonIgnore
	private ItemCestaPK pk;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date adicionado = new Date();

	@Column(nullable = false)
	private int quantidade = 1;

	public ItemCesta() {

	}

	public ItemCesta(Usuario usuario, Produto produto, int quantidade) {
		pk = new ItemCestaPK();
		pk.setUsuario(usuario);
		pk.setProduto(produto);
		this.quantidade = quantidade;
	}
	
	public ItemCesta(ItemCesta item) {
		pk = new ItemCestaPK();
		pk.setUsuario(item.getPk().getUsuario());
		pk.setProduto(item.getPk().getProduto());
		this.quantidade = item.getQuantidade();
		
	}

	@Transient
	public Produto getProduto() {
		return pk.getProduto();
	}

	@Transient
	public double getPrecoTotal() {
		return quantidade * getProduto().getValor();
	}

	public ItemCestaPK getPk() {
		return pk;
	}

	public void setPk(ItemCestaPK pk) {
		this.pk = pk;
	}

	public Date getAdicionado() {
		return adicionado;
	}

	public void setAdicionado(Date adicionado) {
		this.adicionado = adicionado;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adicionado, pk, quantidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemCesta other = (ItemCesta) obj;
		return Objects.equals(pk.getUsuario().getId(), other.pk.getUsuario().getId()) &&
                Objects.equals(getProduto().getId(), other.getProduto().getId());
	}

}
