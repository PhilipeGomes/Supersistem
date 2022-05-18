package com.ufrpe.superSystem.controle;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ufrpe.superSystem.dto.InsercaoUsuarioDTO;
import com.ufrpe.superSystem.dto.UsuarioDTO;
import com.ufrpe.superSystem.servico.UsuarioServico;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioControle {
	
	@Autowired
	private UsuarioServico usuarioServico;
	
	@GetMapping
	public ResponseEntity<Page<UsuarioDTO>> buscarTodos(Pageable pageable) {
		Page<UsuarioDTO> lista = usuarioServico.buscarTodos(pageable);
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> buscarPeloId(@PathVariable Long id) {
		UsuarioDTO usuario = usuarioServico.buscarPeloId(id);
		return ResponseEntity.ok().body(usuario);
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> salvarCliente(@RequestBody InsercaoUsuarioDTO dto) {
		UsuarioDTO novoUsuario = usuarioServico.salvar(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(novoUsuario.getId()).toUri();
		return ResponseEntity.created(uri).body(novoUsuario);	
	}
	
	@PutMapping("/{id}/editar")
	public ResponseEntity<UsuarioDTO> editarCliente(@PathVariable Long id, @RequestBody UsuarioDTO dto) {
		dto = usuarioServico.editar(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping("/{id}/deletar")
	public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
		usuarioServico.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
