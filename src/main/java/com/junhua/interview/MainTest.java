package com.junhua.interview;

import java.util.Stack;

public class MainTest {

	public static void main(String[] args) {
		test1();

		test2();

		test3_1();
		
		test4();
		
		test5();
		
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
	
	public static class BinaryTreeNode{
		BinaryTreeNode leftTree;
		BinaryTreeNode rightTree;
		int value;
	}
	
	public static BinaryTreeNode construct(int[]preOrder, int[]inOrder){
		if(preOrder==null || inOrder==null || inOrder.length != preOrder.length)
			return null;
		return construct(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1);
	}
	
	public static BinaryTreeNode construct(int[]preOrder, int start1, int end1, int[]inOrder, int start2, int end2){
		
		if(start1>end1)return null;
		
		int index= start2 ;
		
		while(index<=end2 && inOrder[index]!=preOrder[start1]){
			index++;
		}
		
		BinaryTreeNode bts = new BinaryTreeNode();
		
		bts.value = preOrder[start1];		
		bts.leftTree = construct(preOrder, start1+1, index-start2+start1 , inOrder, start2, index-1);
		bts.rightTree = construct(preOrder, start1+index-start2+1, end1, inOrder, index + 1, end2);
		
		return bts;
	}
	

	public static void printBTS(BinaryTreeNode root){
		if(root!=null){
			System.out.print(root.value);
			printBTS(root.leftTree);
			printBTS(root.rightTree);
		}
	}
	
	public static void printBTS2(BinaryTreeNode root){
		if(root!=null){
			printBTS(root.leftTree);
			System.out.print(root.value);
			printBTS(root.rightTree);
		}
	}
	
	private static void test4() {  
		System.out.println("test4");
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};  
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};  
        BinaryTreeNode root = construct(preorder, inorder);  
        printBTS(root);
        System.out.println();
        printBTS2(root);
    }  
	
	public static int findMin(int[] array){
		
		int start = 0;
		int end = array.length-1;
		int mid = end;
		
		while(array[start]>=array[end]){
			if(end - start	== 1)return array[end];
			mid = start + (end-start)/2;
			if(array[mid] >= array[start])start = mid;
			if(array[mid] <= array[end]) end = mid;
		}
			return array[mid];
	}
	
	public static void test5(){
		System.out.println("test5");
        int[] array1 = {3, 4, 5, 1, 2};  
        System.out.println(findMin(array1));  
	}
	
	public static int fibonacci(int n){
		if(n == 0)return 0;
		if(n == 1)return 1;
		
		int result=0;
		
		
		return result;
	}
}
