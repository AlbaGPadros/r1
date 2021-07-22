package com.jobs.domain;

import java.text.DecimalFormat;

public abstract class AbsStaffMember { //Inclou totes les persones vinculades a l'empresa, siguin voluntaris o empleats.  
									//Conté els mètodes  abstractes getInfo() i pay(), que es sobreescriuen pels Volunteer i els Employee.

	protected int id;
	protected String name;
	protected String address;
	protected String phone;
	protected double totalPaid=0;
	protected double netSalary=0;
	protected double annualGrossSalary = 0; 
	protected double annualNetSalary = 0; 
	protected double benefits =0;
	protected double bonus =0;
	protected String isEmp;
	private static int COUNTER_MEMBERS = 1;
	DecimalFormat df = new DecimalFormat("#.00"); //Voldrem evitar molts decimals, com que formarà part d'un String molt complex, m'ha semblat que seria més senzill aplicant aquest mètode. 


	public AbsStaffMember(String name, String address, String phone) throws Exception {
		if (name.equals(""))
			throw new Exception();
		if (address.equals(""))
			throw new Exception();
		if (phone.equals(""))
			throw new Exception();

		this.name = name;
		this.address = address;
		this.phone = phone;
		id = COUNTER_MEMBERS;
		COUNTER_MEMBERS++;
	}
	
	//public AbsStaffMember() {}
	
	public abstract String getInfo();
	
	public abstract void pay();
}
