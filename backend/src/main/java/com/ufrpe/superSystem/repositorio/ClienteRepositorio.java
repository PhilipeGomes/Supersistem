package com.ufrpe.superSystem.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufrpe.superSystem.modelos.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{

}
