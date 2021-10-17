package com.example.M12N2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class InitialController {
	

	    @GetMapping("/")
	    public String hello() {
	        return "Hello World!";
	    }
	    
	    @GetMapping("/{nom}")
	    public String helloNom(@PathVariable String nom) {
	        return "Hello "+ nom +"!";
	    }
	    
	    @GetMapping("/test")
	    public String helloGradle() {
	        return "Hello Gradle!";
	    }

}
