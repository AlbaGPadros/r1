package com.example.CRUD.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.CRUD.bean.Feina;
import com.example.CRUD.bean.Treballador;
import com.example.CRUD.repository.BaseDades1;
import com.example.CRUD.repository.BaseDades2;

@Controller
 @RequestMapping("/")
public class ControllerCRUD {
	//BaseDades1 bd = new BaseDades1(); 
	BaseDades2 bd = new BaseDades2(); 

    @GetMapping("/")
    public String indexGet(Model model) {
    	System.out.println(bd.getTreballadors());
        model.addAttribute("treballadors", bd.getTreballadors());
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
	/* PER BD1
	@GetMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model) {
		Treballador treballador = bd.getTreballador(id);
		System.out.println(treballador.getNom());
		model.addAttribute("treballador", treballador); 
		model.addAttribute("action", "/modificar/" + id);
		model.addAttribute("id", id);
		return "formulariEdita"; 
	}
	
    @PostMapping("modificar/{id}")
    public String modificar2(@PathVariable int id, Treballador treballador, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            treballador.setId(id);
        }
		//bd.modifica(treballador);
		return "redirect:/";	
		} */
	@GetMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model) {
		Treballador treballador = bd.getTreballador(id);
		System.out.println(treballador.getNom());
		model.addAttribute("treballador", treballador); 
		model.addAttribute("action", "/modificar/" + id);
		model.addAttribute("id", id);
		return "formulariEdita"; 
	}
	
    @PostMapping("modificar/{id}")
    public String modificar2(@PathVariable int id, Treballador treballador, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            treballador.setId(id);
        }
		//bd.modifica(treballador);
		return "redirect:/";	
		}
	
//FILTRA
@GetMapping("/filtra/{feina}")
public String filtra(@PathVariable Feina feina, Model model) {
	System.out.println(feina);
	return "index"; 
}

}

/*	
	@PostMapping("/modificar/{id}")
	public String modificar2(@PathVariable int id, Treballador treballador,  Model model) {
		System.out.println("modificar2");
		treballador = bd.getTreballador(id);
		System.out.println(treballador.getId());
		bd.desaTreballador(treballador); 
		System.out.println(treballador.getNom());
		ArrayList<Treballador> treballadors = bd.getTreballadors();
		bd.imprimeix();
		model.addAttribute("treballadors", treballadors); 
		model.addAttribute("treballador", null); 
		model.addAttribute("boto", "Afegeix treballador");
		model.addAttribute("action", "/desa");
		return "index"; 
	}
*/	
	


/*
 * 	@GetMapping("/")
	public String index(Model model) {
		ArrayList<Treballador> treballadors = bd.getTreballadors();
		model.addAttribute("treballadors", treballadors);
		return "index";
	}
 	@PostMapping("/")
	public String index2(Model model) {
		ArrayList<Treballador> treballadors = bd.getTreballadors();
		model.addAttribute("treballadors", treballadors);
		return "index";
	}
 */
