package com.ufrpe.superSystem.modelos;

import java.io.Serializable;

import javax.persistence.*;

//camada responsavel por fazer a comunicação entre a camada de serviço e a camada de acesso a dados(repositorio)
//Objetos monitorados pela ORM -> que é a ferramenta que trabalha com banco de dados, a JPA

@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	private String telefone;

	public Cliente(){
		
	}

	public Cliente(String telefone, Usuario usuario) {
		this.usuario = usuario;
		this.telefone = telefone;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
