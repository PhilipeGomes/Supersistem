package com.ufrpe.superSystem.modelos;

import java.io.Serializable;

import javax.persistence.*;


//camada responsavel por fazer a comunicação entre a camada de serviço e a camada de acesso a dados(repositorio)
//Objetos monitorados pela ORM -> que é a ferramenta que trabalha com banco de dados, a JPA

@Entity
@Table(name = "tb_Vendedor")
public class Vendedor implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(fetch = FetchType.EAGER)
	private Usuario usuario;
	private Integer qtd_vendas;
	private Double  saldo_vendas;
	private String  nivel;

	public Vendedor(){
		
	}

	public Vendedor(Integer qtd_vendas, Double  saldo_vendas, String nivel, Usuario usuario) {
		this.usuario = usuario;
		this.qtd_vendas = qtd_vendas;
		this.saldo_vendas = saldo_vendas;
		this.nivel         = nivel;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getQtd_vendas() {
		return qtd_vendas;
	}

	public void setQtd_vendas(Integer qtd_vendas) {
		this.qtd_vendas = qtd_vendas;
	}

	public Double getSaldo_vendas() {
		return saldo_vendas;
	}

	public void setSaldo_vendas(Double saldo_vendas) {
		this.saldo_vendas = saldo_vendas;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}


}