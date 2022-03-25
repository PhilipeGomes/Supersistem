package com.ufrpe.superSystem.modelos;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

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
    private Instant data_pedido;
	@ManyToOne
  	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	@ManyToOne
    @JoinColumn(name = "vendedor_id")
	private Vendedor vendedor;
	private StatusPedido status;
	
	@OneToMany(mappedBy = "id")
	private Set<Produto> produtos = new HashSet<>();

	public Pedido(){
		
	}

	public Pedido(Long id, String total, Instant data_pedido, Cliente cliente, Vendedor vendedor, StatusPedido status) {
		this.id = id;
		this.total = total;
		this.data_pedido = data_pedido;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.status = status;
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

	public Instant getData_pedido() {
		return this.data_pedido;
	}

	public void setData_pedido(Instant data_pedido) {
		this.data_pedido = data_pedido;
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

	public StatusPedido getStatus() {
		return this.status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}
	
}