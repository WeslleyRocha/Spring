package com.minhaescola.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.minhaescola.escola.model.Aluno;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Long> {

	public List<Aluno> findAllByNomeContainingIgnoreCase(String nome);
	
	//fazer uma busca com tudo que contem nessa variavel "TITULO"
	//IgnoreCase = Ignorar letras maiusculas e minusculas 
		
	
}
