package com.junhua.interview;

import java.util.Stack;

public class MainTest {

	public static void main(String[] args) {
		test1();

		test2();

		test3_1();

		test4();

		test5();

		test7();

		test8();

		test9();

		test10();

		test11();

		test12();

		test13();

		test14();

	}

	public static boolean find(int[][] array, int value) {
		if (array == null)
			return false;

		int nbCol = array[0].length;
		int nbRow = array.length;

		int i = 0;
		while (i < nbRow && array[i][nbCol - 1] < value) {
			i++;
		}
		if (i == nbRow)
			return false;

		for (int j = 0; j < nbCol; j++) {
			if (array[i][j] == value)
				return true;
		}
		return false;
	}

	public static void test1() {

		int[][] array = { { 1, 2, 3, 4 }, { 5, 6, 7, 8, 9 }, { 10, 11, 12, 16 }, { 18, 79, 88, 99 } };
		System.out.println(find(array, 12));
		System.out.println(find(array, 13));
		System.out.println(find(array, 99));
	}

	public static String replaceSpace(char[] s) {
		if (s == null)
			return null;
		int length = s.length;
		int spaceCount = 0;

		for (int i = 0; i < length; i++) {
			if (s[i] == ' ')
				spaceCount++;
		}
		if (spaceCount == 0)
			return new String(s);

		char[] newS = new char[length + 2 * spaceCount];

		for (int j = 0, i = j; j < length; j++) {
			if (s[j] == ' ') {
				newS[i] = '%';
				newS[i + 1] = '2';
				newS[i + 2] = '0';
				i += 3;
			} else {
				newS[i] = s[j];
				i++;
			}
		}

		return new String(newS);
	}

	public static void test2() {
		char[] s = { 'i', ' ', 'a', 'm', ' ', 's', 'a', 'd' };
		System.out.println(replaceSpace(s));

		char[] string = new char[50];
		string[0] = ' ';
		string[1] = 'e';
		string[2] = ' ';
		string[3] = ' ';
		string[4] = 'r';
		string[5] = 'e';
		string[6] = ' ';
		string[7] = ' ';
		string[8] = 'a';
		string[9] = ' ';
		string[10] = 'p';
		string[11] = ' ';
		System.out.println(replaceSpace(string));
	}

	static class ListNode {
		int value;
		ListNode next;
	}

	public static void printListNode(ListNode root) {
		Stack<ListNode> stack = new Stack<>();
		while (root != null) {
			stack.push(root);
			root = root.next;
		}

		while (!stack.isEmpty()) {
			System.out.println(stack.pop().value);
		}
	}

	public static void printListNode2(ListNode root) {
		if (root == null)
			return;
		else {
			printListNode(root.next);
			System.out.println(root.value);
		}
	}

	public static void test3_1() {
		ListNode root = new ListNode();
		root.value = 1;
		root.next = new ListNode();
		root.next.value = 2;
		root.next.next = new ListNode();
		root.next.next.value = 3;
		root.next.next.next = new ListNode();
		root.next.next.next.value = 4;
		root.next.next.next.next = new ListNode();
		root.next.next.next.next.value = 5;

		printListNode(root);
		printListNode2(root);
	}

	public static class BinaryTreeNode {
		BinaryTreeNode leftTree;
		BinaryTreeNode rightTree;
		int value;
	}

	public static BinaryTreeNode construct(int[] preOrder, int[] inOrder) {
		if (preOrder == null || inOrder == null || inOrder.length != preOrder.length)
			return null;
		return construct(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
	}

	public static BinaryTreeNode construct(int[] preOrder, int start1, int end1, int[] inOrder, int start2, int end2) {

		if (start1 > end1)
			return null;

		int index = start2;

		while (index <= end2 && inOrder[index] != preOrder[start1]) {
			index++;
		}

		BinaryTreeNode bts = new BinaryTreeNode();

		bts.value = preOrder[start1];
		bts.leftTree = construct(preOrder, start1 + 1, index - start2 + start1, inOrder, start2, index - 1);
		bts.rightTree = construct(preOrder, start1 + index - start2 + 1, end1, inOrder, index + 1, end2);

		return bts;
	}

	public static void printBTS(BinaryTreeNode root) {
		if (root != null) {
			System.out.print(root.value);
			printBTS(root.leftTree);
			printBTS(root.rightTree);
		}
	}

	public static void printBTS2(BinaryTreeNode root) {
		if (root != null) {
			printBTS(root.leftTree);
			System.out.print(root.value);
			printBTS(root.rightTree);
		}
	}

	private static void test4() {
		System.out.println("test4");
		int[] preorder = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] inorder = { 4, 7, 2, 1, 5, 3, 8, 6 };
		BinaryTreeNode root = construct(preorder, inorder);
		printBTS(root);
		System.out.println();
		printBTS2(root);
	}

