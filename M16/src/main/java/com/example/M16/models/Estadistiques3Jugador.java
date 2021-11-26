package com.example.M16.models;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.M16.repository.UsuariRepository;


public class Estadistiques3Jugador {
	Usuari usuari; 
	String uuid;
	List<Partida3> partides3; 
	double totalPartides3; 
	double guanya;
	double perd; 
	int percentGuanya; 
	int percentPerd; 
public Estadistiques3Jugador(Usuari usuari, List<Partida3> partides3) {
	this.partides3 = partides3;
	this.usuari=usuari;
	uuid=usuari.getUuid();
	obteXifres();
}

public void obteXifres() {
	for(Partida3 partida3:partides3) {
		if(partida3.isGuanyada()) {
			guanya++;
		}
	perd = totalPartides3-guanya; 
	totalPartides3 = partides3.size();
	percentGuanya =(int) (guanya/totalPartides3*100); 
	percentPerd = (int) (perd/totalPartides3*100); 
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
	return totalPartides3;
}

public void setTotalPartides(int totalPartides) {
	this.totalPartides3 = totalPartides;
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
