package com.ufrpe.superSystem.dto;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ufrpe.superSystem.modelos.Cliente;
import com.ufrpe.superSystem.modelos.Pedido;
import com.ufrpe.superSystem.modelos.StatusPedido;
import com.ufrpe.superSystem.modelos.Vendedor;

//camada responsavel por fazer a comunicação entre a camada de serviço e a camada de controle, sem nenhuma relação com transação, ou banco de dados
//Uma classe de objetos simples pra transferir dados
//dto(data transfer object) -> objeto para transferencia de dados
//quando a camada de serviço terminar toda orquestração dos dados copiamos os dados das entidades para o tipo dto

public class PedidoDTO {
	
	private Long id;
	private String total;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant data_pedido;
	private Cliente cliente;
	private Vendedor vendedor;
	private StatusPedido status;

	public PedidoDTO(){
		
	}

	
	public PedidoDTO(Pedido pedido) {
		this.id = pedido.getId();
		this.total = pedido.getTotal();
		this.data_pedido = pedido.getData_pedido();
		this.cliente = pedido.getCliente();
		this.vendedor = pedido.getVendedor();
        this.status = pedido.getStatus();
	}
	
	public PedidoDTO(Long id, String total, Instant data_pedido, Cliente cliente, Vendedor vendedor, StatusPedido status) {
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

    public Instant getData() {
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

}
