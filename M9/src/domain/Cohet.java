package domain;

public class Cohet {
String id;
int numPropulsors; 
int posArray=0; 
Propulsor arrayPropulsors[];
Propulsor propulsor; 


int velocitatAct = 0; 
int velocitatObj; 

public Cohet(String id, int numPropulsors) {
	this.id = id; 
	this.numPropulsors = numPropulsors;	
	arrayPropulsors = new Propulsor[numPropulsors];
}

//GETTERS
public String getId() {
	return id; 
}
public int getNumPropulsors() {
	return numPropulsors; 
}
public int getVelocitatAct() {
	return velocitatAct; 
}
public int getVelocitatObj() {
	return velocitatObj;
}
public Propulsor[] arrayPropulsors(){
	return arrayPropulsors; 
}

//SETTERS
public void setVelocitatObj(int velocitatObj) {
	this.velocitatObj = velocitatObj; 
}

//PROPULSORS
public void creaPropulsors(int potenciaMax) {
	propulsor = new Propulsor(id, (posArray+1), potenciaMax); 
	arrayPropulsors[posArray]=propulsor;
	posArray++; 
}

public String getPotenciaMaxProp() {
	String potenciaMaxProp =" ";
	for (int i = 0; i<arrayPropulsors.length; i++) {
		potenciaMaxProp = potenciaMaxProp + arrayPropulsors[i].getPotenciaMax() + " ";
	}
	return potenciaMaxProp; 
}


//VELOCITAT A POTÈNCIA
public void velocitatAPotencia() {
	int potenciaTotal; 
	potenciaTotal= (int) Math.pow(((velocitatObj-velocitatAct)/100),2); 
	//System.out.println(potenciaTotal);
	assignarPotencia(potenciaTotal);
}

public void assignarPotencia(int potenciaTotal) {
	int potenciaRestant = potenciaTotal;
	for (int i = 0; i<arrayPropulsors.length; i++) {
		if(potenciaRestant>=arrayPropulsors[i].getPotenciaMax()) {
			arrayPropulsors[i].setPotenciaObj(arrayPropulsors[i].getPotenciaMax());
			potenciaRestant = potenciaRestant - arrayPropulsors[i].getPotenciaObj(); 
		} else if((potenciaRestant<arrayPropulsors[i].getPotenciaMax()) && (potenciaRestant >= 0)) {
			arrayPropulsors[i].setPotenciaObj(potenciaRestant);
			potenciaRestant = potenciaRestant - arrayPropulsors[i].getPotenciaObj();
		} else if(potenciaRestant==0){
			System.out.println("Potencia 0");
			break; 
		}
	}
	if (potenciaRestant==0) {
	} else {
		System.out.println("El cohet "+ id+ " no disposa de prou potencia");
	}
}
public void enMarxa() {
	for (int i = 0; i<arrayPropulsors.length; i++) {
		arrayPropulsors[i].marxa();
	}
}

public void canviaAcceleracio(int acceleracio) {
	for (int i = 0; i<arrayPropulsors.length; i++) {
		arrayPropulsors[i].canviaAcceleracio(acceleracio);
	}
}

//això segurament VA FORA
public String infoPropulsors() {
	String infoPropulsors = "";
	for (int i = 1; i<arrayPropulsors.length; i++) {
		infoPropulsors = arrayPropulsors[i].getPotenciaAct() + "  " + arrayPropulsors[i].getPotenciaObj()+ "\n";
		//arrayPropulsors[i].marxa();
	}
	return infoPropulsors;
	
}

}
