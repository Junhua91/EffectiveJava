package com.junhua.chapitre6;

public enum Operation {

	PLUS("+"){
		@Override
		double operation(double x, double y) {
			return x+y;
		}
	};
	
	private String symbol;
	
	private Operation(String symbol){
		this.symbol = symbol; 
				
	}
	abstract double operation(double x,double y);
	
	public String getSymbol(){
		return symbol;
	}
}
