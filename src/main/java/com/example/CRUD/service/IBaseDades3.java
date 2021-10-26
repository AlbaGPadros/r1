package com.example.CRUD.service;

import java.util.ArrayList;

import com.example.CRUD.bean.Treballador;

public interface IBaseDades3 {
	public void inserta(Treballador treballador);
	public void esborra(int id); 
	public void modifica(Treballador treballador);
	public Treballador getTreballador(int id);
	public ArrayList<Treballador> getTreballadors(); 
	public ArrayList<Treballador> filtraTreballadorsFeina(Treballador treballador);
}
