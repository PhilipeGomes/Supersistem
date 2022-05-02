package com.ufrpe.superSystem.controle.excecao;

import java.io.Serializable;
import java.time.Instant;

public class ErroPadrao implements Serializable {
	private static final long serialVersionUID = 1L;

	private Instant tempo;
	private Integer status;
	private String erro;
	private String messagem;
	private String caminho;
	
	public ErroPadrao() {
		
	}

	public Instant getTempo() {
		return tempo;
	}

	public void setTempo(Instant tempo) {
		this.tempo = tempo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getMessagem() {
		return messagem;
	}

	public void setMessagem(String messagem) {
		this.messagem = messagem;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
}
