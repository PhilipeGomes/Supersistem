package com.ufrpe.superSystem.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufrpe.superSystem.modelos.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria,Long> {

}
