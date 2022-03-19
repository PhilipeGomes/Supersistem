package com.ufrpe.superSystem.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufrpe.superSystem.modelos.Vendedor;

public interface VendedorRepositorio extends JpaRepository<Vendedor, Long>{

}