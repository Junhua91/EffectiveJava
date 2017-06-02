package com.junhua.interview;

import javax.swing.text.AbstractDocument.LeafElement;

public class MainTest {

	
	public static void main(String[] args) {
		test1();
	}
	
	
	public static boolean  find(int[][]array, int value){
		if(array==null)return false;
		
		int nbCol = array[0].length;
		int nbRow = array.length;
		
		int i=0;
		while(i<nbRow && array[i][nbCol-1]<value){
			i++;
		}
		if(i == nbRow)return false;
		
		for(int j = 0;j<nbCol;j++){
			if(array[i][j]==value)return true;
		}
		return false;
	}
	
	public static void test1(){
		
		int[][] array = {{1,2,3,4},{5,6,7,8,9},{10,11,12,16},{18,79,88,99}};
		System.out.println(find(array,12));
		System.out.println(find(array,13));
		System.out.println(find(array,99));
	}
	
	
	public static String replaceSpace(char[] s){
		if(s == null ) return null;
		int length = s.length;
		
		while(length>0){
				
		}
	
	
	}
	
}
