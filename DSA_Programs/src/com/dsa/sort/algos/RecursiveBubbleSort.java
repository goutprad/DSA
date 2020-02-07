package com.dsa.sort.algos;

import java.util.Arrays;

/**
 * Recursive Bubble Sort Implementation
 * 
 * @author Goutam
 *
 */
public class RecursiveBubbleSort {
	/**
	 * recursiveBubbleSort
	 * 
	 * @param arr
	 * @param n
	 */
	public void recursiveBubbleSort(int[] arr, int n) {
		if (n == 1) {
			return;
		}
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
		recursiveBubbleSort(arr, n - 1);
	}

	public static void main(String[] args) {
		RecursiveBubbleSort recBubble = new RecursiveBubbleSort();
		int[] input = { 3, 5, 4, 7, 9, 6, 2, 1, 8 };
		System.out.println("Before Sort: " + Arrays.toString(input));
		recBubble.recursiveBubbleSort(input, input.length);
		System.out.println("After Sort: " + Arrays.toString(input));
	}

}
