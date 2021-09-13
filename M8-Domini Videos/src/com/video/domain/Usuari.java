package com.video.domain;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class Usuari {
private String nom; 
private String cognom; 
private String password; 
private LocalDate dataRegistre; 
private ArrayList<Video> llistatVideos = new ArrayList<Video>();


public Usuari(String nom, String cognom, String password) {
	this.nom = nom;
	this.cognom = cognom; 
	this.password = password; 
	dataRegistre = LocalDate.now(); 	
}

//AFEGEIX VIDEO
public void afegeixVideo(Video video) {
	llistatVideos.add(video);
}

//GET VIDEOS
public ArrayList<Video> getLlistatVideos() {
	return llistatVideos; 
}
}

