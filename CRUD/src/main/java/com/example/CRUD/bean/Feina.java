package com.example.CRUD.bean;

public enum Feina {
	FRONTEND("FRONT-END"), 
	BACKEND("BACK-END"),
	TESTER("TESTER"),
	DATA("DATA"); 
	
	public String nom; 
	
	private Feina(String carrec) {
		this.nom =carrec;
	}
	
	public String getNom() {
		return nom; 
	}
	
	public void setNom(String carrec) {
		this.nom = carrec; 
	}
}
