package com.ufrpe.superSystem.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public Page<ClienteDTO> buscarTodos(Pageable pageable) {
		Page<Cliente> resultado = clienteRepositorio.findAll(pageable);
	    return resultado.map(res -> new ClienteDTO(res));
	}

//	@Transactional(readOnly = true)
//	public ClienteDTO buscarPeloId(Long id) {
//		Cliente resultado = clienteRepositorio.findById(id).get();
//		ClienteDTO dto = new ClienteDTO(resultado);
//		return dto;
//	}

	@Transactional
	public void deletar(Long id) {
		clienteRepositorio.deleteById(id);
	}

	@Transactional
	public ClienteDTO salvar(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
//		cliente.setCpf(clienteDTO.getCpf());
//		cliente.setNome(clienteDTO.getNome());
//		cliente.setEmail(clienteDTO.getEmail());
		cliente.setTelefone(clienteDTO.getTelefone());

		clienteRepositorio.save(cliente);
		return new ClienteDTO(cliente);
	}

	@Transactional
	public ClienteDTO editar(Long id, ClienteDTO clienteDTO) {
		
		Cliente cliente = clienteRepositorio.findById(id).get();
//		cliente.setCpf(clienteDTO.getCpf());
//		cliente.setNome(clienteDTO.getNome());
//		cliente.setEmail(clienteDTO.getEmail());
		cliente.setTelefone(clienteDTO.getTelefone());
		
		clienteRepositorio.save(cliente);
		return new ClienteDTO(cliente);		
	}
	
}
