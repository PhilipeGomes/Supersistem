package com.ufrpe.superSystem.dto;

import com.ufrpe.superSystem.modelos.Vendedor;

//camada responsavel por fazer a comunicação entre a camada de serviço e a camada de controle, sem nenhuma relação com transação, ou banco de dados
//Uma classe de objetos simples pra transferir dados
//dto(data transfer object) -> objeto para transferencia de dados
//quando a camada de serviço terminar toda orquestração dos dados copiamos os dados das entidades para o tipo dto

public class VendedorDTO {
	
	private Long id;
	private String nome;
	

	public VendedorDTO(){
		
	}

	
	public VendedorDTO(Vendedor vendedor) {
		this.id = vendedor.getId();
		this.nome = vendedor.getNome();
	}
	
	public VendedorDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
