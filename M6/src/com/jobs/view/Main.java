package com.jobs.view;

import com.jobs.application.JobsController;

public class Main {

	
	
	private static JobsController controller=new JobsController();
	
	public static void main(String[] args) throws Exception {
		controller.createBossEmployee("Pepe Boss", "Direccion molona", "666666666", 100.0);
		controller.createEmployeeSenior("Pedro Employee", "Direccion molona 2", "665266666", 35.0); //Salaris Modificats per evitar que salti l'excepció. 
		controller.createEmployeeSenior("Laura Employee", "Direccion molona 3", "625266666", 45.0);
	    controller.createVolunteer("Juan Volunteer", "Direccion molona 4", "614266666");
		controller.createManagerEmployee("Pedro Employee", "Direccion molona 2", "665226666", 40.0);
		
		
		controller.payAllEmployeers();
		
		String allEmployees=controller.getAllEmployees();
		
		System.out.println(" \n" + "EMPLOYEES: " + " \n" + allEmployees + " \n");
		
	}

}
