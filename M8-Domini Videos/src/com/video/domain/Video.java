package com.video.domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class Video {
	
String url = ""; 
String titol; 
String duradaString;
int duradaVideo;
LocalDate dataUpload; 
EstatReproduccio estatReproduccio = EstatReproduccio.PLAY; 
EstatUpload estatUpload; 
ArrayList<Tag> llistatEtiquetes = new ArrayList<Tag>();
String etiquetesString = ""; 
boolean videoaturat = false; 


public Video(String titol, String duradaString) {
	this.titol = titol; 
	this.duradaString = duradaString; 
	dataUpload = LocalDate.now(); 	
	duradaInt(duradaString);
}

//ENUMS
public enum EstatUpload{
	UPLOADING, VERIFYING, PUBLIC;
}

public enum EstatReproduccio{
	PLAY, PAUSE, STOP;
}


//LLISTAT Etiquetes
	public ArrayList<Tag> etiquetes(String etiquetesEntreComes) {
		String[] arrayEtiquetes = etiquetesEntreComes.split("\\s*,\\s*");
		for (int i=0; i<arrayEtiquetes.length; i++) {
			Tag tag = new Tag((arrayEtiquetes[i]));
			llistatEtiquetes.add(tag);
		}
		EtiquetesAString();
		return llistatEtiquetes;		
	}

	public String EtiquetesAString(){
		for(int i = 0; i <llistatEtiquetes.size(); i++) {
			etiquetesString = etiquetesString + llistatEtiquetes.get(i).nomEtiqueta() + ", ";
		}
		return etiquetesString; 
	}
	
	//GETTERS
	public String Etiquetes() {
	return etiquetesString;
	}

	public String getInfoVideo() {
		return titol + "     " + duradaString +  "     " + Etiquetes() + "     " + url; 
	}
	
	public EstatReproduccio getEstatReproduccio() {
		return estatReproduccio;
	}
	
	public boolean videoaturat() {
		return videoaturat;
	}

//PLAY, PAUSE, STOP i RESET VIDEO
	public void pausaVideo() {
		estatReproduccio = EstatReproduccio.PAUSE;
	}
	public void playVideo() {
		videoaturat = false; 
		estatReproduccio = EstatReproduccio.PLAY;
	}
	
	public void stopVideo() {
		videoaturat = true; 
		estatReproduccio = EstatReproduccio.STOP;
	}
	public void reset() {
		videoaturat = false; 
		estatReproduccio = EstatReproduccio.PLAY; 
	}


//UPLOAD VIDEO
	public void penjaVideo() {
		estatUpload=EstatUpload.UPLOADING;
		System.out.println(estatUpload + "...");
			try{    Thread.sleep(1000);  } catch(InterruptedException ex){    Thread.currentThread().interrupt();}
		estatUpload=EstatUpload.VERIFYING;
		System.out.println(estatUpload + "...");
			try{    Thread.sleep(1000);  } catch(InterruptedException ex){    Thread.currentThread().interrupt();}
		estatUpload=EstatUpload.PUBLIC;
		System.out.println(estatUpload);
	}
	


//FUNCIONS AUXILIARS
	//Converteix durada a segons. 
	public int duradaInt(String duradaString) {
		int hores = Integer.parseInt(duradaString.substring(0,2));
		int minuts = Integer.parseInt(duradaString.substring(3,5));
		int segons = Integer.parseInt(duradaString.substring(6,8));
		int duradaInt = (hores*3600) + (minuts*60) + segons; 
		return duradaInt;
	}
	
	//Genera una URL amb caràcters aleatoris. 
	public String generaURL() {
		String caracters ="abcdefghijklmnopqrstuvwxyz1234567890";
		int longitud = 10; 
		for(int i=0; i<longitud; i++) {
			char caracterAleatori = caracters.charAt((int)(Math.random()*caracters.length())); 
			url = caracterAleatori + url;
		}
		url = "videos.cat/" + url; 
		return url; 
}
}
