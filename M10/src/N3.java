import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
public class N3 {
	ArrayList<Alumne> alumnes = new ArrayList<>();
	
//CREA ELS ALUMNES	
public void creaAlumes(){
	alumnes.add(new Alumne("Marta Perez", "JAVA", 37, 8.9));
	alumnes.add(new Alumne("Toni Pons", "REACT", 45, 7.1));
	alumnes.add(new Alumne("Cristina Solà", "PHP", 28, 5.4));
	alumnes.add(new Alumne("Esteve Pi", "REACT", 20, 4.8));
	alumnes.add(new Alumne("Helena Bosch", "JAVA", 17, 8.7));
	alumnes.add(new Alumne("Miquel Gonzalez", "JAVA", 54, 9.3));
	alumnes.add(new Alumne("Anna Gomez", "PHP", 38, 7.5));
	alumnes.add(new Alumne("Joan Perez", "REACT", 25, 6.4));
	alumnes.add(new Alumne("Maria Esteve", "JAVA", 41, 7.1));
	alumnes.add(new Alumne("Alícia Fernandez", "PHP", 43, 6.8));
}

//IMPRESSIÓ ENUNCIATS
public void exercici() {
	System.out.println("Nom i edat dels alumnes: ");
		nomEdat();
	System.out.println("\nLlistat d'alumnes que comencen amb \"A\":");
		comencaA();
	System.out.println("\nAlumnes amb més d'un 5:");
		aprovats();
	System.out.println("\nAlumnes amb més d'un 5, no de PHP:");
		aprovatsNoPHP();
	System.out.println("\nAlumnes majors d'edat que fan JAVA:");
		majorsJAVA();
}

//SELECCIÓ D'ALUMNES DE LA LLISTA
public void nomEdat() {
alumnes.stream()
		.forEach(alumne -> System.out.println(alumne.getNom() + ", " + alumne.getEdat())); 
}

public void comencaA() {
	ArrayList<Alumne> alumnesA = new ArrayList<>(); 
	alumnes.stream()
			.filter(alumne -> alumne.getNom().charAt(0)==('A'))
			.forEach(alumne -> alumnesA.add(alumne));

	alumnesA.stream()
			.forEach(alumne -> System.out.println(alumne.getNom()));
}

public void aprovats() {
alumnes.stream()
		.filter(alumne -> alumne.getNota() >= 5.0) 
		.forEach(alumne -> System.out.println(alumne.getNom() + ", " + alumne.getNota()));
}

public void aprovatsNoPHP() {
	alumnes.stream()
		.filter(alumne -> alumne.getNota() >= 5.0) 
		.filter(alumne -> !(alumne.getCurs().toString().equals("PHP")))
		.forEach(alumne -> System.out.println(alumne.getNom() + ", " + alumne.getCurs().name() + ", " +alumne.getNota()));
}

public void majorsJAVA() {
	alumnes.stream()
		.filter(alumne -> alumne.getEdat() >= 18) 
		.filter(alumne -> alumne.getCurs().toString().equals("JAVA"))
		.forEach(alumne -> System.out.println(alumne.getNom() + ", " + alumne.getEdat() + ", " +alumne.getCurs().name()));
}
}
