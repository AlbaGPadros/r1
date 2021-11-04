package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;


public class Car extends Vehicle {
	public Car(String plate, String brand, String color) {
		super(plate, brand, color);
		this.plate = plate; 
		this.brand = brand; 
		this.color = color;
	}
public Car() {super();}
	public void addWheels(List<Wheel> frontWheels, List<Wheel> rearWheels) throws Exception {
		addTwoWheels(frontWheels);
		addTwoWheels(rearWheels);
	}

	public void addTwoWheels(List<Wheel> wheels) throws Exception{  
		if (wheels.size()!=2) {
			System.out.println("problema amb el tamany de l'array");
			throw new Exception();
		}
		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);

		if (rightWheel.checkDiameter()!= leftWheel.checkDiameter()) {
			throw new Exception();
		}
		this.wheels.add(leftWheel);
		this.wheels.add(rightWheel);
	}
}
	
