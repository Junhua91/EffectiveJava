package com.chapitre8.item46;

public class TestIterable {

	public static void main(String[] args) {
		Integer[] ints = { 1, 2, 3 };
		MyIterable<Integer> myList = new MyIterable<>(ints);
		for (Integer i : myList) {
			System.out.println(i);
		}
	}
}
s