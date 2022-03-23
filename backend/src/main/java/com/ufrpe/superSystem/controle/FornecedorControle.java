package com.ufrpe.superSystem.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<FornecedorDTO> buscarTodos() {
		return fornecedorServico.buscarTodos();
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
