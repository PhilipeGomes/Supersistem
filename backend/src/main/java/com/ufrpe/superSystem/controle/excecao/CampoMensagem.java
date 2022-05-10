package com.ufrpe.superSystem.controle.excecao;

import java.io.Serializable;

public class CampoMensagem implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nomeCampo;
	private String mensagem;

	public CampoMensagem() {

	}

	public CampoMensagem(String nomeCampo, String mensagem) {
		this.nomeCampo = nomeCampo;
		this.mensagem = mensagem;
	}

	public String getCampoMensagem() {
		return nomeCampo;
	}

	public void setCampoMensagem(String campoMensagem) {
		this.nomeCampo = campoMensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
