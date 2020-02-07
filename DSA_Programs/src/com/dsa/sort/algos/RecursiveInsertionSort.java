package com.dsa.sort.algos;

import java.util.Arrays;

/**
 * Recursive Insertion Sort Implementation
 * 
 * @author Goutam
 *
 */
public class RecursiveInsertionSort {
	/**
	 * recursiveInsertionSort
	 * 
	 * @param arr
	 * @param n
	 */
	public void recursiveInsertionSort(int[] arr,int n) {
		if(n<=1) {
			return;
		}
		recursiveInsertionSort(arr, n-1);
		int currentNum = arr[n-1];
		int j=n-2;
		while(j>=0 && arr[j]>currentNum) {
			arr[j+1]=arr[j];
			j--;
		}
		arr[j+1] =currentNum;
	}

	public static void main(String[] args) {
		RecursiveInsertionSort recInsert = new RecursiveInsertionSort();
		int[] input = { 3, 5, 4, 7, 9, 6, 2, 1, 8 };
		System.out.println("Before Sort: " + Arrays.toString(input));
		recInsert.recursiveInsertionSort(input, input.length);
		System.out.println("After Sort: " + Arrays.toString(input));
	}

}
