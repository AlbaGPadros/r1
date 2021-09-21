package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

import domain.*;

public class FrameCohet extends JFrame{
JButton boto1; 
JButton boto2;
PanelCohet panel;
Cohet cohet1; 
Cohet cohet2;

public FrameCohet(){
	panel = new PanelCohet();
	this.add(panel);
	this.setTitle("M8-Cohets");
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setResizable(false);
	this.pack();
	this.setVisible(true);
	this.setLocationRelativeTo(null);
	//defineixBotons();
	//this.add(boto1);
	//this.add(boto2);
}
public int getVelocitat1(){
	return panel.getVelocitat1();
}
public int getVelocitat2(){
	return panel.getVelocitat2();
}
public int getAcceleracio1(){
	return panel.getAcceleracio1();
}
public int getAcceleracio2(){
	return panel.getAcceleracio2();
}
public int getModificacio() {
	return panel.getModificacio();
}
public void SetCohets(Cohet cohet1, Cohet cohet2){
	this.cohet1 = cohet1; 
	this.cohet2 = cohet2; 
	panel.setCohets(cohet1, cohet2);
}

/*
public void defineixBotons() {
	 boto1 = new JButton("NOUS PARÀMETRES"); 
	 boto2 = new JButton("NOUS PARÀMETRES"); 
	
	boto1.setForeground(Color.WHITE);
	boto1.setBackground(Color.red);
	boto2.setForeground(Color.WHITE);
	boto2.setBackground(Color.red);
	boto1.setBorder(null);
	boto2.setBorder(null);

	//boto1.setFont(font);
	//boto2.setFont(font);

	boto1.setBounds(200,450, 150, 150);
	boto2.setBounds(800,450, 150, 150);


}
*/
}
