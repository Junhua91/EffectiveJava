package com.junhua.interview;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {

	public static void main(String[] args) {
		Solution4 solution4 = new Solution4();
		solution4.test();
	}

	public void permutation(char[] s, int i, List<String> list) {

		if (i == s.length - 1)
			list.add(String.valueOf(s));
		else {
			for (int j = i; j < s.length; ++j) {
//				if (j==i || s[j] != s[i]) {
					swap(s, i, j);
					permutation(s, i + 1, list);
					swap(s, i, j);
				}
//			}

		}
	}

	public void swap(char[] str, int i, int j) {
		if (i != j) {
			char t = str[i]; 
			str[i] = str[j];
			str[j] = t;
		}
	}

	public void test() {
		String s = "aac";
		List<String> list = new ArrayList<>();
		permutation(s.toCharArray(), 0, list);

		for (String string : list) {
			System.out.println(string);
		}
	}
}
