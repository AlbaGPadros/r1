import java.util.Scanner;

public class M2N2 {
public void piramides() {
	int files = 0;

	Scanner entrada = new Scanner(System.in);
	
	System.out.println("Quantes files vols?");
	files = entrada.nextInt();
	int asteriscs = ((files-1)*2)+1;
	int espais = 0;
	
	//Piràmide de nombres
	System.out.print("PIRÀMIDE DE NOMBRES");
	for (int i = 0; i <=files; i++) {
		for (int j=0; j < i; j++) {
			System.out.print(j+1);
		}
		System.out.println("");
	}
	
	//Piràmide d'asteriscs
	System.out.println("\n" + "PIRÀMIDE D'ASTERISCS");
	for (int alcada = 1; alcada <=files; alcada ++) {
		
		for (espais = 1; espais < alcada ; espais++) {
			System.out.print(" ");
		}
		for (int j=asteriscs; j>0; j--) {
			System.out.print("*");
		}
		asteriscs=asteriscs-2;
		System.out.println("");
	}
}
}
