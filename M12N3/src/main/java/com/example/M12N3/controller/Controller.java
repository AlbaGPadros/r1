package com.example.M12N3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
	 @GetMapping("/")
	 public String HelloWorld() {
	  return "Hello World!";
	 }
	 
	 
	    @GetMapping("/{nom}")
	    public String helloNom(@PathVariable String nom) {
	        return "Hello "+ nom +"!";
	    }
}
