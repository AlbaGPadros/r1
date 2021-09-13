package com.video.application;

import java.util.Scanner;

import com.video.domain.*;

public class VideoController {
	private Scanner entrada = new Scanner(System.in);
	private String nom, cognom, password; 
	private String duradaString, titol,  etiquetesEntreComes; 
	private Usuari usuari; 
	private boolean duradaCorrecta; 
	
//NOU USUARI
	public void nouUsuari(String nom, String cognom, String Password) {
		usuari = new Usuari (nom, cognom, password);
	}
	
//INFO NOU VIDEO
	public void dadesVideo() {
		System.out.println("Títol:");
		titol = entrada.next(); 
		do {
			System.out.println("Durada (XX:XX:XX):");
			duradaString = entrada.next();
		} while (!duradaCorrecta(duradaString));
		System.out.println("Etiquetes (entre comes i sense espais):");
		etiquetesEntreComes = entrada.next();
		
		try{ comprovaCampsBuitsVideo();
		} catch (CampsBuits e) { System.out.println(e);
			dadesVideo();
		}	
		nouVideo(titol, duradaString);
	}
	
	
	public void nouVideo(String titol, String duradaString) {
		Video video = new Video(titol, duradaString); 
		video.generaURL();
		video.etiquetes(etiquetesEntreComes);
		usuari.afegeixVideo(video); 
		video.penjaVideo();
		System.out.println("Video afegit correctament");
	}
	
//Visualitza llistat de videos
	public void llistatVideos() {
		System.out.println("NUM   /   TITOL   /    DURADA   /   ETIQUETES   /   URL");
		for(int i=0; i< (usuari.getLlistatVideos().size()); i++) {
			System.out.println((i+1) + "   " + usuari.getLlistatVideos().get(i).getInfoVideo());
		}
	}
	
//REPRODUEIX VIDEO	
	public void reprodueixVideo() {
		ThreadReprodueix threadrep;
		ThreadPausarParar threadpp;
		int videoEscollit; 
		System.out.println("Vols reproduir algun video? Introdueix el número. Introdueix 0 si no vols reproduir res.");
		videoEscollit = entrada.nextInt();
		if(videoEscollit == 0) { 
		}
		else {
			threadrep = new ThreadReprodueix(usuari.getLlistatVideos().get(videoEscollit-1)); 
			threadpp = new ThreadPausarParar(usuari.getLlistatVideos().get(videoEscollit-1) );
			threadpp.start();
			threadrep.start();
			
			boolean stop= usuari.getLlistatVideos().get(videoEscollit-1).videoaturat();
			do {
				try{Thread.sleep(1000);} catch(Exception e) {}
				stop= usuari.getLlistatVideos().get(videoEscollit-1).videoaturat();
				if(stop) {
					break;
				}
			} while (!stop);
			usuari.getLlistatVideos().get(videoEscollit-1).reset();
		}	
	}
	
	
//COMPROVACIÓ D'ERRORS
	//Comprova camps buits
	public void comprovaCampsBuitsUsuari(String nom, String cognom, String password) throws CampsBuits {
		if (nom.equals("") || cognom.equals("") || password.equals("")) {
			throw new CampsBuits();
		};
	}
	public void comprovaCampsBuitsVideo() throws CampsBuits{
		if (duradaString.equals("") || titol.equals("") || etiquetesEntreComes.equals("")) {
			throw new CampsBuits();
		};
	}
	
	// Comprova opcio menu
	public boolean opcioCorrecta(String stringOpcio) {
		 boolean opcioCorrecta;
		 if((stringOpcio.equals("1"))	||(stringOpcio.equals("2")) || (stringOpcio.equals("3"))) {
			opcioCorrecta= true; 
		 } else {
			opcioCorrecta = false;
		 }
		 return opcioCorrecta; 
	}
	
	//Comprova format durada
	public boolean duradaCorrecta(String duradaString) {
		duradaCorrecta = duradaString.matches("\\d{2}:\\d{2}:\\d{2}");	
		return duradaCorrecta; 
	}
	
}
