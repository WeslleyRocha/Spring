package com.minhalojadegaymes.minhaLojaDeGaymes.modell;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_produto")
public class Produto {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min=2 , max= 30)
	private String nome;
	
	
	@NotNull
	@Size(min=2 , max=30)
	private String marca;
	
	@NotNull
	@Size(min=2 , max=30)
	private String modelo;
	
	@NotNull
	@DecimalMin("5,2") //5 casas e nas duas ultimas coloca a , ex 12345,00
	@DecimalMax("7,2") // 7 casas e nas duas ultimas coloca a , ex 1234567,22
	private double valor;
	
	@ManyToOne
	@JsonIgnoreProperties("categoria")
	private Categoria categoria;

	
	
	
	
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Categoria getCategoria_id() {
		return categoria;
	}

	public void setCategoria_id(Categoria categoria_id) {
		this.categoria = categoria_id;
	}
	
	
	
	
	
	
}
