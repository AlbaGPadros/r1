package com.jobs.domain;

public class EmployeeMid extends Employee{
public EmployeeMid(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);
		category = "Mid";
	}

	@Override
	public void pay() {// He aplicat la reducció aquí (i no a PaymentFactory) per donar sentit a aquestes classes. 
						//abans he modificat el payment rate de "Employee" genèric perquè sigui igual al salari mateix (i no aplicar dues reduccions). 
		
		totalPaid= paymentRate.pay(salaryPerMonth);
		totalPaid = totalPaid*0.90;
		try {
			checkSalaries();
		} catch (Exception e) {
			System.out.println("El salari introduït per a l'empleat" + name + "és incorrecte");		
		}
		calculateTaxes();
		calculateAnnualSalary();
		calculateBonus(); 

	}
	
}
