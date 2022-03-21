package com.ufrpe.superSystem.dto;

import com.ufrpe.superSystem.modelos.Produto;

public class ProdutoDTO {
  
    private Long id;
    private String nome;
    private double valor;
    private int quantidadeEstoque;
    private String marca;
    
    public ProdutoDTO() {
    	
    }
    
    public ProdutoDTO(Produto produto) {
    	this.id = produto.getId();
		this.nome = produto.getNome();
		this.valor = produto.getValor();
		this.quantidadeEstoque = produto.getQuantidadeEstoque();
		this.marca = produto.getMarca();	
    }

	public ProdutoDTO(Long id, String nome, double valor, int quantidadeEstoque, String marca) {		
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
	
}
