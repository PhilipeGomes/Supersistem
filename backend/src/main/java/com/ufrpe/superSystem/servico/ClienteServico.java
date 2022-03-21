package com.ufrpe.superSystem.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufrpe.superSystem.dto.ClienteDTO;
import com.ufrpe.superSystem.modelos.Cliente;
import com.ufrpe.superSystem.repositorio.ClienteRepositorio;

@Service
@Transactional
public class ClienteServico {

	// como o framework ja tem um gerenciador de depedencia pra gente essa anotação
	// da conta de instanciar os objetos para chamar os metodos da interface
	@Autowired
	private ClienteRepositorio clienteRepositorio;

	@Transactional(readOnly = true)
	public List<ClienteDTO> buscarTodos() {
		List<Cliente> resultado = clienteRepositorio.findAll();
		List<ClienteDTO> lista = new ArrayList<ClienteDTO>();
		resultado.forEach(x -> lista.add(new ClienteDTO(x)));
		return lista;
	}

	@Transactional(readOnly = true)
	public ClienteDTO buscarPeloId(Long id) {
		Cliente resultado = clienteRepositorio.findById(id).get();
		ClienteDTO dto = new ClienteDTO(resultado);
		return dto;
	}

	@Transactional
	public void deletar(Long id) {
		clienteRepositorio.deleteById(id);
	}

	@Transactional
	public ClienteDTO salvar(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setNome(clienteDTO.getNome());
		cliente.setEmail(clienteDTO.getEmail());
		cliente.setTelefone(clienteDTO.getTelefone());

		clienteRepositorio.save(cliente);
		return new ClienteDTO(cliente);
	}

	@Transactional
	public ClienteDTO editar(Long id, ClienteDTO clienteDTO) {
		
		Cliente cliente = clienteRepositorio.findById(id).get();
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setNome(clienteDTO.getNome());
		cliente.setEmail(clienteDTO.getEmail());
		cliente.setTelefone(clienteDTO.getTelefone());
		
		clienteRepositorio.save(cliente);
		return new ClienteDTO(cliente);		
	}
	
}
