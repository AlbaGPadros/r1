package com.vehicles.project;

import java.util.List;

public class Truck extends Vehicle {
	public Truck(String plate, String brand, String color) {
		super(plate, brand, color);
	}
	@Override
	public void addWheels(List<Wheel> frontWheels, List<Wheel> rearWheels ) throws Exception {
		addTwoWheels(frontWheels);
		addTwoWheels(rearWheels);
	}
	
	public void addTwoWheels(List<Wheel> wheels) throws Exception {
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
	@Override
	public void addCentralWheels(List<Wheel> wheels) throws Exception{
		for (int i = 0; i <centralWheels.size(); i=i+2) {
			if (wheels.get(i).checkDiameter()!= wheels.get(i).checkDiameter()) {
				throw new Exception();} else {
					System.out.println("Exit diametre rodes centrals");
				}
			this.wheels.add(wheels.get(i));
			this.wheels.add(wheels.get(i+1));

		}
	}
}
