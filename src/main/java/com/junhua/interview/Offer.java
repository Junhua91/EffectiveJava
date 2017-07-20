package com.junhua.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

import com.junhua.interview.MainTest.ListNode;

public class Offer {

	public static void main(String[] args) {
		System.out.println(findMax());
		System.out.println(findMaxSize());

		System.out.println(FirstNotRepeatingChar("google"));

		System.out.println(FirstNotRepeatingChar2("google"));

		int[][] a = {};
		System.out.println(Find(1, a));

	}
	
	public static int findMax() {
		int[] a = { 3, 312, 32 };
		String string = "";

		ArrayList<Integer> list = new ArrayList<>();
		for (int i : a)
			list.add(i);

		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				String s1 = o1 + "" + o2;
				String s2 = o2 + "" + o1;
				return s1.compareTo(s2);
			}
		});

		for (Integer integer : list) {
			string += integer;
		}
		return Integer.parseInt(string);
	}

	public static int findMaxSize() {

		int[] array = { 2, 2, 2, 2, 3, 3, 6, 2, 1, 3 };
		int count = 1;
		int maxSize = 0;
		int endOfAscend = maxSize;

		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[i - 1]) {
				count++;
			} else {
				if (count > maxSize) {
					maxSize = count;
					endOfAscend = i;
				}
				count = 1;
			}
		}
		return array[endOfAscend - maxSize];
	}

	public static int getUglyNum(int N) {
		if (N <= 6)
			return N;
		int n2 = 0, n3 = 0, n5 = 0;
		int[] result = new int[N];
		result[0] = 1;
		for (int i = 1; i < N; i++) {
			result[i] = min(result[n2] * 2, min(result[n3] * 3, result[n5] * 5));
			if (result[i] == result[n2] * 2)
				n2++;
			if (result[i] == result[n3] * 3)
				n3++;
			if (result[i] == result[n5] * 5)
				n5++;
		}
		return result[N - 1];
	}

	public static int min(int a, int b) {
		return a < b ? a : b;
	}

	public static int FirstNotRepeatingChar(String str) {

		if (str.isEmpty())
			return -1;

		int count = 0;
		int i;

		int size = str.length();
		for (i = 0; i < size; i++) {
			char c = str.charAt(i);
			for (int j = 0; j < size; j++) {
				if (i != j) {
					count++;
					if (c == str.charAt(j)) {
						count = 0;
						break;
					}
				}
			}
			if (count == size - 1)
				break;
		}
		return i;
	}

	public static int FirstNotRepeatingChar2(String str) {
		char[] array = str.toCharArray();

		int[] a = new int['z' + 1];
		for (char c : array) {
			a[(int) c]++;
		}

		for (int i = 0; i < array.length; i++) {
			if (a[(int) array[i]] == 1)
				return i;
		}

		return -1;
	}

	public static boolean Find(int target, int[][] array) {
		int nbLine = array.length;

		if (nbLine == 0)
			return false;
		int nbCol = array[0].length;

		for (int i = 0; i < nbLine; i++) {
			if (array[i][nbCol - 1] >= target) {
				for (int j = nbCol - 1; j >= 0; j--) {
					if (target == array[i][j])
						return true;
				}
			}
		}
		return false;
	}

    public static String replaceSpace(StringBuffer str) {
    	
    	int size = str.length();

    	StringBuffer sbBuffer = new StringBuffer();
    	
    	for(int i=0;i<size;i++){
    		if(str.charAt(i)==' '){
    			sbBuffer.append("%20");
    		}else {
    			sbBuffer.append(str.charAt(i));
    		}
    	}    	
		return sbBuffer.toString();
    }
    
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    	
    	Stack<Integer> stack = new Stack<>();
    	while(listNode!=null){
    		stack.push(listNode.value);
    		listNode = listNode.next;
    	}
		
    	ArrayList<Integer>list = new ArrayList<>();
    	while(!stack.isEmpty()){
    		list.add(stack.pop());
    	}
    	return list;
    }
    
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
		return 0;
    
    }
}
