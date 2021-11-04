package com.vehicles.project;


public class DrivingLicence  {
	int idDrivingLicence;
	String name; 
	String surname; 
	String expirationDate; 
	String 	licenceType; 

public DrivingLicence(int idDrivingLicence, String LicenceType, String expirationDate) {
	this.licenceType = LicenceType;
	this.idDrivingLicence = idDrivingLicence; 
	this.expirationDate = expirationDate; 
	}

public String getType() {
	return licenceType; 
}
public String getInfoLicence() {
	return idDrivingLicence + " " + licenceType; 
}

//Comprova tipus de vehicle
public boolean isValid(String tipusDeVehicle) {
	if (licenceType.equals("T")) {
		return true; 
	}
	else if (licenceType.equals("C")) {
		if(tipusDeVehicle.equals("T")) {
			return false;
		} else {
			return true;
		}
	}	
	else if (licenceType.equals("B")) {
		if(tipusDeVehicle.equals("B")) {
			return true; 
		} else {
			return false; 
		} 
	}
	else {
		return false; 
	}
}

}


