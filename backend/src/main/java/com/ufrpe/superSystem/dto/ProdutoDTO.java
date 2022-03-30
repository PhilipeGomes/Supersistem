package com.ufrpe.superSystem.dto;

import com.ufrpe.superSystem.modelos.Produto;

public class ProdutoDTO {

	private Long id;
	private String nome;
	private Double valor;
	private Double qtdEstoque;
	private String marca;
	private String imgUrl;
	private String descricao;
	private String undVenda;

	public ProdutoDTO() {

	}

	public ProdutoDTO(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.valor = produto.getValor();
		this.qtdEstoque = produto.getQtdEstoque();
		this.marca = produto.getMarca();
		this.imgUrl = produto.getImgUrl();
		this.descricao = produto.getDescricao();
		this.undVenda = produto.getUndVenda();
	}

	public ProdutoDTO(Long id, String nome, double valor, Double qtdEstoque, String marca, String imgUrl,
			String descricao, String undVenda) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.qtdEstoque = qtdEstoque;
		this.marca = marca;
		this.imgUrl = imgUrl;
		this.descricao = descricao;
		this.undVenda = undVenda;
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

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUndVenda() {
		return undVenda;
	}

	public void setUndVenda(String undVenda) {
		this.undVenda = undVenda;
	}

}
