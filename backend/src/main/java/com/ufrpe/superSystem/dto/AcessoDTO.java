package com.ufrpe.superSystem.dto;

import com.ufrpe.superSystem.modelos.Acesso;

public class AcessoDTO {
	
	private Long id;
	private String authority;
	
	public AcessoDTO(){
		
	}
	public AcessoDTO(Long id, String authority){
		this.id = id;
		this.authority = authority;
	}
	public AcessoDTO(Acesso acesso){
		this.id = acesso.getId();
		this.authority = acesso.getAuthority();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}
