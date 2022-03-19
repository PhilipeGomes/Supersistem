package com.ufrpe.superSystem.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ufrpe.superSystem.dto.VendedorDTO;
import com.ufrpe.superSystem.servico.VendedorServico;

@RestController
@RequestMapping(value = "/vendedores")
public class VendedorControle {
	
	@Autowired
	private VendedorServico vendedorServico;
	
	@GetMapping
	public List<VendedorDTO> buscarTodos() {
		return vendedorServico.buscarTodos();
	}
	
	@GetMapping(value = "/{id}")
	public VendedorDTO buscarPeloId(@PathVariable Long id) {
		return vendedorServico.buscarPeloId(id);
	}
	
	@PostMapping
	public VendedorDTO salvarCliente(@RequestBody VendedorDTO dto) {
		return vendedorServico.salvar(dto);
	}
	
}