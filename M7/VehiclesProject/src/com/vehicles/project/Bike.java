package com.vehicles.project;

import java.util.List;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
		this.plate = plate; 
		this.brand = brand; 
		this.color = color; 

	}

	@Override
	public void addWheels(List<Wheel> frontWheels, List<Wheel> rearWheels) throws Exception {
		addOneWheel(frontWheels);
		addOneWheel(rearWheels);
	}

	public void addOneWheel(List<Wheel> wheels) throws Exception{  
		if (wheels.size()!=1) {
			System.out.println("problema amb el tamany de l'array");
			throw new Exception();
		}
		Wheel wheel = wheels.get(0);
		this.wheels.add(wheel);
	}
}
