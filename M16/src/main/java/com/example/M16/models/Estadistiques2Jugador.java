package com.example.M16.models;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.M16.repository.PartidaRepository;
import com.example.M16.repository.UsuariRepository;


public class Estadistiques2Jugador {
	Usuari usuari; 
	String uuid;
	List<Partida2> partides2; 
	double totalPartides2; 
	double guanya;
	double perd; 
	int percentGuanya; 
	int percentPerd; 
public Estadistiques2Jugador(Usuari usuari, List<Partida2> partides2) {
	this.partides2 = partides2;
	this.usuari=usuari;
	uuid=usuari.getUuid();
	obteXifres();
}

public void obteXifres() {
	for(Partida2 partida2:partides2) {
		if(partida2.isGuanyada()) {
			guanya++;
		}
	perd = totalPartides2-guanya; 
	totalPartides2 = partides2.size();
	percentGuanya =(int) (guanya/totalPartides2*100); 
	percentPerd = (int) (perd/totalPartides2*100); 
	}
}

public double getTotalPartides() {
	return totalPartides2;
}

public void setTotalPartides(int totalPartides) {
	this.totalPartides2 = totalPartides;
}


//GETTERS I SETTERS

public Usuari getUsuari() {
	return usuari;
}
public String getUuid() {
	return uuid; 
}

public void setUuid(String Uuid) {
	this.uuid = uuid; 
}
public void setUsuari(Usuari usuari) {
	this.usuari = usuari;
}


public double getGuanya() {
	return guanya;
}

public void setGuanya(int guanya) {
	this.guanya = guanya;
}

public double getPerd() {
	return perd;
}

public void setPerd(int perd) {
	this.perd = perd;
}

public int getPercentGuanya() {
	return percentGuanya;
}

public void setPercentGuanya(int percentGuanya) {
	this.percentGuanya = percentGuanya;
}

public int getPercentPerd() {
	return percentPerd;
}

public void setPercentPerd(int percentPerd) {
	this.percentPerd = percentPerd;
} 
}
