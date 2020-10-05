package com.minhaescola.escola.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity //Entidade de relacionamento
@Table (name = "aluno") // Criando a tabela "Aluno" 
public class Aluno {
	
	@Id //Idenficar que é um ID
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull   //Este campo ñ pode ser "nulo" vazio. 
	@Size(min = 3, max = 100) //Limite minino / maximo de caracteres
	private String nome;
	
	@NotNull   //Este campo ñ pode ser "nulo" vazio. 
	private boolean matriculado;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isMatriculado() {
		return matriculado;
	}

	public void setMatriculado(boolean matriculado) {
		this.matriculado = matriculado;
	} 
	
	
	
}
