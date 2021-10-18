package com.example.CRUD.repository;

import java.util.ArrayList;
import java.util.Iterator;


import com.example.CRUD.bean.Feina;
import com.example.CRUD.bean.Treballador;

public class BaseDades1 {
	ArrayList <Treballador> treballadors = new ArrayList<Treballador>(); 
	int darrer = 0; 
	
	public BaseDades1() {
		treballadors.add(new Treballador(1, "Martí", "Pérez", Feina.DATA));
		treballadors.add(new Treballador(2, "Anna", "Gómez", Feina.BACKEND));
		treballadors.add(new Treballador(3, "Martí", "Pérez", Feina.DATA));
		for(Treballador t: treballadors) {
			darrer++;
		}
	}
	
	public ArrayList<Treballador> getTreballadors(){
		return treballadors; 
	}
	
	public Treballador getTreballador(int id) {
		Iterator<Treballador> it = treballadors.iterator();
		for(Treballador t: treballadors) {
			if(t.getId() == id) {
				return t; 
			}
		}
		return null; 
	}
	
	public void imprimeix() {
		for(Treballador t:treballadors) {
			System.out.println(t.toString());
		}
	}
	
	public void inserta(Treballador treballador) {
		treballadors.add(treballador); 
		darrer++;
		treballador.setId(darrer);
	}
	
	public void esborra(int id) {
		Iterator<Treballador> it = treballadors.iterator(); 
		while(it.hasNext()) {
			Treballador t = it.next();
			if(t.getId() == id) {
				it.remove();
				break; 
			}
		}
	}
	
	public void modifica(Treballador treballador) {
		treballador.getNom(); 
		for(Treballador t: treballadors) {
			if(t.getId() == treballador.getId()) {
				t.setNom(treballador.getNom());
				t.setCognom(treballador.getCognom());
				break;
			}
		}
	}
	
}
