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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufrpe.superSystem.dto.VendedorDTO;
import com.ufrpe.superSystem.servico.VendedorServico;

@RestController
@RequestMapping(value = "/vendedores")
public class VendedorControle {
	
	@Autowired
	private VendedorServico vendedorServico;
	

	@GetMapping
	public ResponseEntity<Page<VendedorDTO>> buscarTodos(
			@PageableDefault(page = 0, size = 10, direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(vendedorServico.buscarTodos(pageable));
	}
	
//	@GetMapping(value = "/{id}")
//	public VendedorDTO buscarPeloId(@PathVariable Long id) {
//		return vendedorServico.buscarPeloId(id);
//	}
	
	@PostMapping
	public VendedorDTO salvarCliente(@RequestBody VendedorDTO dto) {
		return vendedorServico.salvar(dto);
	}
	
}