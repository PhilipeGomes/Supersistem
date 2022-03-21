package com.ufrpe.superSystem.modelos;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_Produto")
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private double valor;
    private int quantidadeEstoque;
    private String marca;
    
//    @ManyToMany
//	@JoinTable(name = "tb_produto_categoria", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
//	private Set<Categoria> categorias = new HashSet<>();
//    
//    @OneToMany(mappedBy = "id.produto")
//	private Set<ItemPedido> itens = new HashSet<>();
    
    public Produto() {
    	
    }

	public Produto(Long id, String nome, double valor, int quantidadeEstoque, String marca) {		
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.quantidadeEstoque = quantidadeEstoque;
		this.marca = marca;		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

//	public Set<Categoria> getCategorias() {
//		return categorias;
//	}
//	
//	@JsonIgnore
//	public Set<Pedido> getPedidos() {
//		Set<Pedido> set = new HashSet<>();
//		for (ItemPedido x : itens) {
//			set.add(x.getPedido());
//		}
//		return set;
//	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}    

}
