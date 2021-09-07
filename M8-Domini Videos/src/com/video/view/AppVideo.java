package com.video.view;

import com.video.application.*;
import java.util.Scanner;

public class AppVideo {

	public static void main(String[] args) {
		VideoController controller = new VideoController(); 
		Scanner entrada = new Scanner(System.in);
		String nom, cognom, password; 
		String duradaString, titol,  etiquetesEntreComes; 	
		boolean correcte = false; 
		String stringOpcio =""; 
		int opcio=0; 
		/*
		do { //INTRODUEIX INFO USUARI
			System.out.print("Nom:");
			nom = entrada.next(); 
			System.out.print("Cognom:");
			cognom = entrada.next(); 
			System.out.print("Password:");
			password = entrada.next(); 
				try{ controller.comprovaCampsBuitsUsuari(nom, cognom, password);
				correcte = true; 
				System.out.println("Èxit");
				} catch (CampsBuits e) { System.out.println(e);
				}
		} while (correcte = false);
		*/	
		controller.nouUsuari("Alba", "padrós", "1234");
		

		do {
			do {
				System.out.println("\n" +"1. Penjar vídeo");
				System.out.println("2. Visualitzar llistat de videos ");
				System.out.println("3. Sortir ");
			stringOpcio = entrada.next(); 
			} while(!controller.opcioCorrecta(stringOpcio));
		opcio = Integer.parseInt(stringOpcio); 
		switch(opcio) {
		case 1: controller.dadesVideo();
			break; 
		case 2: controller.llistatVideos();
			controller.reprodueixVideo();
			break; 
		case 3: System.exit(0);
		break;
		default: System.out.println("Introdueix una opció vàlida");
		break; 
		}} while (opcio !=3);	
	}

	
}
