package com.junhua.interview;

import java.util.Stack;

public class MainTest {

	public static void main(String[] args) {
		test1();

		test2();

		test3_1();
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

}
