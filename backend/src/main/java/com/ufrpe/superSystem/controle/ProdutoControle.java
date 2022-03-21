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

import com.ufrpe.superSystem.dto.ProdutoDTO;
import com.ufrpe.superSystem.servico.ProdutoServico;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoControle {
	
	@Autowired
	private ProdutoServico produtoServico;
	
	@GetMapping
	public List<ProdutoDTO> buscarTodos() {
		return produtoServico.buscarTodos();
	}
	
	@GetMapping(value = "/{id}")
	public ProdutoDTO buscarPeloId(@PathVariable Long id) {
		return produtoServico.buscarPeloId(id);
	}
	
	@PostMapping
	public ProdutoDTO salvarCliente(@RequestBody ProdutoDTO dto) {
		return produtoServico.salvar(dto);
	}
	
	@PutMapping("/{id}/editar")
	public ProdutoDTO editarCliente(@PathVariable Long id, @RequestBody ProdutoDTO dto) {
		return produtoServico.editar(id, dto);
	}

	@RequestMapping("/{id}/deletar")
	public void deletarCliente(@PathVariable Long id) {
		produtoServico.deletar(id);
	}

	
}
