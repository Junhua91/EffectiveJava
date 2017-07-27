package com.junhua.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import com.junhua.interview.MainTest.ListNode;

public class Offer {

	public static void main(String[] args) {
		System.out.println(findMax());
		System.out.println(findMaxSize());

		System.out.println(FirstNotRepeatingChar("google"));

		System.out.println(FirstNotRepeatingChar2("google"));

		int[] a = { -1, 3, -4, 5, 1, -6, 2, 1 };
		// System.out.println(Find(1, a));

		System.out.println(JumpFloor(3));

		test(a);

		System.out.println(solution("rather", "harder"));

		int[] A = { 1, 8, -3, 0, 1, 3, -2, 4, 5 };
		System.out.println(solution(6, A));

		int[] array = { 1, 2, 3, 3, 3, 3, 4, 5 };
		System.out.println(GetNumberOfK(array, 3));

		GetNumberOfK2(array, 3, 0, array.length - 1);
		System.out.println(count);

		int[] array2 = { 1, 5, 3, 4, 7, 3, 4, 7, 5, 6 };
		int[] a1 = new int[1];
		int[] a2 = new int[1];
		FindNumsAppearOnce2(array2, a1, a2);
		System.out.print(a1[0] + " " + a2[0]);

		testSequence();

		testFindNumWithSum();
		
		testLeftRotate();
		
		System.out.println(" ".isEmpty());
		System.out.println(" ".length());
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

	public static int solution(String A, String B) {
		char[] c1 = A.toCharArray();
		char[] c2 = B.toCharArray();

		int[] a = new int['z' + 1];
		int[] b = new int['z' + 1];

		for (char c : c1) {
			a[(int) c]++;
		}

		for (char c : c2) {
			b[(int) c]++;
		}

		int result = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				result += (a[i] - b[i]) > 0 ? (a[i] - b[i]) : -(a[i] - b[i]);
			}
		}

