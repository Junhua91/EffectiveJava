package com.junhua.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

import com.junhua.interview.MainTest.ListNode;

public class SortTest {

	public static void main(String[] args) {
		test11();
		test12();
		test13();
		test14();
	}
	public static void test14() {
		int[] array = { 5, 1, 12, -5, 16, 2, 12, 14 };
		bubbleSort(array);
		for (int i : array) {
			System.out.println(i);
		}
	}

	public static void bubbleSort(int[] array) {
		int size = array.length;
		int temp = 0;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	public static void selectionSort3(int[] array) {
		int size = array.length;
		int temp = 0;

		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (array[i] > array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	public static void test13() {
		int[] array = { 5, 1, 12, -5, 16, 2, 12, 14 };
		selectionSort3(array);
		for (int i : array) {
			System.out.print(i);
		}
		System.out.println();
	}

	public static void selectionSort(int[] array) {
		int size = array.length;
		int temp = 0;
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j <= size - 1; j++) {
				if (array[i] > array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	public static void selectionSort2(int[] array) {
		int size = array.length;
		int temp = 0;
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j <= size - 1; j++) {
				if (array[i] < array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	public static void insertionSort(int[] array) {
		int size = array.length;
		int temp = 0;

		for (int i = 1; i < size; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
	}

	public static void insertionSort2(int[] array) {
		int size = array.length;
		int temp = 0;

		for (int i = 1; i < size; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}

	}

	public static void test11() {
		int[] array = { 5, 1, 12, -5, 16, 2, 12, 14 };
		insertionSort2(array);

		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void quickSort(int[] array, int start, int end) {
		int i = start;
		int j = end;
		int temp = 0;

		int pivot = array[start + (end - start) / 2];
		while (i <= j) {
			while (pivot > array[i])
				i++;
			while (pivot < array[j])
				j--;
			if (i <= j) {
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}
		if (start < j)
			quickSort(array, start, j);
		if (i < end)
			quickSort(array, i, end);
	}

	public static void quickSort2(int[] array, int start, int end) {

		int i = start;
		int j = end;

		int pivot = array[start + (end - start) / 2];

		while (i <= j) {
			while (pivot > array[i])
				i++;
			while (pivot < array[j])
				j--;

			if (i <= j) {
				int temp = 0;
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}

		if (start < j)
			quickSort2(array, start, j);
		if (i < end)
			quickSort2(array, i, end);
	}

	public static void test12() {
		int[] array = { 6, 5, 3, 1, 8, 7, 2, 4 };
		quickSort2(array, 0, array.length - 1);

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void doMergeSort(int lowerIndex, int higherIndex) {

		if (lowerIndex < higherIndex) {
			int mid = lowerIndex + (higherIndex - lowerIndex) / 2;
			System.out.print(mid);
			doMergeSort(lowerIndex, mid);
			doMergeSort(mid + 1, higherIndex);
			int[] array = { 6, 5, 3, 1, 8, 7, 2, 4 };
			doMergeSort(0, array.length - 1);
		}
	}

}
