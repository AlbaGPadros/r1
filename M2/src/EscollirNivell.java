import java.util.Scanner;

public class EscollirNivell {
	
	Scanner entrada = new Scanner(System.in); 
	
	int nivell; 
	
	M2N1 nivell1 = new M2N1(); 
	M2N2 nivell2 = new M2N2(); 
	M2N3 nivell3 = new M2N3(); 

	public void introNivell() {
	System.out.println("Quin nivell vols veure?");
	nivell = entrada.nextInt(); 
	escullNivell();
	}
	
	public void escullNivell() {
		switch(nivell) {
		case 1:
			System.out.println("NIVELL 1");
			nivell1.introdueixNom();
			introNivell();
			break;
		case 2:
			System.out.println("NIVELL 2");
			nivell2.piramides();
			introNivell();
			break;
		case 3:
			System.out.println("NIVELL 3");
			nivell3.iniciaCronometre();
			break;
		default:
			System.out.println("Nivell Incorrecte");
			introNivell();
		}
	}

}
