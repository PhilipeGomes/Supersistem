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

import com.ufrpe.superSystem.dto.CategoriaDTO;
import com.ufrpe.superSystem.servico.CategoriaServico;


@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaServico categoriaServico;
	
	@GetMapping
	public List<CategoriaDTO> buscarTodos() {
		return categoriaServico.buscarTodos();
	}
	
	@GetMapping(value = "/{id}")
	public CategoriaDTO buscarPeloId(@PathVariable Long id) {
		return categoriaServico.buscarPeloId(id);
	}
	
	@PostMapping
	public CategoriaDTO salvarCategoria(@RequestBody CategoriaDTO dto) {
		return categoriaServico.salvar(dto);
	}
	
	@PutMapping("/{id}/editar")
	public CategoriaDTO editarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO dto) {
		return categoriaServico.editar(id, dto);
	}
	
	@RequestMapping("/{id}/deletar")
	public void deletarCategoria(@PathVariable Long id) {
		categoriaServico.deletar(id);
	}

}
