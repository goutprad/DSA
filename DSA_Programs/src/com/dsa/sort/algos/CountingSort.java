package com.dsa.sort.algos;

import java.util.Arrays;

public class CountingSort {
	public int[] sort(int[] arr) {
		int[] buckets = new int[10];
		for (int i = 0; i < arr.length; i++) {
			buckets[arr[i]]++;
		}
		int j = 0;
		for (int i = 0; i < buckets.length; i++) {
			while (buckets[i] != 0) {
				arr[j++] = i;
				buckets[i]--;
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 8, 7, 1, 2, 2, 2, 7, 3, 9, 8, 2, 1, 4, 2, 4, 6, 9, 2 };
		CountingSort countingSort = new CountingSort();
		int[] sortedArr = countingSort.sort(arr);
		System.out.println(Arrays.toString(sortedArr));
	}

}
