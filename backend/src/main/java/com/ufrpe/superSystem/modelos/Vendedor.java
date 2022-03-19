package com.ufrpe.superSystem.modelos;

import java.io.Serializable;

import javax.persistence.*;


//camada responsavel por fazer a comunicação entre a camada de serviço e a camada de acesso a dados(repositorio)
//Objetos monitorados pela ORM -> que é a ferramenta que trabalha com banco de dados, a JPA

@Entity
@Table(name = "tb_Vendedor")
public class Vendedor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	

	public Vendedor(){
		
	}

	public Vendedor(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}