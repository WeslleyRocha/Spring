package com.hellowordspring.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Hello")

public class HelloController {	
	
	@GetMapping
	public String hello()
	{
		return "Mentalidade de persistência, \n"
				+ "Atenção aos detalhes!  ";
	
	}
		
	
}
