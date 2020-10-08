package com.minhalojadegaymes.minhaLojaDeGaymes.modell;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min=2, max=50)
	private String categoria;
	
	
	@Size(min=2, max=50)
	private String decricao;

	@OneToMany (mappedBy = "categoria" , cascade = CascadeType.ALL)
	@JsonIgnoreProperties ("categoria")
	private List<Produto> produto;
	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getDecricao() {
		return decricao;
	}


	public void setDecricao(String decricao) {
		this.decricao = decricao;
	}
	
	
	
	
}
