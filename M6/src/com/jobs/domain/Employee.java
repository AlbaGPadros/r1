package com.jobs.domain;

import java.text.DecimalFormat;

public class Employee extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	
	protected String category;
	
	//Constructor d'Employee, passa la info a AbsStaffMember 9 si el salari fos 0 llança una excepcio.
	public Employee(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);		
		if(salaryPerMonth<0) throw new Exception();
		if(paymentRate==null) throw new Exception();
				
		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
		isEmp = "Emp";
	}
	
	
	//Setters per cadascuna de les categories professionals.
	public void EmployeeIsBoss() {
		category = "Boss";
	}
	public void EmployeeIsManager() {
		category = "Manager";
	}
	public void EmployeeIsJunior() {
		category = "Junior";
	}
	public void EmployeeIsMid() {
		category = "Mid";
	}
	public void EmployeeIsSenior() {
		category = "Senior";
	}

	//Prepara la manera de mostrar la informació de cada Empleat per pantalla.
	@Override
	public String getInfo() {
		return isEmp +" [name = " + name +", adress = " + address + ", phone = " + phone + ", \n "
						+ "    salaryPerMonth = " + df.format(salaryPerMonth) + ", TotalPaid = " + df.format(totalPaid) + ", netSalary = " + df.format(netSalary)  + ", \n "
						+ "    AnnualGrossSalary = " + df.format(annualGrossSalary) + ", AnnualNetSalary = " + df.format(annualNetSalary) + " CalculatedBonus = " + df.format(bonus) +"]";
	}
	
	//Calcula tot allò referent al salari i porta als mètodes corresponents.
	@Override
	public void pay() {
		totalPaid= paymentRate.pay(salaryPerMonth);
		try {
			checkSalaries();
		} catch (Exception e) {
			System.out.println("El salari introduït per l'empleat " + name + "és incorrecte");
		}
		calculateTaxes();
		calculateAnnualSalary();
		calculateBonus(); 
	}
	
	//Comprova que els salaris quedin dins el marge indicat en cadascuna de les categories.  
	public void checkSalaries() throws Exception{
		if (category.equals("Boss")){
			if (totalPaid < 80) {
				throw new Exception();
			}
		} else if (category.equals("Manager")) {
			if ((totalPaid < 30) 	|| totalPaid> 50 ) { 
			}
		} else if (category.equals("Senior")) {
			if ((totalPaid < 27) 	|| totalPaid> 40 ) {
				throw new Exception();
			}
		} else if (category.equals("Mid")) {
			if ((totalPaid < 18) 	|| totalPaid> 25 ) {
				throw new Exception();
			}
		} else if (category.equals("Junior")) {
			if ((totalPaid < 9) 	|| totalPaid> 16 ) {
				throw new Exception();
			}
		}
		}

	//Calcula els impostos en funció de la categoria del treballador.
	public void calculateTaxes () {
		if (category.equals("Boss")){
			netSalary= totalPaid*0.68;
		} else if (category.equals("Manager")) {
			netSalary= totalPaid*0.74;
		} else if (category.equals("Senior")) {
			netSalary= totalPaid*0.76;
		} else if (category.equals("Mid")) {
			netSalary= totalPaid*0.85;
		} else if (category.equals("Junior")) {
			netSalary= totalPaid*0.98;
		} 
	}
	
	//Calcula el salari anual tant net com brut. 
	public void calculateAnnualSalary () {
		annualGrossSalary = totalPaid*14;
		annualNetSalary = netSalary*12; 
		} 
	
	//Calcula el bonus (10%) sobre el total del salari net
	public void calculateBonus() {
		bonus = annualNetSalary*0.10;
	}
	
}
