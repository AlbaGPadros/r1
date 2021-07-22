import java.util.HashMap;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList; 

public class M4Exercici {

Scanner entrada= new Scanner(System.in);

//Fase1
int moneda1 = 0; 
int moneda2= 0; 
int bitllet5 = 0;
int bitllet10 = 0; 
int bitllet20 = 0; 
int bitllet50 = 0; 
int bitllet100 = 0; 
int bitllet200 = 0; 
int bitllet500 = 0; 
String plats[] = new String[10];
int preus[] = new int[10]; 

//Fase 2
int seguirDemanant =1; 
String StringseguirDemanant;
ArrayList<String> platsDemanats = new ArrayList<String>();
int comptadorPlats = 0; 
HashMap<String, Integer> preuPlat = new HashMap <String, Integer>(); 

//Fase 3
int preuTotal = 0; 
int preuResta = 0; 

//FASE 2
public void ompleArrays() {
		preuPlat.put("Tallarines", 7);
		preuPlat.put("Ramen", 10);
		preuPlat.put("Arros", 10);
		preuPlat.put("Fideus", 5);
		preuPlat.put("Gyozes", 4);
		preuPlat.put("Rotllets", 3);
		preuPlat.put("Algues", 8);
		preuPlat.put("Edamame", 5);
		preuPlat.put("Mochi", 3);
		preuPlat.put("Sushi", 11);
	//Omple els dos arrays mitjançant el Hashmap.	
	int i=0;
	for (String plat: preuPlat.keySet()) {
		plats[i] = plat;
		preus[i] = preuPlat.get(plat);
		i++;
	}
	
	//imprimeix els arrays en un format fàcil de llegir
	for (i=0; i < plats.length; i++) {
		System.out.println(plats[i] + " - " + preus[i] + "€");
	}
	demanaPlats();
	}

//Demana introduir els plats, comprova que estiguin a la llista. 
public void demanaPlats() {
	do {
		seguirDemanant= 1; 
		System.out.println("Quins plats vols?");
		platsDemanats.add(entrada.next()); 
		comptadorPlats++; 
		
		//Comprova el darrer plat. 
		try {
			comprovaPlat(); 
			demanaSeguirDemanant();
		} catch (ExcepcioPlatNoExisteix e) {
			System.out.println(e.getMessage());
			platsDemanats.remove(platsDemanats.size()-1); //Elimina el plat de la llista
			comptadorPlats--;
			demanaPlats();
		} 
	} while (seguirDemanant!= 0);
	mostraPlats();
	}

//Demana si vol més plats
public void demanaSeguirDemanant() {
	System.out.println("Vols seguir demanant?");
	System.out.println("1. Si   /   0.No");
	   StringseguirDemanant = entrada.next(); 

	//Comprova la resposta
	 try {
		 comprovaseguirDemanant();	
	 } catch (ExcepcioRespostaIncorrecta e) {
		 System.out.println(e.getMessage());
		 demanaSeguirDemanant();
	 } catch (ExcepcioRespostaNumericaIncorrecta e) {
		 System.out.println(e.getMessage());
		 demanaSeguirDemanant();
	 }
}
	//Comprova el darrer plat introduït. Sino coincideix amb cap plat de l'array, llança una excepció. 
public void comprovaPlat() throws ExcepcioPlatNoExisteix{ 
	if(!Arrays.asList(plats).contains(platsDemanats.get(platsDemanats.size()-1))){
		throw new ExcepcioPlatNoExisteix(); 
	}
}

//Comprova la resposta introduïda. Si no és Si o No, llança una excepció. 
public void comprovaseguirDemanant() throws ExcepcioRespostaNumericaIncorrecta, ExcepcioRespostaIncorrecta{ 
	try {
		seguirDemanant = Integer.parseInt(StringseguirDemanant);
	} catch (NumberFormatException e) {
		throw new ExcepcioRespostaIncorrecta();
	}
	
	if (!(seguirDemanant==1||seguirDemanant==0)){
		throw new ExcepcioRespostaNumericaIncorrecta(); 
	}
	
}
//Mostra els plats demanats per comprovar que tot sigui correcte. 
public void mostraPlats() {
	System.out.println("Has demanat:");
	for(int i = 0; i<comptadorPlats; i++) {
		System.out.println(" - " +platsDemanats.get(i));
	}
	sumaPreu();
}
	//Mostra el total del preu per pantalla i calcula la manera més òptima de pagar-lo 
	//(Bitllets i monedes com més grans millor). 
public void sumaPreu() {
	for (int i =0; i < comptadorPlats; i++) {
		preuTotal = preuTotal + preuPlat.get(platsDemanats.get(i));
	}
	System.out.println("PREU: " + preuTotal + "€");
	preuResta = preuTotal; 
	System.out.println("Pots pagar-la amb:");
	bitllet500= preuTotal/500; 
	preuResta= preuTotal%500;
		if(bitllet500!=0) { //Només mostra les unitats que es faran servir. 
			System.out.println(bitllet500 + " Bitllets de 500€");
		}
	bitllet200= preuResta/200; 
	preuResta= preuResta%200;
		if(bitllet200!=0) {
			System.out.println(bitllet200 + " Bitllets de 200€");
		}
	bitllet100= preuResta/100; 
	preuResta= preuResta%100;
		if(bitllet100!=0) {
			System.out.println(bitllet100 + " Bitllets de 100€");
		}
	bitllet50= preuResta/50; 
	preuResta= preuResta%50;
		if(bitllet50!=0) {
			System.out.println(bitllet50 + " Bitllets de 50€");
		}
	bitllet20= preuResta/20; 
	preuResta= preuResta%20;
		if(bitllet20!=0) {
			System.out.println(bitllet20 + " Bitllets de 20€");
		}
	bitllet10= preuResta/10;
	preuResta= preuResta%10;	
		if(bitllet10!=0) {
			System.out.println(bitllet10 + " Bitllets de 10€");
		}
	bitllet5= preuResta/5; 
	preuResta= preuResta%5;
		if(bitllet5!=0) {
			System.out.println(bitllet5 + " Bitllets de 5€");
		}
	moneda2= preuResta/2; 
	preuResta= preuResta%2;
		if(moneda2!=0) {
			System.out.println(moneda2 + " Monedes de 2€");
		}
	moneda1= preuResta/1; 
		if(moneda1!=0) {
			System.out.println(moneda1 + " Monedes d'1€");
		}	
	System.out.println("\n" + "Moltes gràcies per venir!");
	System.exit(0); 
}


}




