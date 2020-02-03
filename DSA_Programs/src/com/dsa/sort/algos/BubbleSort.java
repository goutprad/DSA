package com.dsa.sort.algos;

/**
 * Bubble Sort-(In-Place Sort)
 * 
 * Time Complexity- O(n^2) Space Complexity - O(1)
 * 
 * @author Goutam
 *
 */
public class BubbleSort {

	public int[] bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) { //we can find 1st bigger element
			for (int j = 0; j < arr.length - i - 1; j++) { //don't compare last bigger one, this will compare element
				// System.out.println(i+"----"+j+"-"+(j+1));
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		BubbleSort bubble = new BubbleSort();
		int[] input = { 3, 5, 4, 7, 9, 6, 2, 1, 8 };
		System.out.print("Before Sorting : ");
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		System.out.println();
		int[] sorted = bubble.bubbleSort(input);
		System.out.print("After Sorting : ");
		for (int i = 0; i < sorted.length; i++) {
			System.out.print(sorted[i] + " "); // 1 2 3 4 5 6 7 8 9
		}
	}

}
