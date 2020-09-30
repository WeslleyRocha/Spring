package com.hellowordspring.hello.controller2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Atividade2")


public class HelloController2 {

	@GetMapping
	public String hello()
	{
		return "Adquirir conhecimento sobre a ferramentas e técnicas de utilização de desenvolvimento Web, \n"
				+ "Postman & Bando de dados" ;
	
	}
	
}
