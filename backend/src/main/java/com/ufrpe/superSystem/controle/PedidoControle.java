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

import com.ufrpe.superSystem.dto.PedidoDTO;
import com.ufrpe.superSystem.servico.PedidoServico;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoControle {
	
	@Autowired
	private PedidoServico pedidoServico;
	
	@GetMapping
	public ResponseEntity<Page<PedidoDTO>> buscarTodos(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(pedidoServico.buscarTodos(pageable));
	}
	
	@GetMapping(value = "/{id}")
	public PedidoDTO buscarPeloId(@PathVariable Long id) {
		return pedidoServico.buscarPeloId(id);
	}
	
	@PostMapping
	public PedidoDTO salvarCliente(@RequestBody PedidoDTO dto) {
		return pedidoServico.salvar(dto);
	}
	
}
