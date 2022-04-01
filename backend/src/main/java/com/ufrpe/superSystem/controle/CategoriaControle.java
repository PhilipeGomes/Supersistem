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

import com.ufrpe.superSystem.dto.CategoriaDTO;
import com.ufrpe.superSystem.servico.CategoriaServico;


@RestController
@RequestMapping(value = "/categorias")
public class CategoriaControle {
	
	@Autowired
	private CategoriaServico categoriaServico;
	
	@GetMapping
	public ResponseEntity<Page<CategoriaDTO>> buscarTodos(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(categoriaServico.buscarTodos(pageable));
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
