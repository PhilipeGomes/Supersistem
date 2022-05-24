package com.ufrpe.superSystem.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ufrpe.superSystem.modelos.ItemCesta;
import com.ufrpe.superSystem.modelos.Usuario;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String cpf;
	private String email;

	private Set<AcessoDTO> acessos = new HashSet<>();

	@JsonManagedReference
	@OneToMany(mappedBy = "pk.user")
	private List<ItemCesta> itemCesta = new ArrayList<>();

	public UsuarioDTO() {

	}

	public UsuarioDTO(Long id, String nome, String cpf, String email, String senha) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}

	public UsuarioDTO(Usuario usuario) {
		id = usuario.getId();
		nome = usuario.getNome();
		cpf = usuario.getCpf();
		email = usuario.getEmail();
		// ja consigo pegar aqui os acessos porque acesso ta como eager no usuario,
		// entao
		// usuario ja vem com a lista de acessos
		usuario.getAcessos().forEach(acesso -> this.acessos.add(new AcessoDTO(acesso)));

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<AcessoDTO> getAcessos() {
		return acessos;
	}

	public List<ItemCesta> getItemCesta() {
		return itemCesta;
	}

	public void setItemCesta(List<ItemCesta> itemCesta) {
		this.itemCesta = itemCesta;
	}

}
