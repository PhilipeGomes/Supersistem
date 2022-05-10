package com.ufrpe.superSystem.controle.excecao;

import java.util.ArrayList;
import java.util.List;

public class ErroValidacao extends ErroPadrao {
	private static final long serialVersionUID = 1L;

	private List<CampoMensagem> erros = new ArrayList<>();

	public List<CampoMensagem> getErrors() {
		return erros;
	}

	public void addErro(String nomeCampo, String mensagem) {
		erros.add(new CampoMensagem(nomeCampo, mensagem));
	}

}
