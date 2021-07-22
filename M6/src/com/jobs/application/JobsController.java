package com.jobs.application;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.EmployeeJunior;
import com.jobs.domain.EmployeeMid;
import com.jobs.domain.EmployeeSenior;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController { 

	private EmployeeRepository repository = new EmployeeRepository();
	private String allEmployees;
	private String severalEmployees;
	public JobsController(){
		
	}
//MÈTODES PER CREAR MEMBRES DE L'EMPRESA DE DIFERENTS TIPUS
	//Boss
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
		boss.EmployeeIsBoss();
	}
	//Employee Junior
	public void createEmployeeJunior(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employeeJunior = new EmployeeJunior(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employeeJunior);

	}
	
	//Employee Mid
	public void createEmployeeMid(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		EmployeeMid employeeMid = new EmployeeMid(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employeeMid);

	}
	
	//Employee Senior
	public void createEmployeeSenior(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		EmployeeSenior employeeSenior = new EmployeeSenior(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employeeSenior);
	}

	//Manager
	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Employee manager = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);		
		manager.EmployeeIsManager();
	}
	
	//Volunteer
	public void createVolunteer(String name, String adress, String phone) throws Exception {
		Volunteer volunteer = new Volunteer(name, adress, phone, "No cobra");
		repository.addMember(volunteer);
	}

	//Per cada membre de la llista members, executa el mètode pay, que inclou, la comprovació, la reducció d'impostos i el càlcul del bonus
	public void payAllEmployeers() throws Exception{
		for(int i=0; i < repository.getAllMembers().size(); i++) {
			repository.getAllMembers().get(i).pay();
		}
	}
	
	//Crea un String amb tota la informacio de tots els vinculats de l'empresa, servirà per imprimir-lo. 
	public String getAllEmployees() {
		
		for(int i=0; i < repository.getAllMembers().size(); i++) {
			 //allEmployees = "1" + allEmployees + "\n\n" +(repository.getAllMembers().get(i).getInfo());
			 if (i==0) {
				 allEmployees= repository.getAllMembers().get(i).getInfo() + "\n\n"; 
			 }
			 else allEmployees = allEmployees + repository.getAllMembers().get(i).getInfo() + "\n\n"; 
		 }
			return allEmployees;	}	
}

