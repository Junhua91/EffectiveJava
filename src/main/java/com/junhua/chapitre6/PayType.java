package com.junhua.chapitre6;

public enum PayType {

	WeekDay{
		@Override
		double overtimePay(double time, double rate) {
			return time<= HOUR_PER_SHIFT ? time* rate: (time - HOUR_PER_SHIFT) * rate;
		}
	},
	
	Weekend{
		@Override
		double overtimePay(double time, double rate) {
			return time*rate;
		}
	};
	
	private static final int HOUR_PER_SHIFT = 8;
	
	abstract double overtimePay(double time, double rate);
	
	public double pay(double hours, double payRate){
		double basePay = hours* payRate;
		return basePay+ overtimePay(hours, payRate);
	}
	 
}
