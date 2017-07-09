package com.junhua.sort;

public class BubbleSort {

	public static void main(String[] args) {
		int[] array = { 5, 1, 12, -5, 16 };
//		sort1(array);
		sort2(array);
		for (int i : array) {
			System.out.println(i);
			
			
		}
	}

	public static int[] sort1(int[] array) {
		int temp = 0;
		int size = array.length;
		for (int j = 0; j < size - 1; j++) {

			for (int i = 0; i < size - 1 - j; i++) {
				if (array[i] > array[i + 1]) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
			}
		}

		return array;
	}
	
	public static int[] sort2(int[] array) {
		int temp = 0;
		int size = array.length;
		for (int j = 0; j < size - 1; j++) {
			for (int i = size-1; i >= 1+j ; i--) {
				if (array[i-1] <array[i]) {
					temp = array[i];
					array[i] = array[i -1];
					array[i -1] = temp;
				}
			}
		}

		return array;
	}
}
