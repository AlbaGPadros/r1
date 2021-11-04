package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();
	
	List<Wheel> frontWheels = new ArrayList<Wheel>(); 
	List<Wheel> rearWheels = new ArrayList<Wheel>(); 
	List<Wheel> centralWheels = new ArrayList<Wheel>(); 
	ArrayList<Wheel> wheelsProv = new ArrayList<Wheel>(); 
	VehicleOwner owner; 
	ArrayList<Driver> drivers = new ArrayList<Driver>();
	public Vehicle(String plate, String brand, String color) {
		this.plate = plate;
		this.brand = brand;
		this.color = color;
	}
public Vehicle() {}	
	public void checkWheels() {
		for (Wheel i: wheels) {
			try {
			i.checkDiameter();
			} catch (Exception e) {
				System.out.println("El diàmetre d'alguna roda és incorrecte");
			}
		}
	}
	
	public String getInfoVehicle() {
		return "Marca: " + brand + "     " + "Color: " + color + "     " + "Matrícula :" + plate + "\n"
			+  "Propietari: " + owner.getPersonalInfo() +  "\n" +
			"Conductors: " + getDrivers(drivers);
	}
	
	//comprova que la matrícula tingui el format correcte
	public void checkPlate(String plate) throws Exception  { 
		this.plate = plate;
		String numbersPlate; String lettersPlate ="";
		
		numbersPlate = plate.substring(0,4);
		
		if(plate.length()==6) {
			lettersPlate = plate.substring(4,6);
			System.out.println(plate.substring(4,6));
			} else if(plate.length()==7){
				lettersPlate = plate.substring(4,7);	
			} else {
				throw new Exception();
		}
		
		System.out.println(numbersPlate + " " + lettersPlate);
		for (int i=0; i <numbersPlate.length(); i++) {
			if (!Character.isDigit(numbersPlate.charAt(i))) {
				throw new Exception();
			}
		}
		
		for (int i=0; i <lettersPlate.length(); i++) {
			if (Character.isDigit(lettersPlate.charAt(i))) {
				throw new Exception();
			}
		}	
	}
	public void addToWheels(Wheel wheel) {
		wheels.add(wheel);
	}
	
	public void addOwner(VehicleOwner owner) {
		this.owner = owner; 
	}
	
	public void addDriver(Driver driver) {
		drivers.add(driver);
	}
	public String getDrivers(ArrayList<Driver> driver) {
		String infoDrivers = " ";
		for (Driver i: driver) {
			infoDrivers = infoDrivers + i.getPersonalInfo();
			infoDrivers = infoDrivers + "\n     ";
		}
		return infoDrivers;
	}
	
	public void addWheels(List<Wheel> frontWheels, List<Wheel> rearWheels) throws Exception{};
	
	public void addCentralWheels(List<Wheel> wheels) throws Exception{};
}
