package com.ufrpe.superSystem.modelos;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double valor;
    private Double qtdEstoque;
    private String marca;
    
    @ManyToMany
	@JoinTable(name = "tb_produto_categoria", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private Set<Categoria> categorias = new HashSet<>();
    
    @OneToMany(mappedBy = "id.produto")
	private Set<ItemPedido> itens = new HashSet<>();
    
    public Produto() {
    	
    }

	public Produto(Long id, String nome, double valor, Double qtdEstoque, String marca) {		
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.qtdEstoque = qtdEstoque;
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
	

	public Double getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Double qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
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
