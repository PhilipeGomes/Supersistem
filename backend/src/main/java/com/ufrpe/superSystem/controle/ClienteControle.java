package com.ufrpe.superSystem.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ufrpe.superSystem.dto.ClienteDTO;
import com.ufrpe.superSystem.servico.ClienteServico;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteControle {
	
	@Autowired
	private ClienteServico clienteServico;
	
	@GetMapping
	public List<ClienteDTO> buscarTodos() {
		return clienteServico.buscarTodos();
	}
	
	@GetMapping(value = "/{id}")
	public ClienteDTO buscarPeloId(@PathVariable Long id) {
		return clienteServico.buscarPeloId(id);
	}
	
	@PostMapping
	public ClienteDTO salvarCliente(@RequestBody ClienteDTO dto) {
		return clienteServico.salvar(dto);
	}
	
}