		return result;
	}

	public static int solution(int[] A) {
		if (A.length == 0 || A == null)
			return -1;
		for (int i = 1; i < A.length; i++) {
			int min = findSmallest(A, i + 1, A.length - 1);
			int max = findGreatest(A, 0, i);

			if (A[i] >= max && A[i] <= min)
				return i;
		}
		return -1;
	}

	public static int findGreatest(int[] A, int start, int end) {
		int max = Integer.MIN_VALUE;
		for (int i = start; i <= end; i++) {
			if (A[i] >= max)
				max = A[i];
		}
		return max;
	}

	public static int findSmallest(int[] A, int start, int end) {
		int min = Integer.MAX_VALUE;
		for (int i = start; i <= end; i++) {
			if (A[i] <= min)
				min = A[i];
		}
		return min;
	}

	public static boolean findMax(int[] A) {

		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] >= A[A.length - 1])
				return false;
		}
		return true;
	}

	public static boolean findMin(int[] A) {
		for (int i = 1; i < A.length; i++) {
			if (A[i] < A[0])
				return false;
		}
		return true;
	}

	public static int solution(int K, int[] A) {
		if (A.length == 0 || A == null)
			return -1;
		if (A.length == 1)
			return 0;

		quickSort(A, 0, A.length - 1);

		int start = 0;
		int end = A.length - 1;
		int result = 0;

		while (start <= end) {
			if (A[start] + A[end] > K)
				end--;
			else if (A[start] + A[end] < K)
				start++;
			else {
				if (start == end) {
					result += 1;
					start++;
					end--;
				} else {
					int n1 = start;
					int n2 = end;
					while (A[n1] == A[start])
						n1++;
					while (A[n2] == A[end])
						n2--;
					result += (n1 - start) * (end - n2) * 2;
					start = n1;
					end = n2;
				}
			}
		}
		return result;
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

		for (int i = 0; i < size; i++) {
			if (str.charAt(i) == ' ') {
				sbBuffer.append("%20");
			} else {
				sbBuffer.append(str.charAt(i));
			}
		}
		return sbBuffer.toString();
	}

	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

		Stack<Integer> stack = new Stack<>();
		while (listNode != null) {
			stack.push(listNode.value);
			listNode = listNode.next;
		}

		ArrayList<Integer> list = new ArrayList<>();
		while (!stack.isEmpty()) {
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
		if (stack1.isEmpty() && stack2.isEmpty())
			return -1;

		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}

		return stack2.pop();
	}

	public static int JumpFloor(int target) {

		if (target == 0)
			return 0;
		if (target == 1)
			return 1;
		int pre = 1, prepre = 1, result = 0;
		for (int i = 2; i <= target; i++) {
			result = pre + prepre;
			prepre = pre;
			pre = result;
		}
		return result;
	}

	public static int test(int[] A) {
		{
			if (A.length == 0 || A == null)
				return -1;
			int sum1 = 0, sum2 = A[0], position = 0;
			// ArrayList<Integer>list = new ArrayList<>();

			for (int i = 1; i < A.length; i++) {
				sum2 += A[i];
			}

			for (position = 1; position < A.length; position++) {
				sum1 += A[position - 1];
				sum2 -= A[position];
				if (sum1 == sum2)
					return position;
			}
			return -1;
		}
	}

	public static int GetNumberOfK(int[] array, int k) {

		if (array.length == 0)
			return 0;
		int result = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] == k) {
				result = i + 1;
				while (array[result] == array[i])
					result++;
				result -= i;
				break;
			}
		}
		return result;
	}

	static int count = 0;

	/**
	 * 
	 * divide
	 * 
	 * @param array
	 * @param k
	 * @param start
	 * @param end
	 */
	public static void GetNumberOfK2(int[] array, int k, int start, int end) {
		if (start > end)
			return;
		int mid = start + (end - start) / 2;

		if (array[mid] == k) {
			count++;
			GetNumberOfK2(array, k, start, mid - 1);
			GetNumberOfK2(array, k, mid + 1, end);
		} else if (array[mid] > k) {
			GetNumberOfK2(array, k, start, mid - 1);
		} else {
			GetNumberOfK2(array, k, mid + 1, end);
		}
	}

	public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		quickSort(array, 0, array.length - 1);
		List<Integer> list = new ArrayList<>();
		if (array[0] != array[1])
			list.add(array[0]);
		if (array[array.length - 1] != array[array.length - 2])
			list.add(array[array.length - 1]);
		for (int i = 1; i < array.length - 1; i++) {
			if (array[i] != array[i - 1] && array[i] != array[i + 1])
				list.add(array[i]);
		}
		num1[0] = list.get(0);
		num2[0] = list.get(1);
	}

	public static void FindNumsAppearOnce2(int[] array, int num1[], int num2[]) {

		int result = array[0];
		for (int i = 1; i < array.length; i++) {
			result ^= array[i];
		}

		int count = 0;
		while ((result & 1) != 1) {
			count++;
			result >>= 1;
		}

		for (int i = 0; i < array.length; i++) {
			if (isBit(array[i], count))
				num1[0] ^= array[i];
			else
				num2[0] ^= array[i];
		}
	}

	public static boolean isBit(int num, int index) {
		num >>= index;
		return (num & 1) == 1;
	}

	public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		int start = 1;
		int end = 2;
		int result = 0;

		while (end > start) {
			result = (start + end) * (end - start + 1) / 2;

			if (result < sum)
				end++;
			else if (result > sum)
				start++;
			else {
				ArrayList<Integer> list2 = new ArrayList<>();
				for (int i = start; i <= end; i++) {
					list2.add(i);
				}
				list.add(list2);
				start++;
			}
		}
		return list;
	}

	public static void testSequence() {
		ArrayList<ArrayList<Integer>> list = FindContinuousSequence(100);

		for (ArrayList<Integer> arrayList : list) {
			for (Integer integer : arrayList) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}

	public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> list = new ArrayList<>();

		int start = 0;
		int end = array.length - 1;

		while (start < end) {
			if (array[start] + array[end] > sum)
				end--;
			else if (array[start] + array[end] < sum)
				start++;
			else {
				list.add(array[start]);
				list.add(array[end]);

				start++;
				end--;
			}
		}

		return findMulMax(list);
	}

	public static ArrayList<Integer> findMulMax(ArrayList<Integer> list) {

		ArrayList<Integer> list2 = new ArrayList<>();

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < list.size() - 1; i += 2) {
			int temp = list.get(i) * list.get(i + 1);
			if (temp > max) {
				max = temp;
			}
		}

		for (int i = 0; i < list.size() - 1; i += 2) {
			int temp = list.get(i) * list.get(i + 1);
			if (temp == max) {
				list2.add(list.get(i));
				list2.add(list.get(i + 1));
			}
		}

		return list2;
	}

	public static void testFindNumWithSum() {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		ArrayList<Integer> list = FindNumbersWithSum(a, 6);

		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
	}

	public static String LeftRotateString(String str, int n) {
		
		int size = str.length();
		if(size<n)return "";
		StringBuffer sb = new StringBuffer(str);
		String sb2 = sb.substring(0, n);
		sb.delete(0, n);
		sb.append(sb2);;
		return sb.toString();
	}

	public static void testLeftRotate() {
		System.out.println(LeftRotateString("abcXYZdef",3));
	}
	
    public static String ReverseSentence(String str) {

    	String[] s = str.split("\\s");
    	StringBuffer sb = new StringBuffer();
    	for(int i=s.length-1;i>=0;i--){
    		sb.append(s[i]);
    	}
    	return sb.toString();
    }
    
    public static boolean isContinuous(int [] numbers) {
    	
    	int size = numbers.length;
    	if(size!=5)return false;
    	
    	return false;
    	
    }
}
