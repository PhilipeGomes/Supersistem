package com.ufrpe.superSystem.dto;

import java.util.Objects;

import com.ufrpe.superSystem.modelos.Cliente;

//camada responsavel por fazer a comunicação entre a camada de serviço e a camada de controle, sem nenhuma relação com transação, ou banco de dados
//Uma classe de objetos simples pra transferir dados
//dto(data transfer object) -> objeto para transferencia de dados
//quando a camada de serviço terminar toda orquestração dos dados copiamos os dados das entidades para o tipo dto

public class ClienteDTO {

	private String nome;
	private Long cpf;
	private String telefone;
	private String email;

	public ClienteDTO() {

	}

	public ClienteDTO(Cliente cliente) {
//		this.nome = cliente.getNome();
//		this.cpf = cliente.getCpf();
		this.telefone = cliente.getTelefone();
//		this.email = cliente.getEmail();
	}

	public ClienteDTO(String nome, Long cpf, String telefone, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteDTO other = (ClienteDTO) obj;
		return Objects.equals(cpf, other.cpf);
	}
	
}
