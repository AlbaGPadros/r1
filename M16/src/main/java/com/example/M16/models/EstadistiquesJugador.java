package com.example.M16.models;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.M16.repository.PartidaRepository;
import com.example.M16.repository.UsuariRepository;


public class EstadistiquesJugador {
	Usuari usuari; 
	String uuid;
	List<Partida> partides; 
	double totalPartides; 
	double guanya;
	double perd; 
	int percentGuanya; 
	int percentPerd; 
public EstadistiquesJugador() {}
public EstadistiquesJugador(Usuari usuari, List<Partida> partides) {
	this.partides = partides;
	this.usuari=usuari;
	uuid=usuari.getUuid();
	obteXifres();
}

public void obteXifres() {
	for(Partida partida:partides) {
		if(partida.isGuanyada()) {
			guanya++;
		}
	perd = totalPartides-guanya; 
	totalPartides = partides.size();
	percentGuanya =(int) (guanya/totalPartides*100); 
	percentPerd = (int) (perd/totalPartides*100); 
	}
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

public double getTotalPartides() {
	return totalPartides;
}

public void setTotalPartides(int totalPartides) {
	this.totalPartides = totalPartides;
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
