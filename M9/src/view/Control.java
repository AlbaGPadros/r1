package view;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;


import application.CohetControl;
import domain.Cohet;


public class Control {
	
public static void main(String[] args) {
	//int modificacio	= 0; 

CohetControl control = new CohetControl();
control.creaPropulsors();
control.printInfo();
control.bucleCohet();
/*
while(true) {
	System.out.println(modificacio);
	if ((frame.getModificacio()> modificacio) && frame.getModificacio()%2!=0) {
		System.out.println("Cohet1 en Marxa");
	}
	else if((frame.getModificacio()> modificacio) && frame.getModificacio()%2==0) {
		System.out.println("Cohet2 en Marxa");
	}
	modificacio = frame.getModificacio();

}
*/


//control.VelocitatAPotencia1(2000);
//control.VelocitatAPotencia2(250000);

}


}

