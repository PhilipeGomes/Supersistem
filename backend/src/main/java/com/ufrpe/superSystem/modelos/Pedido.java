package com.ufrpe.superSystem.modelos;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

//camada responsavel por fazer a comunicação entre a camada de serviço e a camada de acesso a dados(repositorio)
//Objetos monitorados pela ORM -> que é a ferramenta que trabalha com banco de dados, a JPA

@Entity
@Table(name = "tb_Pedido")
public class Pedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String total;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant data;
	@ManyToOne
  	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	@ManyToOne
    @JoinColumn(name = "vendedor_id")
	private Vendedor vendedor;
	

	public Pedido(){
		
	}

	public Pedido(Long id, String total, Instant data, Cliente cliente, Vendedor vendedor) {
		this.id = id;
		this.total = total;
		this.data = data;
		this.cliente = cliente;
		this.vendedor = vendedor;
	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTotal() {
		return this.total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public Instant getData() {
		return this.data;
	}

	public void setData(Instant data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

}