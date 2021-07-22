package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	String description = "No cobra";
	public Volunteer(String name, String address, String phone, String description) throws Exception {
		super(name, address, phone);
		description = this.description;
		isEmp = "Vol";
		totalPaid=0.0;
		benefits = 0; 
		//TODO
	}
	
	//Prepara la manera de mostrar la informació de cada voluntari per pantalla.
	@Override
	public String getInfo() {
		return isEmp +" [name = " + name +", adress = " + address + ", phone = " + phone + 
				      "\n     description = " + description+ ", TotalPaid = "+ df.format(totalPaid)+ ", GovernmentBenefits = " + df.format(benefits) +"]";

	}
	//El voluntari no cobrarà un salari, com a màxim una ajuda del govern
	@Override
	public void pay() {
		governmentBenefits();		
	}
	
	//Setter de l'ajuda del govern. 
	public void governmentBenefits() {
		benefits=3;
	}


}
