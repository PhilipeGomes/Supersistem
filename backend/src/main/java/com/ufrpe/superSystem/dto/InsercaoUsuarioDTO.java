package com.ufrpe.superSystem.dto;

public class InsercaoUsuarioDTO extends UsuarioDTO {

	private static final long serialVersionUID = 1L;

	private String senha;
	
	public InsercaoUsuarioDTO() {
		super();
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
