package com.dsa.sort.algos;

import java.util.Arrays;

/**
 * Merge Sort in iterative way
 * 
 * @author Goutam
 *
 */
public class MergeSortIterative {
	int[] arr;
	int size;

	public MergeSortIterative(int[] arr) {
		this.arr = arr;
		this.size = arr.length;
	}

	public void sort() {
		for (int i = 1; i < arr.length; i = i + i) {
			for (int j = 0; j < arr.length; j += i + i) {
				merge(j, j + i - 1, Math.min(j + i + i - 1, size - 1));
			}
		}
	}

	public void merge(int low, int mid, int high) {
		int i = low;
		int j = mid + 1;
		int k = 0;
		int[] temp = new int[size];

		while (i <= mid && j <= high) {
			if (arr[i] < arr[j]) {
				temp[k] = arr[i];
				i++;
			} else {
				temp[k] = arr[j];
				j++;
			}
			k++;
		}

		while (i <= mid) {
			temp[k] = arr[i];
			i++;
			k++;
		}

		while (j <= high) {
			temp[k] = arr[j];
			j++;
			k++;
		}

		k = 0;
		while (low <= high) {
			arr[low++] = temp[k++];

		}
	}

	public static void main(String[] args) {
		int[] input = { 6, 3, 7, 1, 5, 4, 9, 8, 2 };
		MergeSortIterative msi = new MergeSortIterative(input);
		msi.sort();
		System.out.println(Arrays.toString(input)); //[1, 2, 3, 4, 5, 6, 7, 8, 9]
	}

}
