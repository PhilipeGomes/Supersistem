package com.ufrpe.superSystem.controle;

import java.net.URI;

import javax.validation.Valid;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ufrpe.superSystem.dto.ProdutoDTO;
import com.ufrpe.superSystem.servico.ProdutoServico;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoControle {
	
	@Autowired
	private ProdutoServico produtoServico;
	
	@GetMapping
	public ResponseEntity<Page<ProdutoDTO>> buscarTodos(
			@RequestParam(value = "idCategoria", defaultValue = "0") Long idCategoria,
			@RequestParam(value = "nome", defaultValue = "") String nome,
			//@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC)
			Pageable pageable) {
		Page<ProdutoDTO> list = produtoServico.buscarTodos(idCategoria, nome.trim(),pageable);
		return ResponseEntity.ok().body(list);		
		//return ResponseEntity.status(HttpStatus.OK).body(produtoServico.buscarTodos(pageable));
	}
	
	@GetMapping(value = "/{id}")
	public  ResponseEntity<ProdutoDTO> buscarPeloId(@PathVariable Long id) {
		ProdutoDTO dto = produtoServico.buscarPeloId(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> salvarProduto(@Valid @RequestBody ProdutoDTO dto) {
		dto = produtoServico.salvar(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping("/{id}/editar")
	public ResponseEntity<ProdutoDTO> editarProduto(@PathVariable Long id, @Valid  @RequestBody ProdutoDTO dto) {
		dto = produtoServico.editar(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@RequestMapping("/{id}/deletar")
	public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
		produtoServico.deletar(id);
		return ResponseEntity.noContent().build();
	}

	
}
