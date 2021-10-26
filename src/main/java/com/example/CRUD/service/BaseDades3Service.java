package com.example.CRUD.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CRUD.bean.Treballador;
import com.example.CRUD.repository.BaseDades3;


@Service
public class BaseDades3Service implements IBaseDades3 {

	@Autowired
	BaseDades3 bd; 
	
		@Override
		public void inserta(Treballador treballador){
			bd.save(treballador);
		}
		
		@Override
		public void esborra(int id) {
			bd.deleteById(id);
		}
		
		@Override 
		public void modifica(Treballador treballador) {
			bd.save(treballador);
		}
		
		@Override 
		public Treballador getTreballador(int id) {
			Optional<Treballador> t = bd.findById(id);
			return t.get(); 
		}
		
		@Override
		public ArrayList<Treballador> getTreballadors() {
			return (ArrayList) bd.findAll();
		}

		@Override
		public ArrayList<Treballador> filtraTreballadorsFeina(Treballador treballador) {
			int feinaInt = treballador.getFeinaInt();
			return bd.findTreballadorByFeina(feinaInt);
		}
}