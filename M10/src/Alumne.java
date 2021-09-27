
public class Alumne {
String nom;
int edat;
Alumne.Curs curs; 
public enum Curs {
	JAVA,
	REACT, 
	PHP,
}
double nota;


	public Alumne(String nom, String curs, int edat, double nota) {
		this.nom = nom; 
		this.edat = edat; 
		this.nota = nota; 
		setCurs(curs);
	}
	public void setCurs(String curs) {
		if (curs.equalsIgnoreCase("JAVA")) {
			this.curs= Curs.JAVA;
		}
		else if (curs.equalsIgnoreCase("REACT")) {
			this.curs = Curs.REACT;

		}
		else if (curs.equalsIgnoreCase("PHP")) {
			this.curs = Curs.PHP;
		}
	}
	
	public int getEdat() {
		return edat; 
	}
	
	public String getNom() {
		return nom; 
	}
	
	public double getNota() {
		return nota; 
	}
	
	public Curs getCurs() {
		return curs; 
	}
}
