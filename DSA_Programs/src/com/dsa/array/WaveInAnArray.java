package com.dsa.array;

import java.util.Arrays;

/**
 * Create Wave of Array (Containing distint elements) Input : 1 3 6 4 7 8 9 5 2
 * 
 * @author Goutam
 *
 */
public class WaveInAnArray {
	public static void main(String[] args) {
		int arr1[] = { 1, 3, 6, 4, 7, 8, 9, 5, 2 };
		int[] out1 = createWave(arr1, arr1.length);
		for (int i = 0; i < out1.length; i++) {
			System.out.print(out1[i] + " ");
		}
		System.out.println();
		int arr[] = { 10, 90, 49, 2, 1, 5, 23 };
		int[] out = createWaveUsingSort(arr, arr.length);
		for (int i = 0; i < out.length; i++) {
			System.out.print(out[i] + " ");
		}
	}

	/**
	 * Time Complexity - o(n), space Complexity - o(1)
	 * 
	 * @param arr
	 * @param size
	 * @return int[]
	 */
	static int[] createWave(int[] arr, int size) {
		for (int i = 0; i < arr.length - 1; i += 2) {
			if (i > 0 && arr[i - 1] > arr[i]) {
				swap(arr, i - 1, i);
			}

			if (i < size - 1 && arr[i] < arr[i + 1]) {
				swap(arr, i, i + 1);
			}
		}
		return arr;
	}

	/**
	 * Time Complexity - o(nlogn), space Complexity - o(nlogn)
	 * 
	 * @param arr
	 * @param size
	 * 
	 * @return int[]
	 */
	static int[] createWaveUsingSort(int[] arr, int size) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 1; i += 2) {
			swap(arr, i, i + 1);
		}
		return arr;
	}

	/**
	 * swap two element in an array
	 * 
	 * @param arr
	 * @param a
	 * @param b
	 */
	static void swap(int[] arr, int a, int b) {
		arr[a] = arr[a] + arr[b];
		arr[b] = arr[a] - arr[b];
		arr[a] = arr[a] - arr[b];
	}

}
