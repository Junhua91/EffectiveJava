package com.junhua.interview;

public class Sneeze extends Annoyance {

	public static void main(String[] args) throws Exception {
		try {
			try {
//				throw new Sneeze();
				throw new Annoyance();
			} catch (Sneeze a) {
//			} catch (Annoyance a) {
				System.out.println("Caught Annoyance");
				throw a;
			}
		} catch (Sneeze s) {
			System.out.println("Caught Sneeze");
			return;
		} finally {
			System.out.println("Hello World!");
		}
	}

}

class Annoyance extends Exception {

}