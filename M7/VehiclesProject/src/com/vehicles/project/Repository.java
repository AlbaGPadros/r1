package com.vehicles.project;

import java.util.ArrayList;

public class Repository {

	
ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

	public void addRepository(Vehicle vehicle) {
		System.out.println("afegim al repositori");
		vehicles.add(vehicle);
	}

	public ArrayList<Vehicle> getRepository(){
		return vehicles; 
	}
}
