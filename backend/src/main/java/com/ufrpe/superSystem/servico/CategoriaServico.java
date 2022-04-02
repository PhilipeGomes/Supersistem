package com.ufrpe.superSystem.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufrpe.superSystem.dto.CategoriaDTO;
import com.ufrpe.superSystem.modelos.Categoria;
import com.ufrpe.superSystem.repositorio.CategoriaRepositorio;

@Service
@Transactional
public class CategoriaServico {

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;

	@Transactional(readOnly = true)
	public Page<CategoriaDTO> buscarTodos(Pageable pageable) {		
		Page<Categoria> resultado = categoriaRepositorio.findAll(pageable);
	    return resultado.map(res -> new CategoriaDTO(res));
	}

	@Transactional(readOnly = true)
	public CategoriaDTO buscarPeloId(Long id) {
		Categoria resultado = categoriaRepositorio.findById(id).get();
		CategoriaDTO dto = new CategoriaDTO(resultado);
		return dto;
	}

	@Transactional
	public void deletar(Long id) {
		categoriaRepositorio.deleteById(id);
	}

	@Transactional
	public CategoriaDTO salvar(CategoriaDTO categoriaDTO) {
		Categoria categoria = new Categoria();
		categoria.setNome(categoriaDTO.getNome());
		categoriaRepositorio.save(categoria);
		return new CategoriaDTO(categoria);
	}

	@Transactional
	public CategoriaDTO editar(Long id, CategoriaDTO categoriaDTO) {

		Categoria categoria = categoriaRepositorio.findById(id).get();
		categoria.setNome(categoriaDTO.getNome());
		categoriaRepositorio.save(categoria);
		return new CategoriaDTO(categoria);
	}

}
