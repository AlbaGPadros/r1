import java.util.Arrays;
import java.util.Scanner;

public class Exercici {
Scanner entrada = new Scanner(System.in); 
	
	int nivell; 
	
	//N1
	String ciutat1; 
	String ciutat2; 
	String ciutat3; 
	String ciutat4; 
	String ciutat5; 
	String[] arrayCiutats = new String[5];
	String[] arrayCiutatsModificades = new String[5];
	char[] ciutatarray1;
	char[] ciutatarray2;
	char[] ciutatarray3;
	char[] ciutatarray4;
	char[] ciutatarray5;
	
	//N2
	int notes[][] = new int [5][3];
	double sumanotes;
	double mitjana;
	
	//N3
	int xifres;	
	int penultim=0;
	int ultim=1;
	int temp=0;

	//ESCOLLIR NIVELL I PORTAR ALS MÈTODES CORRESPONENTS
		public  void introNivell() {
		System.out.println("Quin nivell vols veure?");
		nivell=entrada.nextInt();
		escullNivell();
		}
		
		public void escullNivell() {
			switch(nivell) {
			case 1:
				System.out.println("NIVELL 1");
				introduirCiutats();
				break;
			case 2:
				System.out.println("NIVELL 2");
				introdueixNotes();
				introNivell();
				break;
			case 3:
				System.out.println("NIVELL 3");
				demanaFibonacci();
				break;
			default:
				System.out.println("Nivell Incorrecte");
				introNivell();
			}
		}
		
	// ***********************************NIVELL 1*************************************	
		//FASE1 i FASE 2
			//Introdueix les ciutats i mostra-les en pantalla. Desa-les com a elements de l'array
			public void introduirCiutats() {
				System.out.println("Introdueix la ciutat 1:");
				ciutat1 = entrada.next();
				arrayCiutats[0]=ciutat1;
				System.out.println("Introdueix la ciutat 2:");
				ciutat2 = entrada.next();
				arrayCiutats[1]=ciutat2; 
				System.out.println("Introdueix la ciutat 3:");
				ciutat3 = entrada.next();
				arrayCiutats[2]=ciutat3; 
				System.out.println("Introdueix la ciutat 4:");
				ciutat4 = entrada.next();
				arrayCiutats[3]=ciutat4; 
				System.out.println("Introdueix la ciutat 5:");
				ciutat5 = entrada.next();
				arrayCiutats[4]=ciutat5; 

				System.out.println(ciutat1 + ", " + ciutat2 + ", " + ciutat3 + ", " + ciutat4+ ", " + ciutat5);
			CiutatsAlfabètic();
			}
			
		//FASE 2
			//Ordena alfabèticament les ciutats de l'Array. 
			public void CiutatsAlfabètic() {
				System.out.println("\n" + "Ciutats ordenades per ordre alfabètic:");
				Arrays.sort(arrayCiutats);
				for (String ciutat:arrayCiutats) {
					System.out.println(ciutat);
				}
				ciutatsModificades();
			}
			
		//FASE 3
			//Reemplaça les a per 4 i desales a l'array ciutats modificades; 
			public void ciutatsModificades() {
				System.out.println("\n" + "Ciutats modificades per ordre alfabètic:");
				for (int i=0; i < arrayCiutats.length; i++) {
					arrayCiutatsModificades[i] =arrayCiutats[i].replace('a','4');
					System.out.println(arrayCiutatsModificades[i]);
				}
				ordenaCaracters();
			}
			
		//FASE 4
			public void ordenaCaracters() {
				//Declara un array de caràcters per cada nom de ciutat
				ciutatarray1 = new char[ciutat1.length()];
				ciutatarray2 = new char[ciutat2.length()];
				ciutatarray3 = new char[ciutat3.length()];
				ciutatarray4 = new char[ciutat4.length()];
				ciutatarray5 = new char[ciutat5.length()];
				//omple els arrays de caràcters lletra a lletra
				int j= 0; 
					for(int i = ciutatarray1.length-1; i >= 0; i--) {
						ciutatarray1[j] = ciutat1.charAt(i);
						j++;
					}
					j= 0; 
					
					for(int i = ciutatarray2.length-1; i >= 0; i--) {
						ciutatarray2[j] = ciutat2.charAt(i);
						j++;
					}
					j= 0;
					
					for(int i = ciutatarray3.length-1; i >= 0; i--) {
						ciutatarray3[j] = ciutat3.charAt(i);
						j++;
					}
					j= 0; 

					for(int i = ciutatarray4.length-1; i >= 0; i--) {
						ciutatarray4[j] = ciutat4.charAt(i);
						j++;
					}
					j= 0; 

					for(int i = ciutatarray5.length-1; i >= 0; i--) {
						ciutatarray5[j] = ciutat5.charAt(i);
						j++;
					}
					
				//Imprimeix el resultat de la reordenació.
				System.out.println("\n" + "Ciutats amb els noms invertits:");
				System.out.println(ciutatarray1);
				System.out.println(ciutatarray2);
				System.out.println(ciutatarray3);
				System.out.println(ciutatarray4);
				System.out.println(ciutatarray5);
				
				System.out.println("\n" + "Fi de l'exercici" + "\n");
				introNivell();
			}
			
