package com.ufrpe.superSystem.controle.excecao;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ufrpe.superSystem.servico.excecao.RecursoNaoLocalizadoExcecao;

@ControllerAdvice
public class ManipuladorExcecaoRecursos {
	
	@ExceptionHandler(RecursoNaoLocalizadoExcecao.class)
	public ResponseEntity<ErroPadrao> entityNotFound(RecursoNaoLocalizadoExcecao e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao err = new ErroPadrao();
		err.setTempo(Instant.now());
		err.setStatus(status.value());
		err.setErro("Recurso nao encontrado");
		err.setMessagem(e.getMessage());
		err.setCaminho(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErroValidacao> validacao(MethodArgumentNotValidException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		ErroValidacao err = new ErroValidacao();
		err.setTempo(Instant.now());
		err.setStatus(status.value());
		err.setErro("Excecao validacao");
		err.setMessagem(e.getMessage());
		err.setCaminho(request.getRequestURI());
		
		for (FieldError f : e.getBindingResult().getFieldErrors()) {
			err.addErro(f.getField(), f.getDefaultMessage());
		}
		
		return ResponseEntity.status(status).body(err);
	}	

}
