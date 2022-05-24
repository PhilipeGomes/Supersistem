package com.ufrpe.superSystem.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufrpe.superSystem.modelos.ItemCesta;
import com.ufrpe.superSystem.modelos.ItemCestaPK;

public interface ItemCestaRepositorio extends JpaRepository <ItemCesta, ItemCestaPK>{

}
