package org.escolabomsaber.secretariaEscola.repository;

import java.util.List;

import org.escolabomsaber.secretariaEscola.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	//public List<Aluno> findAllAlunoContainingIgnoreCase ();

		
}
