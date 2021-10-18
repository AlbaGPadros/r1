package com.example.CRUD.bean;

public class Treballador {
	public int id; 
	String nom; 
	String cognom; 
	int salari; 
	Feina feina; 
	int feinaInt; 
	
	
public Treballador(int id, String nom, String cognom, Feina feina) {
	this.id = id; 
	this.nom = nom;
	this.cognom = cognom; 
	this.feina=feina; 
	calculaSalari(feina);
}
public Treballador(int id, String nom, String cognom, int feinaInt) {
	this.id = id; 
	this.nom = nom;
	this.cognom = cognom; 
	feina = setFeinaInt(feinaInt);
	calculaSalari(feina);
}


public Treballador() {}

public void calculaSalari(Feina feina) {
	if (feina == feina.BACKEND) {
		salari=24000; 
	} else if (feina == feina.FRONTEND) {
		salari=25000; 
	} else if (feina == feina.TESTER) {
		salari=20000; 
	} else if (feina == feina.DATA) {
		salari=30000; 
	}
}

@Override
public String toString() {
	return "Treballador [id=" + id + ", nom=" + nom + ", cognom=" + cognom + ", salari=" + salari + ", feina=" + feina
			+ "]";
}

//GETTERS I SETTERS
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getCognom() {
	return cognom;
}

public void setCognom(String cognom) {
	this.cognom = cognom;
}

public int getSalari() {
	return salari;
}

public void setSalari(int salari) {
	this.salari = salari;
}

public Feina getFeina() {
	return feina;
}

public void setFeina(Feina feina) {
	this.feina = feina;
	calculaSalari(feina);
}


//CONVERTEIX D'ENUM A INT
public int getFeinaInt() {
	if (feina.equals(feina.BACKEND)) {
		return 1;
		}
	if (feina.equals(feina.DATA)) {
		return 1;
		}
	if (feina.equals(feina.FRONTEND)) {
		return 1;
		}
	if (feina.equals(feina.TESTER)) {
		return 1;
		}
	else {
		return 0; 
	}
}

//CONVERTEIX D'INT A ENUM
public Feina setFeinaInt(int feinaInt) {
	if (feinaInt == 1) {
		return feina.BACKEND;
		}
	if (feinaInt == 2) {
		return feina.DATA;
		}
	if (feinaInt == 3) {
		return feina.FRONTEND;
		}
	else {
		return feina.TESTER;
		}
}
}
