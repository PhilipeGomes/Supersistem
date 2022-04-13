package com.ufrpe.superSystem.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ufrpe.superSystem.modelos.Produto;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {
	
	@Query("SELECT obj FROM Produto obj JOIN FETCH obj.categorias WHERE obj IN :produtos")
	List<Produto> buscarCategoriasProdutos(List<Produto> produtos) ;
}
