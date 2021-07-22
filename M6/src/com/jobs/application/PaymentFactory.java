package com.jobs.application;

import com.jobs.domain.IPaymentRate;

public class PaymentFactory {

	//Modificaci� Salari Boss - Augment del 50%
	public static IPaymentRate createPaymentRateBoss(){
		return new IPaymentRate() {	
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*1.5;
			}
		};
	}
	//Modificaci� Salari Employee - Reducci� del 15%
	public static IPaymentRate createPaymentRateEmployee(){ 
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth;
			}
		};
	}

	//Modificaci� Salari Manager - Augment del 10%
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