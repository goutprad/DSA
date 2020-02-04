package com.dsa.sort.algos;

/**
 * Selection Sort -(In-Place Sort)
 * 
 * Time Complexity- O(n^2) 
 * Space Complexity - O(1)
 * 
 * @author Goutam
 *
 */
public class SelectionSort {
	public int[] selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j += 1) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			if (min != i) {
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		SelectionSort selsort = new SelectionSort();
		int[] input = { 3, 5, 4, 7, 9, 6, 2, 1, 8 };
		System.out.print("Before Sorting : ");
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		System.out.println();
		int[] sorted = selsort.selectionSort(input);
		System.out.print("After Sorting : ");
		for (int i = 0; i < sorted.length; i++) {
			System.out.print(sorted[i] + " "); // 1 2 3 4 5 6 7 8 9
		}
	}
}
