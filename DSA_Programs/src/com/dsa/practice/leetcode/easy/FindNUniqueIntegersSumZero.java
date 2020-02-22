package com.dsa.practice.leetcode.easy;

import java.util.Arrays;

/**
 * 1304. Find N Unique Integers Sum up to Zero
 * https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
 * 
 * @author Goutam
 *
 */
public class FindNUniqueIntegersSumZero {
	public int[] sumZero(int n) {
		int[] result = new int[n];
		int value = -n / 2;
		for (int i = 0; i < result.length; i++) {
			if (n % 2 == 0 && value == 0) {
				value++; // skip adding zero for even number
			}
			result[i] = value++;
		}
		return result;
	}

	public int[] sumZero_01(int n) {
		int[] result = new int[n];
		int len = n - 1;
		int i = 0;
		while (i < len) {
			result[i] = -(n - 1);
			result[len] = n - 1;
			len--;
			i++;
			n--;
		}
		return result;
	}

	public static void main(String[] args) {
		FindNUniqueIntegersSumZero leetcode = new FindNUniqueIntegersSumZero();
		int[] result = leetcode.sumZero(0);
		int[] result_01 = leetcode.sumZero_01(7);
		System.out.println(Arrays.toString(result));
		System.out.println(Arrays.toString(result_01));
	}

}
