package gatspackage;

import javax.swing.*;


import java.awt.event.*; 
import java.awt.*; 

public class Benvinguda extends JFrame implements ActionListener {
	private JTextField textfield1;
	private JLabel label1, label2, label3, label4; 
	private JButton boto1; 
	
	public static String nomusuari ="";
	
	public Benvinguda() {
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Hola!");
		getContentPane().setBackground(new Color(0,210,180));
		Image im = Toolkit.getDefaultToolkit().getImage("icon.png");
		setIconImage(im);
		

		label1 = new JLabel();
		label1.setIcon(new ImageIcon("icon.png"));
		label1.setBounds(50,15,300,300);
		add(label1);
		
		label2 = new JLabel("Gatets Cuquis 1.0");
		label2.setBounds(35,350,300,30);
		label2.setFont(new Font("Century Gothic", 1, 18));
		label2.setForeground(new Color(255,255,255));
		add(label2); 
		
		label3 = new JLabel("Com et dius?");
		label3.setBounds(100,400,300,30);
		label3.setFont(new Font("Century Gothic", 0, 12));
		label3.setForeground(new Color(255,255,255));
		add(label3); 
		
		label4 = new JLabel("Betaprograma");
		label4.setBounds(35,550,300,30);
		label4.setFont(new Font("Century Gothic", 1, 10));
		label4.setForeground(new Color(255,255,255));
		add(label4); 
		
		textfield1 = new JTextField(); 
		textfield1.setBounds(50,450,255,25);
		textfield1.setBackground(new Color(238,255,250)); 
		add(textfield1);
		
		boto1 = new JButton("Endavant"); 
		boto1.setBounds(150, 500, 100, 50); 
		boto1.setBackground(new Color(238,255,250)); 
		boto1.setForeground(new Color(0,210,180));
		boto1.addActionListener(this);
		add(boto1);
	}
	
public void actionPerformed(ActionEvent e) {
	if(e.getSource() == boto1) {
		nomusuari = textfield1.getText().trim();
		if (nomusuari.equals("")) {
			JOptionPane.showMessageDialog(null, "Cal introduir un nom d'usuari");
		}
		else {
			Termes finestratermes = new Termes(); 
			finestratermes.setBounds(0, 0, 600, 500);
			finestratermes.setVisible(true); 
			finestratermes.setResizable(false);
			finestratermes.setLocationRelativeTo(null);
			this.setVisible(false);
		}
	}
}

public static void main (String[] args) {
	
	
	Benvinguda prova1 = new Benvinguda();
	prova1.setBounds(0,0,400,600);
	prova1.setResizable(false);
	prova1.setVisible(true);
	prova1.setLocationRelativeTo(null);
}
}