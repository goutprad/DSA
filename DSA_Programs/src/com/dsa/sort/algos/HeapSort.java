package com.dsa.sort.algos;

import com.dsa.heap.MinHeapByArray;

/**
 * Heap Sort
 * 
 * @author Goutam
 *
 */
public class HeapSort {
	int[] arr;

	public HeapSort(int[] arr) {
		this.arr = arr;
	}

	/**
	 * heapSort
	 */
	public void heapSort() {
		MinHeapByArray minHeap = new MinHeapByArray(arr.length + 1);
		for (int i = 0; i < arr.length; i++) {
			minHeap.insert(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = minHeap.delMin();
		}
	}

	public static void main(String[] args) {
		int arr[] = { 10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8 };
		HeapSort hsort = new HeapSort(arr);
		System.out.println("Before sorting...");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		hsort.heapSort();
		System.out.println("after sorting...");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
