package application;

import domain.Cohet;
import view.FrameCohet;

public class CohetControl {

	Cohet cohet1 = new Cohet("32WESSDS",3);
	Cohet cohet2 = new Cohet("LDSFJA32",6);
	int modificacio=0; 
	FrameCohet frame; 
	
	public void creaPropulsors() {
		cohet1.creaPropulsors(10);
		cohet1.creaPropulsors(30);
		cohet1.creaPropulsors(80);
	
		cohet2.creaPropulsors(30);
		cohet2.creaPropulsors(40);
		cohet2.creaPropulsors(50);
		cohet2.creaPropulsors(50);
		cohet2.creaPropulsors(30);
		cohet2.creaPropulsors(10);
		
		//POTSER S'HAURIA DE POSAR A UNA ALTRA CLASSE
		frame = new FrameCohet();
		frame.SetCohets(cohet1, cohet2);
	}
	
	//Imprimeix informaci� inicial cohet
	public void printInfo(){
		System.out.println("Rocket id =" +cohet1.getId() + ": T� " + cohet1.getNumPropulsors()+ " propulsoes");
		System.out.println("Propulsors: [" + cohet1.getPotenciaMaxProp()+"]");
		System.out.println("Rocket id =" +cohet2.getId() + ": T� " + cohet2.getNumPropulsors()+ " propulsoes");
		System.out.println("Propulsors: [" + cohet2.getPotenciaMaxProp()+"]");
	}
	
	//ESCOLTA MODIFICACIONS DEL PANELL
	public void bucleCohet() {
		while(true) {
			if ((frame.getModificacio()> modificacio) && frame.getModificacio()%2!=0) {
				canviaAcceleracio(frame.getAcceleracio1(), 1);
				velocitatAPotencia(frame.getVelocitat1(), 1);
			}
			else if((frame.getModificacio()> modificacio) && frame.getModificacio()%2==0) {
				canviaAcceleracio(frame.getAcceleracio2(), 2);
				velocitatAPotencia(frame.getVelocitat2(),2);

			}
			modificacio = frame.getModificacio();
			try{Thread.sleep(500);} catch(Exception e) {};
		}
	}

	//TRANSFORMA V a P (per despr�s repartir-la)
	public void velocitatAPotencia(int velocitatObjectiu, int cohet) {
		if(cohet ==1) {
			cohet1.setVelocitatObj(velocitatObjectiu);
			cohet1.velocitatAPotencia();
			cohet1.enMarxa();
		}
		else if (cohet ==2) {
			cohet2.setVelocitatObj(velocitatObjectiu);
			cohet2.velocitatAPotencia();
			cohet2.enMarxa(); 
		}
	}

	//CANVI VALOR DE L'ACCELERACI�
	public void canviaAcceleracio(int acceleracio, int cohet) {
		if (cohet ==1) {
			cohet1.canviaAcceleracio(acceleracio);
		}
		else if (cohet ==2) {
			cohet2.canviaAcceleracio(acceleracio);
		}
	}

	//RETORNA INFO PROPULSORS (per al frame)
	public String infoPropulsors1() {
		return cohet1.infoPropulsors();
	}
	
	public String infoPropulsors2() {
		return cohet2.infoPropulsors();
	}

}
