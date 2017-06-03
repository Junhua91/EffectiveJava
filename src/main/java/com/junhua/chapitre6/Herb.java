package com.junhua.chapitre6;

public class Herb {

	public enum Type{
		ANNUAL,PERENNIAL,BIENNIAL
	}

	
	protected String name;
	protected Type type;
	
	Herb(String name, Type type){
		this.name = name;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
