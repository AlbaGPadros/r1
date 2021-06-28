package gatspackage;

import javax.swing.*;
import javax.swing.event.*; 
import java.awt.*;
import java.awt.event.*; 

public class Termes extends JFrame implements ActionListener, ChangeListener {
 
	private JLabel label1, label2; 
	private JCheckBox check1; 
	private JButton boto1, boto2; 
	private JScrollPane scrollpane1; 
	private JTextArea textarea1; 
	String nom ="";

	
	public Termes() {
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Llicència d'ús");
		Image im = Toolkit.getDefaultToolkit().getImage("icon.png");
		setIconImage(im);
		
		Benvinguda finestrabenvinguda = new Benvinguda();
		nom = finestrabenvinguda.nomusuari;
		
		label1 = new JLabel ("Termes i condicions dels Cuquigats 1.0"); 
		label1.setBounds(75,50,400,30);
		label1.setFont(new Font("Century Gothic", 1, 20));
		label1.setForeground(new Color(0,210,180));
		add(label1); 
		
		textarea1 = new JTextArea();
		textarea1.setEditable(false);
		textarea1.setFont(new Font("Century Gothic", 0, 12)); 
		scrollpane1 = new JScrollPane(textarea1); 
		scrollpane1.setBounds(75, 100, 450, 175);
		textarea1.setText("\n\n       Termes i condicions text llaaaarg"
						+ "\n\n       una segona línea"
						+   "\n       i una tercera."); 
		
		add(scrollpane1);
		check1 = new JCheckBox("Accepto " + nom); 
		check1.setBounds(75, 300, 300, 30);
		check1.addChangeListener(this); 
		add(check1); 
		
		boto1 = new JButton("Continuar");
		boto1.setBounds(75, 350, 100, 30);
		boto1.addActionListener(this);
		boto1.setEnabled(false);
		add(boto1);
		
		boto2 = new JButton("No accepto");
		boto2.setBounds(200, 350,100,30);
		boto2.addActionListener(this);
		add(boto2);
		
		label2= new JLabel();		
		label2.setIcon(new ImageIcon("icon.png"));
		label2.setBounds(400,300,300,300);
		add(label2);
		
	}
	public void stateChanged(ChangeEvent e) {
		if (check1.isSelected()) {
			boto1.setEnabled(true);
			boto2.setEnabled(false);
		} else {
			boto1.setEnabled(false);
			boto2.setEnabled(true);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==boto2) {
			Benvinguda prova1 = new Benvinguda();
			prova1.setBounds(0,0,400,600);
			prova1.setResizable(false);
			prova1.setVisible(true);
			prova1.setLocationRelativeTo(null);
			this.setVisible(false);
		}
		if (e.getSource()==boto1) {
			Principal finestraprincipal = new Principal(); 
			finestraprincipal.setBounds(0, 0, 800, 700);
			finestraprincipal.setVisible(true); 
			finestraprincipal.setResizable(false);
			finestraprincipal.setLocationRelativeTo(null);
			this.setVisible(false);
		}
	}
	
	public static void main (String args[]) {
		Termes finestratermes = new Termes(); 
		finestratermes.setBounds(0, 0, 600, 500);
		finestratermes.setVisible(true); 
		finestratermes.setResizable(false);
		finestratermes.setLocationRelativeTo(null);
	}
}
