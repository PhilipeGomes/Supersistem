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

import com.ufrpe.superSystem.dto.ProdutoDTO;
import com.ufrpe.superSystem.servico.ProdutoServico;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoControle {
	
	@Autowired
	private ProdutoServico produtoServico;
	
	@GetMapping
	public ResponseEntity<Page<ProdutoDTO>> buscarTodos(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(produtoServico.buscarTodos(pageable));
	}
	
	@GetMapping(value = "/{id}")
	public ProdutoDTO buscarPeloId(@PathVariable Long id) {
		return produtoServico.buscarPeloId(id);
	}
	
	@PostMapping
	public ProdutoDTO salvarProduto(@RequestBody ProdutoDTO dto) {
		return produtoServico.salvar(dto);
	}
	
	@PutMapping("/{id}/editar")
	public ProdutoDTO editarProduto(@PathVariable Long id, @RequestBody ProdutoDTO dto) {
		return produtoServico.editar(id, dto);
	}

	@RequestMapping("/{id}/deletar")
	public void deletarProduto(@PathVariable Long id) {
		produtoServico.deletar(id);
	}

	
}
