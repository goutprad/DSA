package com.dsa.practice.leetcode.medium;

/**
 * 281. Zigzag Iterator https://leetcode.com/problems/zigzag-iterator/
 * 
 * Given two 1d vectors, implement an iterator to return their elements
 * alternately. Example: Input: v1 = [1,2], v2 = [3,4,5,6] Output: [1,3,2,4,5,6]
 * 
 * Explanation: By calling next repeatedly until hasNext returns false, the
 * order of elements returned by next should be: [1,3,2,4,5,6].
 * 
 * @author Goutam
 *
 */
public class ZigZagIterator {
	int[] arr1;
	int[] arr2;
	boolean flag = false;
	int i, j = 0;

	public ZigZagIterator(int[] arr1, int[] arr2) {
		this.arr1 = arr1;
		this.arr2 = arr2;
	}

	public int next() {
		int item = 0;
		flag = !flag;
		if (flag & i < arr1.length) {
			item = arr1[i++];
		} else if (j < arr2.length) {
			item = arr2[j++];
		}
		return item;
	}

	public boolean hasNext() {
		if (i == arr1.length && j == arr2.length)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2 };
		int[] arr2 = { 3, 4, 5, 6 };
		ZigZagIterator zigZag = new ZigZagIterator(arr1, arr2);
		while (zigZag.hasNext()) {
			System.out.print(zigZag.next() + " ");
		}
	}
}
