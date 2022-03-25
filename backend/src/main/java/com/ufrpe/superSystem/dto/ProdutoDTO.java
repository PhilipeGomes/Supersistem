package com.ufrpe.superSystem.dto;

import com.ufrpe.superSystem.modelos.Produto;

public class ProdutoDTO {
  
    private Long id;
    private String nome;
    private Double valor;
    private Double qtdEstoque;
    private String marca;
    
    public ProdutoDTO() {
    	
    }
    
    public ProdutoDTO(Produto produto) {
    	this.id = produto.getId();
		this.nome = produto.getNome();
		this.valor = produto.getValor();
		this.qtdEstoque = produto.getQtdEstoque();
		this.marca = produto.getMarca();	
    }

	public ProdutoDTO(Long id, String nome, double valor, Double qtdEstoque, String marca) {		
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
	
}
