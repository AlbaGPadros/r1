package com.vehicles.project;

public class VehicleOwner extends Driver {
	
public VehicleOwner(String name, String surname, String birthDate, DrivingLicence drivingLicence, boolean parking, boolean insurance) {
super(name, surname, birthDate, drivingLicence);
this.name=name; 
this.surname = surname; 
this.birthDate = birthDate; 
this.drivingLicence = drivingLicence; 
}

public void addVehicle() {
	
}
}
