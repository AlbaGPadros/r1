package m1;

import java.lang.invoke.SwitchPoint;
import java.util.Scanner;
public class M1 {

	public static void main(String[] args) {

		//Variables n1
		String nom = "Alba";
		String cognom1 = "Gonzalez"; 
		String cognom2 = "Padros";
		String nomComplet = nom + " " + cognom1 + " "+ cognom2;
		int dia = 28;
		int mes = 6; 
		int anyNaixement = 1993;
		String dataCompleta= dia + "/" + mes + "/" + anyNaixement;

		int anyInicial = 1948;
		int traspas = 4;
		int anysTraspas = 0;
		int totalAnysTraspas = 0;
		boolean esTraspas;
		String sEsTraspas = "L'any " + anyNaixement + " és de traspàs";
		String sNoEsTraspas = "L'any " + anyNaixement + " no és de traspàs";	
		
		//Variables n2
		double vDouble = 3.1234; 
		int vInt; 
		float vFloat; 
		String vString; 
		
		//Variables n3
		int[] array = new int[10];
		int temp = 0;

	//Nivell 1	
		System.out.println("NIVELL 1:");
		
		//imprimeix anys de traspàs i calcula el total d'anys
		System.out.println("Anys de traspas des de " + anyInicial + " a " + anyNaixement + ":");
		for (anysTraspas = anyInicial; anysTraspas < anyNaixement; anysTraspas = anysTraspas + traspas) {
			System.out.print(anysTraspas + " ");
			totalAnysTraspas++;		
		}
		System.out.println("\nNombre d\'anys de traspàs des de " + anyInicial + " a " + anyNaixement + ": " + totalAnysTraspas);
		
		//imprimeix nom i data
		System.out.println(nomComplet);
		System.out.println(dataCompleta);
		
		
		//calcula i imprimeix si l'any de naixement és de traspàs
		if ((anyNaixement -anyInicial)%4 == 0){
			esTraspas = true;
			System.out.println(sEsTraspas);
		}
		else {
			esTraspas = false;
			System.out.println(sNoEsTraspas);

		}
				

	//Nivell 2
		System.out.println("\n" + "NIVELL 2:");
		
		System.out.println(vDouble + " double");
		vInt = (int) vDouble;
		System.out.println(vInt + " int");
		
		vFloat = (float) vDouble;
		System.out.println(vFloat + " float");
		
		vString = Double.toString(vDouble); 
		System.out.println(vString + " String");

	//Nivell 3	
		System.out.println("\n" + "NIVELL 3:");
			//Array ascendent
			for (int i = 0; i<array.length; i++) {
				array[i]=i+1;
				System.out.print(array[i]+" ");
			}
				
			System.out.println(" ");
				
			//Inversió de l'array ascendent
			for (int i=0; i<array.length/2; i++) {
				temp = array[i];
				array[i]= array[array.length -i -1];
				array[array.length -i -1] = temp;	
			}
				
			//Visualitzar array invertit
			for (int i=0; i <array.length; i++) {
				System.out.print(array[i] + " ");
			}

	}
}
