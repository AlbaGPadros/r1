package com.example.CRUD.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.CRUD.bean.Treballador;

public class BaseDades2 {
	private Connection conexion; 
		public BaseDades2() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String conex="jdbc:mysql://localhost:3306/treballadors";
				this.conexion=DriverManager.getConnection(conex, "root", "");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

//INSERTA
public void inserta(Treballador treballador) {
	String query = "INSERT INTO `treballadors` (`id`, `nom`, `cognom`, `feina`) VALUES (?, ?, ?, ?)";
	try {
		PreparedStatement preparedStmt;
		
		preparedStmt = conexion.prepareStatement(query); 
		preparedStmt.setInt (1, treballador.getId()); 
		preparedStmt.setString(2, treballador.getNom());
		preparedStmt.setString(3, treballador.getCognom());
		preparedStmt.setInt(4, treballador.getFeinaInt());

		preparedStmt.executeUpdate();
	} catch (SQLException ex) {
		System.out.println(ex.getMessage());
	}
}

//ESBORRA

public void esborra(int id) {
	String query = "delete from treballadors where id="+id;
	
	try {
		PreparedStatement preparedStmt = conexion.prepareStatement(query);
		preparedStmt.executeUpdate();
	} catch (SQLException ex) {
		System.out.println(ex.getMessage());
	}
}

//MODIFICA
public void modifica(Treballador treballador) {
	String query = " update treballadors set nom=?, cognom=?, feina=? "
				+ "where id=?";
	
	try {
		PreparedStatement preparedStmt = conexion.prepareStatement(query);
		preparedStmt.setString(1, treballador.getNom());
		preparedStmt.setString(2, treballador.getCognom());
		preparedStmt.setInt(3, treballador.getFeinaInt());
		preparedStmt.setInt(4, treballador.getId());
		preparedStmt.executeUpdate(); 
		
	} catch (SQLException ex) {
		System.out.println(ex.getMessage());
	}
}

//FILTRA
public ArrayList<Treballador> filtraTreballadorsFeina(Treballador treballador) {
	ArrayList<Treballador> treballadors = new ArrayList <Treballador>(); 
	int feinaint= treballador.getFeinaInt(); 
	Treballador t;
	try {
		Statement s = conexion.createStatement();
		String sql = "SELECT * FROM TREBALLADORS WHERE feina= " + (feinaint);
		s.execute(sql); 
		ResultSet rs= s.getResultSet(); 
		while(		rs.next()) {
			t = new Treballador(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));		
			treballadors.add(t);
		}
	} catch (SQLException ex) {
		System.out.println(ex.getMessage());
	}
	return treballadors;
}
//GETTERS

public Treballador getTreballador(int id) {
	Treballador treballador = null;
	try {
		Statement s = conexion.createStatement(); 
		String sql = "SELECT * FROM TREBALLADORS WHERE ID=" +id;
		s.execute(sql); 
		ResultSet rs=s.getResultSet(); 
		rs.next(); 
		treballador = new Treballador(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
	} catch (SQLException ex) {
		System.out.println(ex.getMessage());
	}
	return treballador; 
}

public ArrayList<Treballador> getTreballadors(){
	ArrayList <Treballador> treballadors = new ArrayList <Treballador>(); 
	try {
		Statement s = conexion.createStatement();
		String sql = "SELECT * FROM TREBALLADORS";
		s.execute(sql); 
		ResultSet rs= s.getResultSet(); 
		while(rs.next()) {
			Treballador treballador = new Treballador(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			treballadors.add(treballador);
		}
	} catch (SQLException ex) {
		System.out.println(ex.getMessage());
	}
	return treballadors; 
}

}