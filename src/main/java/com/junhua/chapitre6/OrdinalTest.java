package com.junhua.chapitre6;

public class OrdinalTest {

	public enum Ensemble{
		SOLO, DUET,TRIO,QUATRE,QUINTET,SEXTET,SEPTET,OCTET,NONET,DECTET;
	
		public int numbreOfMusicians(){
			return ordinal();
		}
	}
	
	
	public enum Ensemble2{
		
		SOLO(1), DUET(2),TRIO(3),QUATRE(4),QUINTET(5),SEXTET(6),SEPTET(7),OCTET(10),NONET(9),DECTET(12);
		
		private final int numberOfMusicians;
		private Ensemble2(int numberOfMusicians) {
			this.numberOfMusicians = numberOfMusicians;
		}
		public int getNumbreOfMusicians(){
			return numberOfMusicians;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Ensemble.DECTET.numbreOfMusicians());
		System.out.println(Ensemble2.DECTET.getNumbreOfMusicians());
	}
	
}
