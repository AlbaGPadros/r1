package com.jobs.application;

import com.jobs.domain.IPaymentRate;

public class PaymentFactory {

	//Modificació Salari Boss - Augment del 50%
	public static IPaymentRate createPaymentRateBoss(){
		return new IPaymentRate() {	
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*1.5;
			}
		};
	}
	//Modificació Salari Employee - Reducció del 15%
	public static IPaymentRate createPaymentRateEmployee(){ 
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth;
			}
		};
	}

	//Modificació Salari Manager - Augment del 10%
	public static IPaymentRate createPaymentRateManager(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*1.1;//todo 
			}
		};
	}
	
	
}
// ;} HOLA BON DIA