	// ***********************************NIVELL 2*************************************	
			
			public void introdueixNotes() {
				System.out.println("\n" + "CALCULADORA DE NOTES");
				
				//Demana les notes de cada alumne i guarda-les a la posició corresponent de l'array
				System.out.println("Introdueix la nota 1 de l'alumne 1");
				notes[0][0] = entrada.nextInt();
				System.out.println("Introdueix la nota 2 de l'alumne 1");
				notes[0][1] = entrada.nextInt();
				System.out.println("Introdueix la nota 3 de l'alumne 1");
				notes[0][2] = entrada.nextInt();
				
				System.out.println("Introdueix la nota 1 de l'alumne 2");
				notes[1][0] = entrada.nextInt();
				System.out.println("Introdueix la nota 2 de l'alumne 2");
				notes[1][1] = entrada.nextInt();
				System.out.println("Introdueix la nota 3 de l'alumne 2");
				notes[1][2] = entrada.nextInt();
				
				System.out.println("Introdueix la nota 1 de l'alumne 3");
				notes[2][0] = entrada.nextInt();
				System.out.println("Introdueix la nota 2 de l'alumne 3");
				notes[2][1] = entrada.nextInt();
				System.out.println("Introdueix la nota 3 de l'alumne 3");
				notes[2][2] = entrada.nextInt();
				
				System.out.println("Introdueix la nota 1 de l'alumne 4");
				notes[3][0] = entrada.nextInt();
				System.out.println("Introdueix la nota 2 de l'alumne 4");
				notes[3][1] = entrada.nextInt();
				System.out.println("Introdueix la nota 3 de l'alumne 4");
				notes[3][2] = entrada.nextInt();
				
				System.out.println("Introdueix la nota 1 de l'alumne 5");
				notes[4][0] = entrada.nextInt();
				System.out.println("Introdueix la nota 2 de l'alumne 5");
				notes[4][1] = entrada.nextInt();
				System.out.println("Introdueix la nota 3 de l'alumne 5");
				notes[4][2] = entrada.nextInt();
				
				comprovaNotes();
			}

			//Comprova que no hi hagi cap nota ni major de 10 ni menor de 0; si n'hi ha alguna, imprimeix un error i demana tornar a introduir
			public void comprovaNotes() {	
				for (int i = 0; i <notes.length; i++) {
					for (int j=0; j<notes[i].length; j++) {
						if (notes[i][j] > 10 || notes[i][j] <0) {
							System.out.println("Hi ha hagut un error a la nota " + (j+1) + " de l'alumne " + (i+1));
							introdueixNotes();
							break; //Torna al primer mètode i surt del loop si hi ha algun error
						} 
					}
				}
				calculaNotes(); //només es calcularà si no hi ha hagut cap error. 
			}

			//Calcula la mitjana de les tres notes de cada alumne
			public void calculaNotes() {
				for (int i=0; i<notes.length; i++ ) {
					for(int j =0; j<notes[i].length; j++) {
						sumanotes = sumanotes + notes[i][j];
					}
					//Calcula la mitjana i imprimeix si és aprovat o suspès
					mitjana = sumanotes / notes[i].length;
					if (mitjana < 5) {
						System.out.print("L'alumne " + (i+1) +" ha suspès amb un " );
						System.out.printf("%.2f%n", mitjana);
					}
					else {
						System.out.print("L'alumne " + (i+1) +" ha aprovat amb un " );
						System.out.printf("%.2f%n", mitjana);
					}
					sumanotes=0; //reinicia sumanotes a 0, per tal que no arrossegui la suma anterior. 
			
				}
			System.out.println("\n" + "Fi de l'exercici" + "\n");
			introNivell();
			}

			
	// ***********************************NIVELL 3*************************************	
			public void demanaFibonacci(){
				System.out.println("SUCCESSIÓ DE FIBONACCI");
				System.out.println("Quantes xifres vols?");
				xifres = entrada.nextInt();
				calculaFibonacci();
			}
			
			public void calculaFibonacci() {
				System.out.println(xifres + " xifres de la successió de Fibonacci:");
				System.out.print(penultim + " ");
				System.out.print(ultim + " ");
				for (int i =0; i<xifres-2; i++) {
					temp = penultim + ultim;
					penultim = ultim; 
					ultim = temp;
					System.out.print(ultim + " ");
				}
			System.out.println("\n" + "Fi de l'exercici" + "\n");
			introNivell();	
			}
}

