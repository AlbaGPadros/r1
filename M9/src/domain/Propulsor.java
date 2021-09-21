package domain;

public class Propulsor {
String IdCohet; 
int numPropulsor; 
int potenciaMax;
int potenciaObj;
int potenciaAct= 0;
ThreadAccelerarFrenar accFre;
int acceleracio; 

public Propulsor(String idCohet, int numPropulsor, int potenciaMax) {
	this.potenciaMax = potenciaMax;
	this.IdCohet = idCohet;
	this.numPropulsor = numPropulsor;

}

//GETTERS
public int getPotenciaMax() {
	return potenciaMax; 
}
public int getPotenciaAct() {
	return potenciaAct; 	
}
public int getPotenciaObj() {
	return potenciaObj; 
}
public String getIdNum() {
	String idNum = IdCohet + " "+ numPropulsor;
	return idNum;
}
public void setPotenciaObjAcc() {
	potenciaObj=potenciaMax;
}

//SETTERS
public void setPotenciaAct(int potenciaAct) {
	this.potenciaAct=potenciaAct; 
}
public void setPotenciaObjFre() {
	potenciaObj=0;
}

public void setPotenciaObj(int potenciaObj) {
	this.potenciaObj=potenciaObj; 
}

//ARROSSEGA CANVI D'ACCELERACIÓ
public void canviaAcceleracio(int acceleracio) {
	this.acceleracio = acceleracio; 
}

//POSA EN MARXA EL THREAD
public void marxa() {
accFre = new ThreadAccelerarFrenar(this, acceleracio);
accFre.start();
}

public String stringEstat() {
	String stringEstat = potenciaAct + " / " + potenciaObj + "  MAX: " +potenciaMax;
	return stringEstat;
}
}
