package com.dsa.practice.leetcode.easy;

import java.util.Arrays;

public class SortArrayByParityII {
	public int[] sortArrayByParityII(int[] A) {
		int even = 0;
		int odd = 1;
		int size = A.length;
		int[] result = new int[size];
		for (int i = 0; i < size; i++) {
			int item = A[i];
			if (item % 2 == 0) {
				result[even] = item;
				even += 2;
			} else {
				result[odd] = item;
				odd += 2;
			}
		}
		return result;
	}

	public int[] sortArrayByParityII_02(int[] A) {
		int size = A.length;
		int even = 0;
		int odd = 1;
		while (odd < size && even < size) {
			while (even < size && A[even] % 2 == 0) {
				even += 2;
			}
			while (odd < size && A[odd] % 2 == 1) {
				odd += 2;
			}
			if (even < size && odd < size) {
				int temp = A[odd];
				A[odd] = A[even];
				A[even] = temp;
			}
		}
		return A;
	}

	public static void main(String[] args) {
		SortArrayByParityII leetcode = new SortArrayByParityII();
		int[] A = { 3, 1, 4, 2 };
		int[] result = leetcode.sortArrayByParityII(A);
		System.out.println(Arrays.toString(result));
		int[] A1 = { 3, 1, 4, 2 };
		int[] result_01 = leetcode.sortArrayByParityII_02(A1);
		System.out.println(Arrays.toString(result_01));
	}
}
