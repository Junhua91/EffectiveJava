package com.junhua.chapitre6;

public enum PayRollDay {

	Monday(PayType.WeekDay),
	Tuesday(PayType.WeekDay), 
	Saturday(PayType.Weekend);
	
	
	private PayType payType;

	private PayRollDay(PayType payType) {
		this.payType = payType;
	}
	
}
