package com.ufrpe.superSystem.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ufrpe.superSystem.dto.PedidoDTO;
import com.ufrpe.superSystem.servico.PedidoServico;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoControle {
	
	@Autowired
	private PedidoServico pedidoServico;
	
	@GetMapping
	public List<PedidoDTO> buscarTodos() {
		return pedidoServico.buscarTodos();
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
