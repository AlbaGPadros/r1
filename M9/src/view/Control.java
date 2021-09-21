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

}


}

