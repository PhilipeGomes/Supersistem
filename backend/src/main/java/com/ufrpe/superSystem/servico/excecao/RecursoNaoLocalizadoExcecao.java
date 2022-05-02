package com.ufrpe.superSystem.servico.excecao;

public class RecursoNaoLocalizadoExcecao extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RecursoNaoLocalizadoExcecao(String msg) {
		super(msg);
	}
}
