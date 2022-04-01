package com.ufrpe.superSystem.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufrpe.superSystem.dto.FornecedorDTO;
import com.ufrpe.superSystem.modelos.Fornecedor;
import com.ufrpe.superSystem.repositorio.FornecedorRepositorio;

@Service
@Transactional
public class FornecedorServico {

	@Autowired
	private FornecedorRepositorio fornecedorRepositorio;

	@Transactional(readOnly = true)
	public Page<FornecedorDTO> buscarTodos(Pageable pageable) {
		Page<Fornecedor> resultado = fornecedorRepositorio.findAll(pageable);
	    return resultado.map(res -> new FornecedorDTO(res));
	}

	@Transactional(readOnly = true)
	public FornecedorDTO buscarPeloId(Long id) {
		Fornecedor resultado = fornecedorRepositorio.findById(id).get();
		FornecedorDTO dto = new FornecedorDTO(resultado);
		return dto;
	}

	public void deletar(Long id) {
		fornecedorRepositorio.deleteById(id);
	}

	public FornecedorDTO salvar(FornecedorDTO fornecedorDTO) {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome(fornecedorDTO.getNome());
		fornecedor.setCnpj(fornecedorDTO.getCnpj());

		fornecedorRepositorio.save(fornecedor);
		return new FornecedorDTO(fornecedor);
	}

	@Transactional
	public FornecedorDTO editar(Long id, FornecedorDTO fornecedorDTO) {

		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome(fornecedorDTO.getNome());
		fornecedor.setCnpj(fornecedorDTO.getCnpj());

		fornecedorRepositorio.save(fornecedor);
		return new FornecedorDTO(fornecedor);
	}

}
