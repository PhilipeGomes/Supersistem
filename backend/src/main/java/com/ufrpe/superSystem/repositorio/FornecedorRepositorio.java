package com.ufrpe.superSystem.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufrpe.superSystem.modelos.Fornecedor;

public interface FornecedorRepositorio extends JpaRepository<Fornecedor,Long> {

}
