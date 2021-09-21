package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.chrono.IsoChronology;

import javax.swing.*;

import domain.Cohet; 


public class PanelCohet extends JPanel implements ActionListener{
	
	Color blauEspai = new Color(1, 10, 75); // Color white
	Color blauBotons = new Color(50, 60, 133);
	int width = 1200; 
	int height = 600; 
	JFrame frame;
	JPanel panel;
	JButton boto1, boto2; 
	JLabel cohet1, cohet2; 
	Font font = new Font("Montserrat", Font.BOLD, 15);
	JSlider sliderv1, sliderv2, slidera1, slidera2; 
	JLabel vel, velc2, vel1, vel2, vel3, vel4, acc, accc2, acc1, acc2, acc3, acc4; 
	String prova; 
	
	int velocitat1, velocitat2, acceleracio1, acceleracio2; 
	int modificacio = 0; 

	Cohet oCohet1; 
	Cohet oCohet2;
public PanelCohet() {
	this.setPreferredSize(new Dimension(width, height));
	this.setBackground(blauEspai);
	this.setVisible(true);
	this.setFocusable(true);
	this.setLayout(null);
	
	
	defineixBotons();
		this.add(boto1); this.add(boto2);
	defineixLabels();
		this.add(cohet1); this.add(cohet2);
	defineixSlider();
		this.add(sliderv1); this.add(sliderv2); this.add(slidera1); this.add(slidera2);
	defineixLabelsAccVel();
		this.add(vel); this.add(velc2); this.add(vel1); this.add(vel2); this.add(vel3); this.add(vel4); 
		this.add(acc); this.add(accc2); this.add(acc1); this.add(acc2); this.add(acc3); this.add(acc4); 

	this.setVisible(true);
	}

public void paintComponent(Graphics g) {
	super.paintComponent(g);
	
	draw(g);
	
}

public void draw(Graphics g) {
	//Graphics2D g2d = (Graphics2D) g;
	int altProp1 = 200; 
	int altProp2 = 150; 

	g.setColor(blauBotons);
	((Graphics2D) g).setStroke(new BasicStroke((float) 3.0));
	g.drawLine(width/2, 0, width/2, height);
	g.setColor(Color.white);
	g.setFont(font);
	for(int i=0; i< oCohet1.arrayPropulsors().length; i++) {
		g.setColor(Color.white);
 
		g.drawString(oCohet1.arrayPropulsors()[i].getPotenciaAct() + " / "+ oCohet1.arrayPropulsors()[i].getPotenciaObj() + "   MAX: " + oCohet1.arrayPropulsors()[i].getPotenciaMax(), 450, altProp1);
		if((oCohet1.arrayPropulsors()[i].getPotenciaAct() == oCohet1.arrayPropulsors()[i].getPotenciaObj())&& oCohet1.arrayPropulsors()[i].getPotenciaObj() != 0) {
			g.setColor(new Color(51, 204, 51));
			g.fillOval(410, altProp1-15, 15, 15);
		} else {
			g.setColor(Color.black);
			g.fillOval(410, altProp1-15, 15, 15);
		}
		altProp1+=50;
	}
	
	for(int i=0; i< oCohet2.arrayPropulsors().length; i++) {
		g.setColor(Color.white);
		g.drawString(oCohet2.arrayPropulsors()[i].getPotenciaAct() +" / "+ oCohet2.arrayPropulsors()[i].getPotenciaObj() + "   MAX: " + oCohet2.arrayPropulsors()[i].getPotenciaMax(), 1050, altProp2);
		if((oCohet2.arrayPropulsors()[i].getPotenciaAct() == oCohet2.arrayPropulsors()[i].getPotenciaObj())&& oCohet2.arrayPropulsors()[i].getPotenciaObj() != 0) {
			g.setColor(new Color(51, 204, 51));
			g.fillOval(1010, altProp2-15, 15, 15);
		} else {
			g.setColor(Color.black);
			g.fillOval(1010, altProp2-15, 15, 15);
		}
		altProp2+=50;
	}
	repaint();
}

public void setCohets(Cohet cohet1, Cohet cohet2) {
	oCohet1 = cohet1; 
	oCohet2 = cohet2; 
}

public void defineixBotons() {
	 boto1 = new JButton("NOUS PARÀMETRES"); 
	 boto2 = new JButton("NOUS PARÀMETRES"); 
	
	boto1.setForeground(Color.WHITE);
	boto1.setBackground(blauBotons);
	boto2.setForeground(Color.WHITE);
	boto2.setBackground(blauBotons);
	boto1.setBorder(null);
	boto2.setBorder(null);

	boto1.setFont(font);
	boto2.setFont(font);
	boto1.setBounds(200,450, 200, 100);
	boto2.setBounds(800,450, 200, 100);
	
	boto1.addActionListener(this);
	boto2.addActionListener(this);
}

public void defineixLabels() {
	cohet1 = new JLabel("32WESSDS");
	cohet2 = new JLabel("LDSFJA32");
	cohet1.setFont(new Font("Montserrat", Font.BOLD, 30));	
	cohet2.setFont(new Font("Montserrat", Font.BOLD, 30));	
	cohet1.setForeground(Color.WHITE);
	cohet2.setForeground(Color.WHITE);
	cohet1.setBounds(200, 0, 200, 100);
	cohet2.setBounds(800, 0, 200, 100);
}

public void defineixSlider() {
	sliderv1= new JSlider(0,1500); 
	sliderv1.setBounds(60,320,300,50);
	sliderv1.setBackground(blauEspai);
	
	sliderv2= new JSlider(0,1500); 
	sliderv2.setBounds(660,320,300,50);
	sliderv2.setBackground(blauEspai);
	
	slidera1= new JSlider(1,10); 
	slidera1.setBounds(60,150,300,50);
	slidera1.setBackground(blauEspai);
	
	slidera2= new JSlider(1,10); 
	slidera2.setBounds(660,150,300,50);
	slidera2.setBackground(blauEspai);
}

public void defineixLabelsAccVel() {
	vel = new JLabel("VELOCITAT");
	velc2 =new JLabel("VELOCITAT");
	vel1 = new JLabel("0");
	vel2 = new JLabel("1500");
	vel3 = new JLabel("0");
	vel4 = new JLabel("1500");
	acc = new JLabel("ACCELERACIÓ");
	accc2 = new JLabel("ACCELERACIÓ");
	acc1 = new JLabel("1");
	acc2 = new JLabel("10");
	acc3 = new JLabel("1");
	acc4 = new JLabel("10");

	vel.setForeground(Color.WHITE);
	velc2.setForeground(Color.WHITE);
	vel1.setForeground(Color.WHITE);
	vel2.setForeground(Color.WHITE);
	vel3.setForeground(Color.WHITE);
	vel4.setForeground(Color.WHITE);
	acc.setForeground(Color.WHITE);
	accc2.setForeground(Color.WHITE);
	acc1.setForeground(Color.WHITE);
	acc2.setForeground(Color.WHITE);
	acc3.setForeground(Color.WHITE);
	acc4.setForeground(Color.WHITE);

	vel.setFont(new Font("Montserrat", Font.BOLD, 20));
	velc2.setFont(new Font("Montserrat", Font.BOLD, 20));
	vel1.setFont(new Font("Montserrat", Font.BOLD, 15));
	vel2.setFont(new Font("Montserrat", Font.BOLD, 15));	
	vel3.setFont(new Font("Montserrat", Font.BOLD, 15));	
	vel4.setFont(new Font("Montserrat", Font.BOLD, 15));
	acc.setFont(new Font("Montserrat", Font.BOLD, 20));
	accc2.setFont(new Font("Montserrat", Font.BOLD, 20));
	acc1.setFont(new Font("Montserrat", Font.BOLD, 15));
	acc2.setFont(new Font("Montserrat", Font.BOLD, 15));	
	acc3.setFont(new Font("Montserrat", Font.BOLD, 15));	
	acc4.setFont(new Font("Montserrat", Font.BOLD, 15));

	vel.setBounds(150, 250, 300, 100);
	velc2.setBounds(750, 250, 300, 100);
	vel1.setBounds(60, 330, 200, 100);
	vel2.setBounds(320, 330, 200, 100);
	vel3.setBounds(660, 330, 200, 100);
	vel4.setBounds(920, 330, 200, 100);
	acc.setBounds(150, 70, 300, 100);
	accc2.setBounds(750, 70, 300, 100);
	acc1.setBounds(60, 160, 200, 100);
	acc2.setBounds(340, 160, 200, 100);
	acc3.setBounds(660, 160, 200, 100);
	acc4.setBounds(940, 160, 200, 100);


}

public void actionPerformed(ActionEvent e) {
	 if(e.getSource() == boto1) {
		 velocitat1 = sliderv1.getValue();
		 acceleracio1 = slidera1.getValue();
		 if (modificacio%2==0) {
			 modificacio++;
		 }
		 if (modificacio%2!=0) {
			 modificacio = modificacio +2;
		 }
	 } else if(e.getSource()== boto2) {
		 velocitat2 = sliderv2.getValue();
		 acceleracio2 = slidera2.getValue();
		 if (modificacio%2==0) {
			 modificacio = modificacio +2;
		 }
		 if (modificacio%2!=0) {
			 modificacio++;
		 }
	 }
}
//GETTERS
public int getVelocitat1(){
	return velocitat1;
}
public int getVelocitat2(){
	return velocitat2;
}
public int getAcceleracio1(){
	return acceleracio1;
}
public int getAcceleracio2(){
	return acceleracio2;
}
public int getModificacio() {
	return modificacio;
}
//public int getVelocitat

}
