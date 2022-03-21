package com.ufrpe.superSystem.repositorio;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufrpe.superSystem.modelos.Produto;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {
}
