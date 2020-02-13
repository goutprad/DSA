package com.dsa.sort.algos;

import java.util.Arrays;

/**
 * Merge Sort in recursive way
 * 
 * @author Goutam
 *
 */
public class MergeSort {
	int[] arr;
	int size;

	public MergeSort(int[] arr) {
		this.arr = arr;
		this.size = arr.length;
	}

	public void mergeSort(int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(low, mid);
			mergeSort(mid + 1, high);
			merge(low, mid, high);
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
		MergeSort ms = new MergeSort(input);
		ms.mergeSort(0, input.length - 1);
		System.out.println(Arrays.toString(input)); //[1, 2, 3, 4, 5, 6, 7, 8, 9]
	}

}
