package com.example.CRUD.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.CRUD.bean.Feina;
import com.example.CRUD.bean.Treballador;
import com.example.CRUD.repository.BaseDades1;
import com.example.CRUD.repository.BaseDades2;
import com.example.CRUD.repository.BaseDades3;
import com.example.CRUD.service.BaseDades3Service;

@Controller
 @RequestMapping("/")
public class ControllerCRUD {
	//BaseDades1 bd = new BaseDades1(); 
	//BaseDades2 bd = new BaseDades2(); 
	@Autowired
	BaseDades3Service bd; 
	
    @GetMapping("/")
    public String indexGet(Model model) {
    	ArrayList <Treballador> treballadors = bd.getTreballadors();
    	model.addAttribute("treballadors", treballadors);
        return "index";
	}
 //CREATE   
	@GetMapping("/formnoutreballador")
	public String formNouTreballador(Model model) {
		Treballador treballador = new Treballador(); 
		model.addAttribute("treballador", treballador);
		model.addAttribute("action", "/inserta");
		return "formulariNou";	
	} 
	@PostMapping("/inserta")
	public String inserta(@ModelAttribute Treballador treballador) {
		bd.inserta(treballador);
		return "redirect:/";
	}
	
//DELETE
	@GetMapping("/esborra/{id}")
	public String esborra(@PathVariable int id) {
		bd.esborra(id);
		return "redirect:/"; 
	}

//UPDATE
	@GetMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model) {
		Treballador treballador = bd.getTreballador(id);
    	model.addAttribute("treballadors", bd.getTreballadors());
		model.addAttribute("treballador", treballador); 
		model.addAttribute("action", "/modificar/");
		model.addAttribute("id", id);
		return "formulariEdita"; 
	}

    @PostMapping("modificar/")
    public String modificar2(Treballador treballador, BindingResult result,
        Model model) {
		bd.modifica(treballador);
		return "redirect:/";	
		} 
    
//FILTRA
@PostMapping("/filtra")
public String filtra(@ModelAttribute Treballador treballador, Model model) {
	ArrayList <Treballador> treballadors = bd.filtraTreballadorsFeina(treballador);
	model.addAttribute("treballadors", treballadors);
	return "index"; 
}


}



