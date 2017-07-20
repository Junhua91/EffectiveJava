package com.junhua.sort;

public class BubbleSort {

	public static void main(String[] args) {
		int[] array = { 5, 1, 12, -5, 16 };
//		sort1(array);
		sort2(array);
		for (int i : array) {
			System.out.println(i);
		}
		
		int[] array2 = {1,-2,3,10,-4,7,2,-5};
		int a	= findGreatestSumofSubArray2(array2);
		System.out.println(a);
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
	
	public static int FindGreatestSumOfSubArray(int[] array) {
        
 		int size = array.length;
        int max = array[0];
        
        for(int i=0;i<size;i++){
            int temp = 0;
            for(int j=i;j<size;j++){
            	temp+=array[j];  
                if(max<temp){
                	max = temp;
            	}
            }
        }
        return max;
    }
	
	public static int findGreatestSumofSubArray2(int[]array){
		
		int size = array.length;
		int currentVal  = 0;
		int max = array[0];
		
		for(int i=0;i<size;i++){
			
			if(currentVal <0)currentVal = array[i];
			else{
				currentVal+=array[i];
			}
			
			if(max<currentVal)
				max=currentVal;
		}
		return max;
	}
}
