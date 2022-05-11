package com.ufrpe.superSystem.dto;

import com.ufrpe.superSystem.modelos.Vendedor;

//camada responsavel por fazer a comunicação entre a camada de serviço e a camada de controle, sem nenhuma relação com transação, ou banco de dados
//Uma classe de objetos simples pra transferir dados
//dto(data transfer object) -> objeto para transferencia de dados
//quando a camada de serviço terminar toda orquestração dos dados copiamos os dados das entidades para o tipo dto

public class VendedorDTO {
	
	private String nome;
	private Long cpf;
	
	public VendedorDTO(){
		
	}

	
	public VendedorDTO(Vendedor vendedor) {
//		this.nome = vendedor.getNome();
//		this.cpf  = vendedor.getCpf();
	}
	
	public VendedorDTO(String nome, Long cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	

    public Long getCpf() {
		return cpf;
	}


	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}


	public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
