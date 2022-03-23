package com.ufrpe.superSystem.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<CategoriaDTO> buscarTodos() {
		List<Categoria> resultado = categoriaRepositorio.findAll();
		List<CategoriaDTO> lista = new ArrayList<CategoriaDTO>();
		resultado.forEach(x -> lista.add(new CategoriaDTO(x)));
		return lista;
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
