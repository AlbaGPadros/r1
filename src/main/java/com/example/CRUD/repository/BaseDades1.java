package com.example.CRUD.repository;

import java.util.ArrayList;
import java.util.Iterator;


import com.example.CRUD.bean.Feina;
import com.example.CRUD.bean.Treballador;

public class BaseDades1 {
	ArrayList <Treballador> treballadors = new ArrayList<Treballador>(); 
	int darrer = 0; 
	
	public BaseDades1() {
		treballadors.add(new Treballador(1, "A", "A", Feina.DATA));
		treballadors.add(new Treballador(2, "B", "B", Feina.BACKEND));
		treballadors.add(new Treballador(3, "C", "C", Feina.DATA));
		treballadors.add(new Treballador(4, "D", "D", Feina.FRONTEND));
		treballadors.add(new Treballador(5, "E", "E", Feina.TESTER));
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
	//CRUD
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
				t.setFeina(treballador.getFeina());
				break;
			}
		}
	}
	//FILTRE
	public ArrayList <Treballador> filtraTreballadorsFeina(Treballador treballador) {
		ArrayList <Treballador> treballadorsFeina=new ArrayList<Treballador>(); 
		int feinaInt=treballador.getFeinaInt(); 
		for(Treballador t:treballadors) {
			if(t.getFeinaInt()==feinaInt) {
				treballadorsFeina.add(t);
			}
		}
		return treballadorsFeina; 
	}
	
}
