package com.dsa.sort.algos;

import java.util.Arrays;

/**
 * Quick Sort
 * 
 * @author Goutam
 *
 */
public class QuickSort {
	private int[] arr;

	public QuickSort(int[] arr) {
		this.arr = arr;
	}

	/**
	 * Approach -1
	 * 
	 * @param low
	 * @param high
	 */
	public void quickSort(int low, int high) {
		if (low < high) {
			int p = partition(low, high);
			quickSort(low, p - 1);
			quickSort(p + 1, high);
		}
	}

	public int partition(int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}

	/**
	 * approach -2
	 * 
	 * @param low
	 * @param high
	 */
	public void qsort(int low,int high) {
		anotherWaySort(low, high);
	} 
	
	public void anotherWaySort(int low,int high) {
		if(high <= low)
			   return ;
		int l=low;
		int r=high;
		int v =arr[low];
		int pivot = l+1;
		while(pivot<=r) {
			if(arr[pivot]<v) {
				int temp = arr[pivot];
				arr[pivot++]=arr[l];
				arr[l++]=temp;
			} else if(arr[pivot]>v){
				int temp = arr[r];
				arr[r--] =arr[pivot];
				arr[pivot]=temp;
			}
			else {
				pivot++;
			}
		}
		anotherWaySort(low, l-1);
		anotherWaySort(r+1, high);
		
	}
	

	public static void main(String[] args) {
		int[] input = { 3, 5, 4, 7, 9, 6, 2, 1, 8 };
		QuickSort qsort = new QuickSort(input);

		System.out.println(Arrays.toString(input));
		qsort.quickSort(0, input.length - 1);
		//qsort.qsort(0, input.length - 1);
		System.out.println(Arrays.toString(input));
	}
}
