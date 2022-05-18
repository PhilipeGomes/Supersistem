package com.ufrpe.superSystem.servico;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufrpe.superSystem.dto.AcessoDTO;
import com.ufrpe.superSystem.dto.InsercaoUsuarioDTO;
import com.ufrpe.superSystem.dto.UsuarioDTO;
import com.ufrpe.superSystem.modelos.Acesso;
import com.ufrpe.superSystem.modelos.Usuario;
import com.ufrpe.superSystem.repositorio.AcessoRepositorio;
import com.ufrpe.superSystem.repositorio.UsuarioRepositorio;
import com.ufrpe.superSystem.servico.excecao.RecursoNaoLocalizadoExcecao;

@Service
@Transactional
public class UsuarioServico {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	// como o framework ja tem um gerenciador de depedencia pra gente essa anotação
	// da conta de instanciar os objetos para chamar os metodos da interface
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	@Autowired
	private AcessoRepositorio acessoRepositorio;

	@Transactional(readOnly = true)
	public Page<UsuarioDTO> buscarTodos(Pageable pageable) {
		Page<Usuario> resultado = usuarioRepositorio.findAll(pageable);
		return resultado.map(x -> new UsuarioDTO(x));
	}

	@Transactional(readOnly = true)
	public UsuarioDTO buscarPeloId(Long id) {
		Optional<Usuario> resultado = usuarioRepositorio.findById(id);
		Usuario entidade = resultado.orElseThrow(() -> new RecursoNaoLocalizadoExcecao("Entidade nao localizada"));
		return new UsuarioDTO(entidade);

	}

	@Transactional
	public void deletar(Long id) {
		try {
			usuarioRepositorio.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new RecursoNaoLocalizadoExcecao("Id nao localizado " + id);
		}

	}

	@Transactional
	public UsuarioDTO salvar(InsercaoUsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		copiarDtoParaUsuario(usuarioDTO, usuario);
		// hash pass -> by BCrypt method
		usuario.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
		usuarioRepositorio.save(usuario);
		return new UsuarioDTO(usuario);
	}

	@Transactional
	public UsuarioDTO editar(Long id, UsuarioDTO produtoDTO) {
		try {
			Usuario produto = usuarioRepositorio.getById(id);
			copiarDtoParaUsuario(produtoDTO, produto);
			produto = usuarioRepositorio.save(produto);
			return new UsuarioDTO(produto);

		} catch (EntityNotFoundException e) {
			throw new RecursoNaoLocalizadoExcecao("Id nao localizado " + id);
		}

	}

	private void copiarDtoParaUsuario(UsuarioDTO usuarioDTO, Usuario usuario) {
		usuario.setNome(usuarioDTO.getNome());
		usuario.setCpf(usuarioDTO.getCpf());
		usuario.setEmail(usuarioDTO.getEmail());

		usuario.getAcessos().clear();
		for (AcessoDTO acessoDto : usuarioDTO.getAcessos()) {
			Acesso acesso = acessoRepositorio.getById(acessoDto.getId());
			usuario.getAcessos().add(acesso);
		}
	}
}
