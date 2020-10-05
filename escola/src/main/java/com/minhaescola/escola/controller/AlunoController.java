package com.minhaescola.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.minhaescola.escola.model.Aluno;
import com.minhaescola.escola.repository.AlunoRepository;


@RestController
@RequestMapping("/alunos")//Definindo URL de controle
@CrossOrigin("*")
public class AlunoController {

	@Autowired
	private AlunoRepository repository;
	
	@GetMapping //Metodo que sera disparado
	public ResponseEntity<List<Aluno>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/{id}") //Metodos de pesquisa "por ID" 
	public ResponseEntity<Aluno> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
//	@GetMapping("/aluno/{nome}")
//	public ResponseEntity<List<Aluno>> GetByNome(@PathVariable String nome){
//		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
//}
	
	@PostMapping //Metodo de postagem.
	public ResponseEntity <Aluno> post (@RequestBody Aluno aluno){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(aluno));
	}
	
	@PutMapping  //Atualização do metodo, "Atualizar Legenda".
	public ResponseEntity<Aluno> put (@RequestBody Aluno aluno){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(aluno));
	}
	
	@DeleteMapping("/{id}") //Metodo delete "Post" 
	public void delete (@PathVariable long id)
	{
		repository.deleteById(id);
	}
	
}
