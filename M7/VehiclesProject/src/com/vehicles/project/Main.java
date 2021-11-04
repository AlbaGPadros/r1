package com.vehicles.project;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
	
	Controller controller = new Controller(); 
	controller.personalInfo();
	controller.createOwner();
	controller.tipusVehicle(); 
	controller.getVehicleList();
	}
}
