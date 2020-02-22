package com.dsa.practice.leetcode.easy;

import java.util.Arrays;

/**
 * 905. Sort Array By Parity
 * https://leetcode.com/problems/sort-array-by-parity/
 * 
 * @author Goutam
 *
 */
public class SortArrayByParity {

	public int[] sortArrayByParity(int[] A) {
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 0) {
				int temp = A[count];
				A[count++] = A[i];
				A[i] = temp;
			}
		}
		return A;
	}

	public static void main(String[] args) {
		SortArrayByParity leetcode = new SortArrayByParity();
		int[] A = { 3, 1, 2, 4 };
		int[] result = leetcode.sortArrayByParity(A);
		System.out.println(Arrays.toString(result));
	}

}
