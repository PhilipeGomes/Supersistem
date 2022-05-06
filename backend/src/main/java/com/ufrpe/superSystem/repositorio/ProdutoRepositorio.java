package com.ufrpe.superSystem.repositorio;

import java.util.List;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ufrpe.superSystem.modelos.Categoria;
import com.ufrpe.superSystem.modelos.Produto;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {
	
	//JPQL
	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cats WHERE "
			+ "(COALESCE(:categorias) IS NULL OR cats IN :categorias) AND "
			+ "(LOWER(obj.nome) LIKE LOWER(CONCAT('%',:nome,'%'))) ")
	Page<Produto> buscar(List<Categoria> categorias, String nome, Pageable pageable);
	
	@Query("SELECT obj FROM Produto obj JOIN FETCH obj.categorias WHERE obj IN :produtos")
	List<Produto> buscarCategoriasProdutos(List<Produto> produtos) ;
}
