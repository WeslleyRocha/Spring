package org.generation.blogPessoal.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.repository.PostagemRepository;

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



@RestController
@RequestMapping("/postagens") //Definindo URL de controle
@CrossOrigin("*")
public class PostagemController {

	@Autowired
	private PostagemRepository repository;
	
	@GetMapping //Metodo que sera disparado
	public ResponseEntity<List<Postagem>> GetAll(){
		return ResponseEntity.ok(repository.findAll());	
	}
	
	
	@GetMapping ("/{id}") //Metodos de pesquisa "por ID" 
	public ResponseEntity<Postagem> GetById(@PathVariable  long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
		
	
	@GetMapping ("/titulo/{titulo}")  //Metodos de pesquisa dentro do titulo "por Titulo" 
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));		
	}
	
	
	@PostMapping //Metodo de postagem. 
	public ResponseEntity<Postagem> post (@RequestBody Postagem postagem)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	
	
	@PutMapping  //Atualização do metodo, "Atualizar Legenda". 
	public ResponseEntity<Postagem> put (@RequestBody Postagem postagem)
	{
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	
	@DeleteMapping("/{id}") //Metodo delete "Post" 
	public void delete (@PathVariable long id)	
	{
		repository.deleteById(id);
	}
	
}
