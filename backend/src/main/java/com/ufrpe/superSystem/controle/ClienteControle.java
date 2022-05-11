package com.ufrpe.superSystem.controle;

import java.net.URI;

import javax.validation.Valid;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ufrpe.superSystem.dto.ClienteDTO;
import com.ufrpe.superSystem.servico.ClienteServico;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteControle {
	
	@Autowired
	private ClienteServico clienteServico;
	
	@GetMapping
	public ResponseEntity<Page<ClienteDTO>> buscarTodos(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(clienteServico.buscarTodos(pageable));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> buscarPeloId(@PathVariable Long id) {
		ClienteDTO dto =  clienteServico.buscarPeloId(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<ClienteDTO> salvarCliente(@Valid @RequestBody ClienteDTO dto) {
		dto = clienteServico.salvar(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping("/{id}/editar")
	public ResponseEntity<ClienteDTO> editarCliente(@PathVariable Long id, @Valid @RequestBody ClienteDTO dto) {
		dto = clienteServico.editar(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@RequestMapping("/{id}/deletar")
	public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
		clienteServico.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
