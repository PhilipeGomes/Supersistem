package com.ufrpe.superSystem.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufrpe.superSystem.modelos.ItemPedido;
import com.ufrpe.superSystem.modelos.ItemPedidoChavePrimaria;

public interface ItemPedidoRepositorio extends JpaRepository<ItemPedido,ItemPedidoChavePrimaria> {

}
