package com.jobs.domain;

public class EmployeeSenior extends Employee {
	
	public EmployeeSenior(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);
		category = "Senior";
	}

	@Override
	public void pay() {// He aplicat la reducci� aqu� (i no a PaymentFactory) per donar sentit a aquestes classes. 
						//abans he modificat el payment rate de "Employee" gen�ric perqu� sigui igual al salari mateix (i no aplicar dues reduccions). 
		
		totalPaid= paymentRate.pay(salaryPerMonth);
		totalPaid = totalPaid*0.95;
		try {
			checkSalaries();
		} catch (Exception e) {
			System.out.println("El salari introdu�t per a l'empleat " + name + " �s incorrecte");		
		}
		calculateTaxes();
		calculateAnnualSalary();
		calculateBonus(); 

	}
}
