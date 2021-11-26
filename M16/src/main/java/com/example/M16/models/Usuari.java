package com.example.M16.models;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection= "usuaris")
public class Usuari {
@Id
String uuid;
@Field
String nomUsuari; 
@Field
String password; 
@Field
Boolean anonim=false; 

public Usuari(){
}

public String getNomUsuari() {
	if (anonim) {
		return "anonim";
	} else {
		return nomUsuari;
	}
}
public String getUuid() {
 	return uuid; 
 }

public void setUuid(String uuid) {
	this.uuid=uuid; 
}
public void setNomUsuari(String nomUsuari) {
	this.nomUsuari = nomUsuari; 
}


public void setPassword(String password) {
	this.password= password;
}
public void setAnonim(boolean anonim) {
	this.anonim= anonim; 
}
public boolean getAnonim() {
	return anonim;
}
 
}