	public static int findMin(int[] array) {

		int start = 0;
		int end = array.length - 1;
		int mid = end;

		while (array[start] >= array[end]) {
			if (end - start == 1)
				return array[end];
			mid = start + (end - start) / 2;
			if (array[mid] >= array[start])
				start = mid;
			if (array[mid] <= array[end])
				end = mid;
		}
		return array[mid];
	}

	public static void test5() {
		System.out.println("test5");
		int[] array1 = { 3, 4, 5, 1, 2 };
		System.out.println(findMin(array1));
	}

	public static int fibonacci(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		int result = 0;

		return result;
	}

	public static double power(double base, int exponent) {
		double result = 1;
		if (exponent == 0)
			return 1;
		while (exponent > 0) {
			result *= base;
			exponent--;
		}

		while (exponent < 0) {
			result *= (1 / base);
			exponent++;
		}
		return result;
	}

	public static boolean doubleEqual(double a, double b) {
		if (a - b < 0.000001 && a - b > -0.000001)
			return true;
		else
			return false;
	}

	public static int absExponent(int a) {
		if (a < 0)
			return -a;
		else
			return a;
	}

	public static double power2(double base, int exponent) {
		if (doubleEqual(base, 0) && exponent == 0)
			throw new ArithmeticException();

		if (exponent == 1)
			return base;
		if (exponent == 0)
			return 1;

		double result = power2(base, exponent >> 1);
		result *= result;

		if (exponent % 2 == 1)
			result *= base;

		return result;
	}

	public static double power3(double base, int exponent) {

		double result = 1;
		int exp = exponent;
		while (exponent != 0) {
			exponent /= 2;
			result *= (base * base);
		}

		if (exp % 2 == 1)
			result *= base;
		return result;
	}

	public static double doPower(double base, int exponent) {
		int exp = absExponent(exponent);
		double result = power2(base, exp);

		if (exponent > 0)
			return result;
		else
			return 1 / result;
	}

	public static double doPower2(double base, int exponent) {
		int exp = absExponent(exponent);
		double result = power3(base, exp);

		if (exponent > 0)
			return result;
		else
			return 1 / result;
	}

	public static void test7() {
		System.out.println("test7");
		System.out.println(doPower(2, 10));
		System.out.println(doPower(2, -6));
		System.out.println(doPower2(2, -6));
		System.out.println(doPower2(2, 9));
	}

	public static void printOneToNthDigits(int n) {
		if (n < 1) {
			throw new RuntimeException("The input number must larger than 0");
		}
		int[] arr = new int[n];
		printOneToNthDigits(0, arr);
	}

	public static void printOneToNthDigits(int n, int[] arr) {
		if (n >= arr.length) {
			printArray(arr);
		} else {
			for (int i = 0; i <= 9; i++) {
				arr[n] = i;
				printOneToNthDigits(n + 1, arr);
			}
		}
	}

	public static void printArray(int[] arr) {
		int index = 0;
		while (index < arr.length && arr[index] == 0) {
			index++;
		}

		for (int i = index; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		if (index < arr.length) {
			System.out.println();
		}
	}

	public static void test8() {
		printOneToNthDigits(2);
	}

	public static void test9() {
		int[] array = { 5, 1, 12, -5, 16, 2, 12, 14 };
		selectionSort(array);

		for (int i : array) {
			System.out.println(i);
		}
	}

	public static void test10() {
		int[] array = { 5, 1, 12, -5, 16, 2, 12, 14 };
		selectionSort2(array);

		for (int i : array) {
			System.out.println(i);
		}
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

	public static void test11() {
		int[] array = { 5, 1, 12, -5, 16, 2, 12, 14 };
		insertionSort(array);

		for (int i : array) {
			System.out.println(i);
		}
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

	public static void test12() {
		int[] array = { 6, 5, 3, 1, 8, 7, 2, 4 };
		quickSort(array, 0, array.length - 1);

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
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


	public static void test13(){
		System.out.println("test13");
	}
}
