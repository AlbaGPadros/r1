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
	
	public void printInfo(){
		System.out.println("Rocket id =" +cohet1.getId() + ": Té " + cohet1.getNumPropulsors()+ " propulsoes");
		System.out.println("Propulsors: [" + cohet1.getPotenciaMaxProp()+"]");
		System.out.println("Rocket id =" +cohet2.getId() + ": Té " + cohet2.getNumPropulsors()+ " propulsoes");
		System.out.println("Propulsors: [" + cohet2.getPotenciaMaxProp()+"]");
	}
	
	public void bucleCohet() {
		while(true) {
			if ((frame.getModificacio()> modificacio) && frame.getModificacio()%2!=0) {
				canviaAcceleracio1(frame.getAcceleracio1());
				VelocitatAPotencia1(frame.getVelocitat1());
			}
			else if((frame.getModificacio()> modificacio) && frame.getModificacio()%2==0) {
				canviaAcceleracio2(frame.getAcceleracio2());
				VelocitatAPotencia2(frame.getVelocitat2());

			}
			modificacio = frame.getModificacio();
			try{Thread.sleep(500);} catch(Exception e) {};
		}
	}


	public void VelocitatAPotencia1(int velocitatObjectiu) {
		cohet1.setVelocitatObj(velocitatObjectiu);
		cohet1.velocitatAPotencia();
		cohet1.enMarxa();
	}
	public void VelocitatAPotencia2(int velocitatObjectiu) {
		cohet2.setVelocitatObj(velocitatObjectiu);
		cohet2.velocitatAPotencia();
		cohet2.enMarxa(); 
	}
	
	public void canviaAcceleracio1(int acceleracio) {
		cohet1.canviaAcceleracio(acceleracio);
	}
	
	public void canviaAcceleracio2(int acceleracio) {
		cohet2.canviaAcceleracio(acceleracio);
	}


	public String infoPropulsors1() {
		return cohet1.infoPropulsors();
	}
	
	public String infoPropulsors2() {
		return cohet2.infoPropulsors();
	}

}
