package com.example.M16.models;

import java.util.Random;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection= "partides")
public class Partida {
@Id
private int id; 
@Field
int dau1; 
@Field
int dau2; 
@Field
boolean guanyada;
@Field
String uuid; 

public Partida() {
	dau1 = generaDau();
	dau2 = generaDau();
	guanyada = partidaGuanyada();  
}

public boolean partidaGuanyada() {
	if(dau1 + dau2 == 7) {
		return true; 
	} else {
		return false; 
	}
}

public int generaDau() {
	Random rd = new Random(); 
	return 	rd.nextInt(6)+1; 
}
//GETTERS I SETTERS
public int getDau1() {
	return dau1;
}
public void setId(int id) {
	this.id=id; 
}
public void setDau1(int dau1) {
	this.dau1 = dau1;
}

public int getDau2() {
	return dau2;
}

public void setDau2(int dau2) {
	this.dau2 = dau2;
}

public boolean isGuanyada() {
	return guanyada;
}

public void setGuanyada(boolean guanyada) {
	this.guanyada = guanyada;
}
public String getUuid() {
	return uuid;
}
public void setUuid(String uuid) {
	this.uuid = uuid;
}


@Override
public String toString() {
	return "Partida [id=" +id +", dau1 " +  dau1 + ", dau2 " + dau2 + ", guanyada? " + guanyada;
}
}
