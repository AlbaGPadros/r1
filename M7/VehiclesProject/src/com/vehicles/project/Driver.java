package com.vehicles.project;

public class Driver extends Person {
	DrivingLicence drivingLicence;
	Vehicle vehicle;
	
Driver(String name, String surname, String birthDate, DrivingLicence drivingLicence){
	super(name, surname, birthDate, drivingLicence);
	this.drivingLicence =drivingLicence;

}
public void addPersonalInfoLicence () {
	drivingLicence.name = name; 
	drivingLicence.surname= surname;
}

public void addVehicle(Vehicle vehicle) {
	this.vehicle = vehicle;
}
}
