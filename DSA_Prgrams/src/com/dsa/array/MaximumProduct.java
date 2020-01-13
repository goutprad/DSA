package com.dsa.array;

import java.util.Arrays;

/**
 * Find maximum Product of two integers in an array Input : -10, -3, 5, 6, -2
 * output : -10 and -3
 * 
 * @author goutam
 *
 */
public class MaximumProduct {

	public static void main(String[] args) {
		int[] input = { -10, -3, 5, 6, -2 };
		//int[] input2 = { 10, 3, 5, 6, -2 };
		int size = input.length;
		maximumProductOfTwo1(input, size); // Maximum Product of Two Integers are:[-10,-3]
		maximumProductOfTwo2(input, size); // Maximum Product of Two Integers are:[-10,-3]
		maximumProductOfTwo3(input, size); //Maximum Product of Two Integers are:[-10,-3]
	}

	/**
	 * Time Complexity - O(n2)
	 * 
	 * @param arr
	 * @return void
	 */
	static void maximumProductOfTwo1(int[] arr, int size) {
		if (size < 2) {
			return;
		}
		int a = arr[0];
		int b = arr[1];
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (arr[i] * arr[j] > a * b) {
					a = arr[i];
					b = arr[j];
				}
			}
		}
		System.out.println("Maximum Product of Two Integers are:[" + a + "," + b + "]");
	}

	/**
	 * Time Complexity - O(nLogn)
	 * 
	 * @param arr
	 * @param size
	 */
	static void maximumProductOfTwo2(int[] arr, int size) {
		if (size < 2) {
			return;
		}
		Arrays.sort(arr);

		if (arr[0] < 0 && arr[1] < 0) {
			System.out.println("Maximum Product of Two Integers are:[" + arr[0] + "," + arr[1] + "]");
		} else {
			System.out.println("Maximum Product of Two Integers are:[" + arr[size - 1] + "," + arr[size - 2] + "]");
		}
	}

	/**
	 * Time Complexity - O(n)
	 * 
	 * @param arr
	 * @param size
	 */
	static void maximumProductOfTwo3(int arr[], int size) {
		if (size < 2) {
			return;
		}
		int max1 = arr[0];
		int max2 = Integer.MIN_VALUE;
		int min1 = arr[0];
		int min2 = Integer.MAX_VALUE;

		for (int i = 1; i < size; i++) {
			if (arr[i] > max1) {
				max2 = max1;
				max1 = arr[i];
			} else if (arr[i] > max2) {
				max2 = arr[i];
			}

			if (arr[i] < min1) {
				min2 = min1;
				min2 = arr[i];
			} else if (arr[i] < min2) {
				min2 = arr[i];
			}
		}
		if (max1 * max2 > min1 * min2) {
			System.out.println("Maximum Product of Two Integers are:[" + max1 + "," + max2 + "]");
		} else {
			System.out.println("Maximum Product of Two Integers are:[" + min1 + "," + min2 + "]");
		}
	}
}
