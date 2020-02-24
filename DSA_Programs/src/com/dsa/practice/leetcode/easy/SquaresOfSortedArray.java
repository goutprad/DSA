package com.dsa.practice.leetcode.easy;

import java.util.Arrays;

/**
 * 977. Squares of a Sorted Array
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 * 
 * @author Goutam
 *
 */
public class SquaresOfSortedArray {
	public int[] sortedSquares(int[] A) {
		int size = A.length;
		int i = 0;
		int j = size - 1;
		int[] result = new int[size];
		for (int k = size-1; k >= 0; k--) {
			if(Math.abs(A[i])>Math.abs(A[j])) {
				result[k] = A[i] * A[i];
				i++;
			} else {
				result[k] = A[j] * A[j];
				j--;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		SquaresOfSortedArray leetcode = new SquaresOfSortedArray();
		int[] A = { -4, -1, 0, 3, 10 };
		int[] result = leetcode.sortedSquares(A);
		System.out.println(Arrays.toString(result));
	}

}
