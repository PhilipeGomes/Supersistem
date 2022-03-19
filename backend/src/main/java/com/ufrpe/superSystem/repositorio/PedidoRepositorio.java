package com.ufrpe.superSystem.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufrpe.superSystem.modelos.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long>{

}