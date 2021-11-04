package com.vehicles.project;

public class Wheel {
	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.diameter = diameter;
		

		}
public double checkDiameter() throws Exception {
	if (diameter >0.4 && diameter < 4) {
		return diameter;
	} else {
		throw new Exception(); 
	}
}

}
