package com.dsa.sort.algos;

/**
 * Insertion Sort-(Stable Sort)
 * 
 * Time Complexity- O(n^2) 
 * Space Complexity - O(1)
 * 
 * @author Goutam
 *
 */
public class InsertionSort {
	/**
	 * insertionSort
	 * 
	 * @param arr
	 * @return
	 */
	public int[] insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j = i;
			int currNum = arr[i];

			while (j > 0 && currNum < arr[j - 1]) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = currNum;
		}
		return arr;
	}

	public static void main(String[] args) {
		InsertionSort insertSort = new InsertionSort();
		int[] input = { 3, 5, 4, 7, 9, 6, 2, 1, 8 };
		System.out.print("Before Sorting : ");
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		System.out.println();
		int[] sorted = insertSort.insertionSort(input);
		System.out.print("After Sorting : ");
		for (int i = 0; i < sorted.length; i++) {
			System.out.print(sorted[i] + " "); // 1 2 3 4 5 6 7 8 9
		}
	}

}
