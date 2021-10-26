package com.example.CRUD.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Treballador {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 	
	
	@Column(name="nom", nullable=false, length=30)
	String nom; 
	String cognom; 
	int salari; 

	@Enumerated(EnumType.ORDINAL)
	Feina feina;

public Treballador(int id, String nom, String cognom, Feina feina) {
	this.id=id;
	this.nom = nom;
	this.cognom = cognom; 
	this.feina = feina; 
	calculaSalari(feina);

}
public Treballador(int id, String nom, String cognom, int feinaInt) {
	this.id = id; 
	this.nom = nom;
	this.cognom = cognom; 
	feina=getFeinaFromInt(feinaInt);
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
		return 3;
		}
	if (feina.equals(feina.FRONTEND)) {
		return 0;
		}
	if (feina.equals(feina.TESTER)) {
		return 2;
		}
	else {
		return 4; 
	}
}

//CONVERTEIX D'INT A ENUM
public Feina getFeinaFromInt(int feinaInt) {
	if (feinaInt == 1) {
		return feina.BACKEND;
		}
	if (feinaInt == 3) {
		return feina.DATA;
		}
	if (feinaInt == 0) {
		return feina.FRONTEND;
		}
	if (feinaInt == 2)  {
		return feina.TESTER;
		}
	else return feina.BACKEND; 
}
}
