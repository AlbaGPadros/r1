import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector.*;
import static java.util.stream.Collectors.*;

import java.lang.reflect.Array;


@FunctionalInterface
interface operacions
{
    float operacio(float x, float y);
}


public class N2 {
	
ArrayList<String> stringsRand;
ArrayList<String> stringsRand2;

String matriu[][] = new String[5][5];

//EXERCICIS FASE 1
public void exercicis() {
	System.out.println("\nReordenar per llargada:");
		imprimeixMatriu(llistaMatriu(reordenaPerLlargada(stringsRand)));
	System.out.println("\nReordenar per llargada Inversa:");
		imprimeixMatriu(llistaMatriu(reordenaPerLlargadaInv(stringsRand)));
	System.out.println("\nReordenar alfabèticament:");
		imprimeixMatriu(llistaMatriu(primerChar(stringsRand)));
	System.out.println("\nPrimer cadenes amb \"e\":");
		imprimeixMatriu(llistaMatriu(stringsE(stringsRand)));
	System.out.println("\nSubstituint les \"a\" per \"4\":");
		imprimeixMatriu(llistaMatriu(stringsA4(stringsRand)));
	System.out.println("\nRetorna només els strings numèrics:");
		stringsNum(stringsRand);
}

//CREA ARRAYLIST AMB STRINGS A L'ATZAR
public void creaLlistaRand() {
	Random random = new Random(); 
	Random random2 = new Random(); 
	String caracters ="abcdefghijklmnopqrstuvwxyz1234567890";
	String stringRand= "";
	stringsRand = new ArrayList<String>();
	stringsRand2 = new ArrayList<String>();

					
	for(int i=0; i < 25; i++) {
		stringRand="";
		for (int j=0; j<(random2.nextInt(10)+1); j++){
		char caracterAleatori = caracters.charAt(random.nextInt(caracters.length())); 
		stringRand = String.valueOf(caracterAleatori) + stringRand; 
		}
		stringsRand.add(stringRand);
	}
	}


//TRAMSFORMA A MATRIU
public String[][] llistaMatriu(ArrayList<String > llista) {
 
	int x= 0; 
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			matriu[i][j] = llista.get(x);
			x++; 
		}
	}
	return matriu;
}

public void imprimeixMatriu(String[][] matriu) {
	
	for (int i = 0; i < 5; i++) {
		System.out.print("[");
		for (int j = 0; j < 5; j++) {
			System.out.print("  " +matriu[i][j] + "  "); 
		}
		System.out.print("]");
		System.out.println("");
	}
}



//REORDENACIONS ARRAYLIST
public ArrayList<String> reordenaPerLlargada(ArrayList<String> stringsRand) {
	Collections.sort(stringsRand, Comparator.comparing(String::length));
	return stringsRand;    
}

public ArrayList<String> reordenaPerLlargadaInv(ArrayList<String> stringsRand) {
	Collections.sort(stringsRand, Comparator.comparing(String::length).reversed());
	return stringsRand; 
}

public ArrayList<String> primerChar(ArrayList<String> stringsRand) {
	Collections.sort(stringsRand, (a, b) -> Character.valueOf(a.charAt(0)) -Character.valueOf(b.charAt(0)));
	return stringsRand;
}

public ArrayList<String> stringsE(ArrayList<String> stringsRand) {
	Collections.sort(stringsRand, (a, b) -> Boolean.compare(!a.contains("e"), !b.contains("e")));
	return stringsRand;
}

public ArrayList<String> stringsA4(ArrayList<String> stringsRand) {
	ArrayList<String> stringsA4 = new ArrayList(); 
	stringsRand.forEach(a ->{stringsA4.add(a.replace('a', '4'));
							});
	return stringsA4;
}

public ArrayList<String> stringsNum(ArrayList<String> stringsRand) {
	ArrayList<String> stringsNum = new ArrayList(); 
	stringsRand.forEach(a ->{if (esNombre(a)){
							stringsNum.add(a);
							}
							});
	stringsNum.forEach(System.out::println);
	return stringsNum;
}

public boolean esNombre(String a) {
	try {
		Integer.parseInt(a);
		return true;
	} catch (Exception e) {
		return false; 
	}
}

//FASE 2
public void opera() {
	System.out.println("\nFase 2: operacions amb lambdes i functional interface");
	operacions suma = (a, b) -> a+b;
	System.out.println("3+4=" + suma.operacio(3,4));
	
	operacions resta = (a, b) -> a-b;
	System.out.println("3-4=" +resta.operacio(3,4));
	
	operacions multiplica = (a, b) -> a*b;
	System.out.println("3*4=" +multiplica.operacio(3,4));
	
	operacions divideix = (a, b) -> a/b;
	System.out.println("3/4=" +divideix.operacio(3,4));
}
}
