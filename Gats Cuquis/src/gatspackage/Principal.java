package gatspackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Principal extends JFrame implements ActionListener {

	private JMenuBar mb; 
	private JMenu mopcions, msobre, mcolor;
	private JMenuItem mibeta, migroc, misortir; 
	private JLabel lbenvingut, limatge, ldades, lnom, lcognom, ldepartament, lantiguetat, lresultat; 
	private JTextField tnom, tcognom;
	private JComboBox cdepartament, cantiguetat; 
	private JScrollPane spresultat; 
	private JTextArea taresultat; 
	private JButton bresultat; 
	String nom; 
	
	public Principal() {
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Pantalla Principal"); 
		getContentPane().setBackground(new Color(0,210,180)); 		
		Image im = Toolkit.getDefaultToolkit().getImage("icon.png");
		setIconImage(im);
		
		Termes finestra2 = new Termes();
		nom = finestra2.nom;
		
	//Menubar
		mb = new JMenuBar();
		mb.setBackground(new Color(255,255,255));
		setJMenuBar(mb);
		
		mopcions = new JMenu("Opcions");
		mb.add(mopcions);
		msobre = new JMenu("Sobre nosaltres");
		mb.add(msobre); 
		mcolor = new JMenu("Color del fons");
		mopcions.add(mcolor);
		
		mibeta = new JMenuItem("Color Beta");
		mcolor.add(mibeta);
		mibeta.addActionListener(this);
		
		migroc = new JMenuItem("Groc");
		mcolor.add(migroc);
		migroc.addActionListener(this);
		
		misortir = new JMenuItem("Sortir");
		mopcions.add(misortir); 
		misortir.addActionListener(this);
		
	//Capcelera
		lbenvingut = new JLabel ("Benvinguda " + nom);
		lbenvingut.setBounds(300, 100, 300, 50);
		lbenvingut.setFont(new Font("Century Gothic", 1, 30));
		add(lbenvingut);
		
		limatge = new JLabel();
		limatge.setIcon(new ImageIcon("gat2.jpg"));
		limatge.setBounds(10,10,200,200);
		add(limatge);
		
		ldades = new JLabel ("Introdueix les dades pel calcul de les vacances");
		ldades.setBounds(250, 175, 450, 30);
		ldades.setFont(new Font("Century Gothic", 1, 15));
		add(ldades);
		
	//Formulari
		//Nom
		lnom = new JLabel ("Nom");
		lnom.setBounds(200, 225, 100, 30);
		add(lnom);
		
		tnom = new JTextField();
		tnom.setBounds(200, 250, 150, 30);
		add(tnom);
		
		//Cognom
		lcognom = new JLabel ("Cognom");
		lcognom.setBounds(200, 325, 100, 30);
		add(lcognom);
		
		tcognom = new JTextField();
		tcognom.setBounds(200, 350, 150, 30);
		add(tcognom);
		
		//Departament
		ldepartament = new JLabel ("Departament");
		ldepartament.setBounds(500, 225, 100, 30);
		add(ldepartament);
		
		cdepartament = new JComboBox();
		cdepartament.setBounds(500,250,150,30);
		add(cdepartament);
		cdepartament.addItem("");
		cdepartament.addItem("Atenció als miols");
		cdepartament.addItem("Mimos i pentinar");
		cdepartament.addItem("Pinso i llaunetes");

		
		//Antiguetat
		lantiguetat = new JLabel ("Antiguetat");
		lantiguetat.setBounds(500, 325, 100, 30);
		add(lantiguetat);
		
		cantiguetat = new JComboBox();
		cantiguetat.setBounds(500,350,150,30);
		add(cantiguetat);
		cantiguetat.addItem("");
		cantiguetat.addItem("1 any");
		cantiguetat.addItem("Entre 2 i 5 anys");
		cantiguetat.addItem("Més de 5 anys");
		
		
		//Resultats
		bresultat = new JButton("Calcula");
		bresultat.setBounds(200,450, 100, 30);
		bresultat.addActionListener(this);
		add(bresultat);
		
		lresultat = new JLabel("Resultat:"); 
		lresultat.setBounds(500, 400, 150, 30);
		add(lresultat);
		
		taresultat = new JTextArea();
		taresultat.setEditable(false);
		taresultat.setText("Aquí apareixerà el resultat");
		spresultat = new JScrollPane(taresultat);
		spresultat.setBounds(500,450, 250, 100);
		add(spresultat);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bresultat) {
			String nomintro = tnom.getText();
			String cognom = tcognom.getText();
			String departament = cdepartament.getSelectedItem().toString();
			String antiguitat = cantiguetat.getSelectedItem().toString();
			
			if (nomintro.equals("")||cognom.equals("")||departament.equals("")|antiguitat.equals("")) {
				JOptionPane.showMessageDialog(null, "S'han d'introduir totes les dades");
			}
			else {
				if(departament.equals("Atenció als miols")&& cantiguetat.getSelectedIndex() ==1) {
					taresultat.setText("300 dies de gatets");
				}
				else if (departament.equals("Atenció als miols")&& cantiguetat.getSelectedIndex() ==2) {
					taresultat.setText("301 dies de gatets");
				}
				else if (departament.equals("Atenció als miols")&& cantiguetat.getSelectedIndex() ==3) {
					taresultat.setText("302 dies de gatets");
				}
				else if (departament.equals("Mimos i pentinar")&& cantiguetat.getSelectedIndex() ==1) {
					taresultat.setText("303 dies de gatets");
				}
				else if (departament.equals("Mimos i pentinar")&& cantiguetat.getSelectedIndex() ==2) {
					taresultat.setText("304 dies de gatets");
				}
				else if (departament.equals("Mimos i pentinar")&& cantiguetat.getSelectedIndex() ==3) {
					taresultat.setText("305 dies de gatets");
				}
				else if (departament.equals("Pinso i llaunetes")&& cantiguetat.getSelectedIndex() ==1) {
					taresultat.setText("306 dies de gatets");
				}
				else if (departament.equals("Pinso i llaunetes")&& cantiguetat.getSelectedIndex() ==2) {
					taresultat.setText("307 dies de gatets");
				}
				else if (departament.equals("Pinso i llaunetes")&& cantiguetat.getSelectedIndex() ==3) {
					taresultat.setText("308 dies de gatets");
				}
			}
		}
		if (e.getSource() == mibeta) {
			getContentPane().setBackground(new Color(0,210,180));
		}
		if (e.getSource()== migroc) {
			getContentPane().setBackground(new Color(255,215,58));
		}
		if (e.getSource()== misortir) {
			Benvinguda prova1 = new Benvinguda();
			prova1.setBounds(0,0,400,600);
			prova1.setResizable(false);
			prova1.setVisible(true);
			prova1.setLocationRelativeTo(null);
			this.setVisible(false);
		}
		
	}
	
	public static void main (String args[]) {
		Principal finestraprincipal = new Principal(); 
		finestraprincipal.setBounds(0, 0, 800, 700);
		finestraprincipal.setVisible(true); 
		finestraprincipal.setResizable(false);
		finestraprincipal.setLocationRelativeTo(null);
	}
}
