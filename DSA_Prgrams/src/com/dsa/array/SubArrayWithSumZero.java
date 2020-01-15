package com.dsa.array;

/**
 * check if sub array with 0 sum is exist or not 
 * Input : 3 4 3 -2 -5 1 3 1 -4 -2 -2
 * 
 * @author Goutam
 *
 */
public class SubArrayWithSumZero {

	public static void main(String[] args) {
		int[] arr = { 3, 4, 3, -2, -5, 1, 3, 1, -4, -2, -2 };
		int[] arr2 = {3,4,3,-2 ,-5, 1 ,0 ,1 ,-4, -2 ,-3};
		//3 7 10 8 3 4 7 8 4 2 -2 
		int arr1[] = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
		//6 9 8 5 9 7 9 13 19 7 -7 
		System.out.println();
		for (int i = 1; i < arr2.length-1; i++) {
			arr2[i] = arr2[i-1]+arr2[i];
		}
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i]+" ");
		}
		
	}

}
