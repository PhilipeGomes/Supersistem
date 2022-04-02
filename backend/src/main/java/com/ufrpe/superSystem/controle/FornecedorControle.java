package com.ufrpe.superSystem.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufrpe.superSystem.dto.FornecedorDTO;
import com.ufrpe.superSystem.servico.FornecedorServico;

@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorControle {
	
	@Autowired
	private FornecedorServico fornecedorServico;
	
	@GetMapping
	public ResponseEntity<Page<FornecedorDTO>> buscarTodos(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(fornecedorServico.buscarTodos(pageable));
	}
	
	@GetMapping(value = "/{id}")
	public FornecedorDTO buscarPeloId(@PathVariable Long id) {
		return fornecedorServico.buscarPeloId(id);
	}
	
	@PostMapping
	public FornecedorDTO salvarFornecedor(@RequestBody FornecedorDTO dto) {
		return fornecedorServico.salvar(dto);
	}
	
	@PutMapping("/{id}/editar")
	public FornecedorDTO editarFornecedor(@PathVariable Long id, @RequestBody FornecedorDTO dto) {
		return fornecedorServico.editar(id, dto);
	}
	
	@RequestMapping("/{id}/deletar")
	public void deletarFornecedor(@PathVariable Long id) {
		fornecedorServico.deletar(id);
	}

}
