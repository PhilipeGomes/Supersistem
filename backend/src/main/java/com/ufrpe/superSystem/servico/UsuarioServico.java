package com.ufrpe.superSystem.servico;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
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

@Service
@Transactional
public class UsuarioServico {
	    @Autowired
	    private BCryptPasswordEncoder passwordEncoder;
	//como o framework ja tem um gerenciador de depedencia pra gente essa anotação da conta de instanciar os objetos para chamar os metodos da interface
		@Autowired
		private UsuarioRepositorio usuarioRepositorio;
		@Autowired
		private AcessoRepositorio acessoRepositorio;
		
		@Transactional(readOnly = true)
		public Page<UsuarioDTO> buscarTodos(Pageable pageable) {		
            Page<Usuario> resultado = usuarioRepositorio.findAll(pageable);
		    return resultado.map(x -> new UsuarioDTO(x));
		}
		
		@Transactional(readOnly=true)
		public UsuarioDTO buscarPeloId(Long id){
			Usuario resultado = usuarioRepositorio.findById(id).get();
			UsuarioDTO dto = new UsuarioDTO(resultado);
			return dto;
		}
		
		@Transactional
		public void deletar(Long id) {
			usuarioRepositorio.deleteById(id);
		}
		
		@Transactional
		public UsuarioDTO salvar(InsercaoUsuarioDTO usuarioDTO) {
			Usuario usuario = new Usuario();
			copiarDtoParaPrduto(usuarioDTO, usuario);
			//hash pass -> by BCrypt method
			usuario.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
			usuarioRepositorio.save(usuario);
			return new UsuarioDTO(usuario);
		}

		@Transactional
		public UsuarioDTO editar(Long id, UsuarioDTO produtoDTO) {
				Usuario produto = usuarioRepositorio.getById(id);
				copiarDtoParaPrduto(produtoDTO, produto);
				produto = usuarioRepositorio.save(produto);
				return new UsuarioDTO(produto);
		}
		
		
		private void copiarDtoParaPrduto(UsuarioDTO usuarioDTO, Usuario usuario) {
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
