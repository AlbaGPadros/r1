package com.vehicles.project;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Controller {
	Scanner entrada = new Scanner(System.in);
	
	String tipusVehicle; 
	
	String name; String surname; String birthDate; int idDrivingLicence; String idDrivingLicenceStr; String LicenceType; String expirationDate; 
	String plate;
	String brand;
	String color; 
	boolean parking; String parkingStr; 
	boolean insurance; String insuranceStr;
	double diameter; 
	int numberWheels;
	VehicleOwner owner;
	DrivingLicence drivingLicence; 
	Driver driver; 
	boolean isOwner = true; 
	Vehicle vehicle; 
	Repository repository = new Repository(); 
	
//1. Pregunta Dades personals (tant per propietari com per conductor)
public void personalInfo() {
	System.out.println("Nom:");	
	name = entrada.next();
	System.out.println("Cognom:");		
	surname = entrada.next();
	System.out.println("Data de naixement (XX/XX/XXXX):");		
	birthDate = entrada.next();
	
	if (isOwner) { 
		ownerInfo(); 
	}
}

//1. Pregunta Dades propietari
public void ownerInfo() {	
	do {	//Bucle per demanar el pàrking
		System.out.println("Disposes de pàrking covert? (S/N)");
		parkingStr = entrada.next(); 
	} while (!((parkingStr.equals("S"))|| ((parkingStr.equals("N")))));
	if (parkingStr.equals("S")) {
		parking = true; 
	} else if (parkingStr.equals("N")) {
		parking = false;
	}
	
	do { 	//Bucle per demanar l'assegurança
		System.out.println("Disposes d'assegurança vàlida? (S/N)");
		insuranceStr = entrada.next(); 
	} while (!((insuranceStr.equals("S"))|| ((insuranceStr.equals("N")))));
	if (insuranceStr.equals("S")) {
		insurance = true; 
	} else if (insuranceStr.equals("N")) {
		insurance = false;
	}
	licenceInfo();
}

// Pregunta informació del carnet.
public void licenceInfo() {
	boolean correcte = false; 
	do { 
		System.out.println("nº Carnet:");		
		idDrivingLicenceStr = entrada.next();
		try {
			idDrivingLicence = Integer.parseInt(idDrivingLicenceStr);
			correcte = true;
		} catch (Exception e) {
			System.out.println("No has introduït un nombre");
		}
	} while(!correcte);
	
	do {
		System.out.println("Tipus de Llicència (T: Camió, C: Cotxe, B: Moto:");		
		LicenceType = entrada.next();
	} while(!((LicenceType.equals("T"))|| (LicenceType.equals("C"))||(LicenceType.equals("B"))));
	System.out.println("Data de caducitat");
	expirationDate = entrada.next(); 
	
	
	drivingLicence = new DrivingLicence(idDrivingLicence, LicenceType, expirationDate);
}

//Crea el conductor/propietari
public VehicleOwner createOwner() {
		owner = new VehicleOwner(name, surname, birthDate, drivingLicence, parking, insurance);
		System.out.println("propietari creat");
		return owner; 
		}
public Driver createDriver() {
		driver = new Driver(name, surname, birthDate, drivingLicence);
		return driver; 
}


public void tipusVehicle(){	
	//Pregunta tipus i valida llicència
	boolean correcte = false; 
	do {
		System.out.println("Quin tipus de vehicle vols introduir");		
		System.out.println("C. Cotxe         B. Moto          T. Camió");
		tipusVehicle = entrada.next();
		drivingLicence.isValid(tipusVehicle); 
	} while (!((tipusVehicle.equals("C") || tipusVehicle.equals("B") || tipusVehicle.equals("T"))) ); 
	
	//Crea el Vehicle corresponent
	if (tipusVehicle.equals("T")) {
		System.out.println("Has escollit CAMIÓ");
		VehicleInfo();
		Vehicle vehicle = new Truck(plate, brand, color);
			do { //En el cas del camió, cal introduir el nombre de rodes que té, com un int parell. 
				System.out.println("nº rodes:");		
				try {
					numberWheels = entrada.nextInt();
					if(numberWheels %2 ==0) {
						correcte = true;
					}
				} catch (Exception e) {
					System.out.println("No has introduït un nombre");
				} 
			} while(!correcte);
			setVehicle(vehicle);
		} else if (tipusVehicle.equals("C")) {
		System.out.println("Has escollit COTXE");
		VehicleInfo();
		Vehicle vehicle = new Car(plate, brand, color);
		numberWheels = 4;
		setVehicle(vehicle);

	} else if (tipusVehicle.equals("B")) {
		System.out.println("Has escollit MOTO");
		VehicleInfo();
		Vehicle vehicle = new Bike(plate, brand, color);
		numberWheels = 2;
		setVehicle(vehicle);
	}
}

public void VehicleInfo() {
	System.out.println("Introdueix la matrícula");
	plate = entrada.next();
	System.out.println("Introdueix la marca");
	brand = entrada.next();
	System.out.println("Introdueix el color");
	color = entrada.next(); 
}


public void setVehicle(Vehicle vehicle) {
	boolean correcte = false;
	do { //En el cas del camió, cal introduir el nombre de rodes que té, com un int parell. 
		try {
			vehicle.checkPlate(plate);
			System.out.println("Matrícula correcta");
			correcte = true; 
		} catch (Exception e){
			System.out.println("Torna a introduir la matrícula");
			plate = entrada.next();
		}
	} while(!correcte);
	
	vehicle.addOwner(owner);
	repository.addRepository(vehicle);
	setWheels(vehicle);
	addDriver(vehicle);
}
	//Seteja les rodes del vehicle
	public void setWheels(Vehicle vehicle) {
		int counter=1;
		int centralWheels =0; // emmagatzema les rodes centrals (excloent les davanteres i traseres). 
		if (numberWheels >4) {
			centralWheels = numberWheels -4; 
			numberWheels = 4; 				
		}
		for (int i= 0; i <numberWheels/2; i++) {
			System.out.println("Introdueix el diametre de la roda " + counter);
			diameter=Double.parseDouble(entrada.next());
			System.out.println("Introdueix la marca de la roda " + counter);
			brand = entrada.next();
			vehicle.frontWheels.add(new Wheel(brand, diameter));
			counter++; 
		}
		if (centralWheels != 0) { // En cas que hi hagi rodes centrals, demana-les i emmagatzemeles en una altra llista
			for (int i=0; i<centralWheels; i++) { 
				System.out.println("Introdueix el diàmetre de la roda " + counter);
				diameter=Double.parseDouble(entrada.next());
				System.out.println("Introdueix la marca de la roda " + counter);
				brand = entrada.next();
				vehicle.centralWheels.add(new Wheel(brand, diameter));
				counter ++;
			}
		}
		for (int i= 0; i <numberWheels/2; i++) {
			System.out.println("Introdueix el diametre de la roda " + counter);
			diameter=Double.parseDouble(entrada.next());
			System.out.println("Introdueix la marca de la roda " + counter);
			brand = entrada.next();
			vehicle.rearWheels.add(new Wheel(brand, diameter));
			counter++;
		}

		if (centralWheels != 0){
			try {
				vehicle.addCentralWheels(vehicle.centralWheels);
			} catch (Exception e) {
				System.out.println("Error en les rodes centrals");
			}
		}
		try {
			vehicle.addWheels(vehicle.frontWheels, vehicle.rearWheels);
			System.out.println("Exit addWheels");
				} catch (Exception e) {
					System.out.println(e);
					System.out.println("Les rodes introduïdes no són correctes");
				}
	}
	public void addDriver(Vehicle vehicle) {
		int addDriver = 0; 
		boolean correcte = false; 
		do { 
			System.out.println("Vols afegir conductors?");
			System.out.println("1. Sí        2. No");
			try {
				addDriver = entrada.nextInt();
				correcte = true;
			} catch (Exception e) {
				System.out.println("No has introduït un nombre");
			}
		} while(!correcte);
		if (addDriver == 1){
			isOwner = false; 
			personalInfo();	
			licenceInfo();	
			vehicle.addDriver(createDriver());
			}
		continueOrClose(vehicle);
	}
	public void getVehicleList() {
		System.out.println("anem a imprimir la llista");
		int i =1;
		for(Vehicle vehicle: repository.getRepository()) {
			System.out.println("\n"+ "Vehicle "+ (i + 1));
			System.out.println(vehicle.getInfoVehicle());
			i++;
	}
	}
	//Continuar introduint o tancar
	public void continueOrClose(Vehicle vehicle) {
		System.out.println("1. Introduir nou conductor");
		System.out.println("2. Introduir nou vehicle i propietari");
		System.out.println("3. Veure llistat de Vehicles i conductors");
		System.out.println("4. Sortir");
		int opcio =0; 
		boolean correcte = false; 
		do {
			try {
			opcio = entrada.nextInt(); 
			correcte = true; 
			} catch (Exception e){
			}
			switch (opcio) {
			case 1: addDriver(vehicle);
				break; 
			case 2: personalInfo();
				break; 
			case 3:getVehicleList();
				break;
			case 4: System.exit(0); 
				break; 
			default:
				correcte = false; 
				break; 
			}
		} while( correcte == false);
	}
	}