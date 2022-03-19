package com.ufrpe.superSystem.dto;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ufrpe.superSystem.modelos.Cliente;
import com.ufrpe.superSystem.modelos.Pedido;
import com.ufrpe.superSystem.modelos.Vendedor;

//camada responsavel por fazer a comunicação entre a camada de serviço e a camada de controle, sem nenhuma relação com transação, ou banco de dados
//Uma classe de objetos simples pra transferir dados
//dto(data transfer object) -> objeto para transferencia de dados
//quando a camada de serviço terminar toda orquestração dos dados copiamos os dados das entidades para o tipo dto

public class PedidoDTO {
	
	private Long id;
	private String total;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant data;
	private Cliente cliente;
	private Vendedor vendedor;
	

	public PedidoDTO(){
		
	}

	
	public PedidoDTO(Pedido pedido) {
		this.id = pedido.getId();
		this.total = pedido.getTotal();
		this.data = pedido.getData();
		this.cliente = pedido.getCliente();
		this.vendedor = pedido.getVendedor();
	}
	
	public PedidoDTO(Long id, String total, Instant data, Cliente cliente, Vendedor vendedor) {
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
