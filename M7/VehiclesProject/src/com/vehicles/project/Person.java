package com.vehicles.project;

public abstract class Person {
	protected String name;
	protected String surname; 
	protected String birthDate;
	protected DrivingLicence drivingLicence;



public Person(String name, String surname, String birthDate, DrivingLicence drivingLicence) {
	this.name = name; 
	this.surname = surname; 
	this.birthDate = birthDate; 
	this.drivingLicence = drivingLicence; 
}

public String getPersonalInfo() {
	return name + surname + " - " + drivingLicence.getInfoLicence(); 
}
	
}
