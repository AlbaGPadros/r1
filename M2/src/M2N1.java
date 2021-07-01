import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.List;

public class M2N1 {
String nomString;
String cognomString; 
char[] nomArray;
char[] cognomArray;
ArrayList<Character> nomLlista = new ArrayList<Character>();
ArrayList<Character> cognomLlista = new ArrayList<Character>();
ArrayList<Character> nomCompletLlista = new ArrayList<Character>();
Scanner entrada = new Scanner(System.in);


//ArrayList <Character> nomLlista;

//FASE 1
	//Intro nom
	public void introdueixNom() {
		System.out.println("Introdueix el teu nom (només de pila)");
		nomString = entrada.next();
		converteixArray();
	}
	// converteix nom a String i mostra'l 
	public void converteixArray() {
		System.out.print("Nom com a array: ");
		nomArray = nomString.toCharArray(); 
		for (int i=0; i < nomArray.length; i++) {
			System.out.print(nomArray[i]+ ", ");
		}
	System.out.println("");
	taulaLlista();
	}

//FASE 2
	//Transforma array en un arraylist
	public void taulaLlista(){
		for(int i=0; i <nomArray.length; i++) {
			nomLlista.add(nomArray[i]);
		}
	System.out.println("Nom com a llista: " + nomLlista);
		iteracioComprovacio();
	}
	
//FASE 3	
	//itera els elements de l'arraylist i si hi ha nombres demana tornar a introduir el nombre;
	public void iteracioComprovacio() {
		System.out.println("\n"+ "Imprimeix si són vocal o consonant:");
		Iterator<Character> nomIteracio = nomLlista.iterator(); 
		while (nomIteracio.hasNext()) {
			char lletra = nomIteracio.next();
			//Comprova si es vocal
			if(lletra == 'a'|| lletra == 'e' || lletra == 'i' || lletra == 'o' || lletra == 'u'){  
				System.out.println(lletra + "   vocal");
			}
			//Comprova si es nombre
			else if(Character.isDigit(lletra)) { 
				System.out.println("Has introduït el caràcter " + lletra + ". Un nom no pot contenir nombres" );
				introdueixNom();			
			}
			//si es consonant
		    else {
		    	System.out.println(lletra + "   consonant");
		    }
		}	
		comptaLletres();
	}
	//Crea el HashMap
	public void comptaLletres() {
	System.out.println("\n"+ "Compta quantes lletres hi ha de cada:");
	HashMap <Character, Integer> nomHash = new HashMap <Character,Integer> ();
	for(int i = 0; i < nomArray.length; i++) {
		//Si el Hash conté la lletra, suma 1 al valor
		if(nomHash.containsKey(nomArray[i])) {
			nomHash.put(nomArray[i], nomHash.get(nomArray[i])+1);
		}
		//Si no la conté, afegeix-la i assigna-li 1 per valor
		else {
			nomHash.put(nomArray[i], 1);
		}
	}
	//imprimeix la taula generada
	for (Character lletra : nomHash.keySet()) {
		  System.out.println(lletra + ":   " + nomHash.get(lletra));
		}
	introdueixCognom();
	}
	
//FASE 4	
	//demana el cognom, converteix-lo a array de caràcters
	public void introdueixCognom() {
		System.out.println("Introdueix el teu cognom");
		cognomString = entrada.next();
		cognomArray = cognomString.toCharArray();
		cognomALlista();
	}
	
	//Converteix l'array cognom a una llista i fusiona les dues llistes
	public void cognomALlista() {
		for(int i=0; i <cognomArray.length; i++) {
			cognomLlista.add(cognomArray[i]);
		}
		nomCompletLlista.addAll(nomLlista);
		nomCompletLlista.add(' ');
		nomCompletLlista.addAll(cognomLlista);
	    System.out.print(nomCompletLlista);
		
	}
}
