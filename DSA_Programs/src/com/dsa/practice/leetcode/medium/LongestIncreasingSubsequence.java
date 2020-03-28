package com.dsa.practice.leetcode.medium;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/submissions/
 * 
 * Input: [10,9,2,5,3,7,101,18] Output: 4 Explanation: The longest increasing
 * subsequence is [2,3,7,101], therefore the length is 4.
 * 
 * @author C56086A
 *
 */
public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		int arrLen = nums.length;
		if (arrLen == 0)
			return 0;
		int[] result = new int[arrLen];
		Arrays.fill(result, 1);
		for (int i = 1; i < arrLen; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					result[i] = Math.max(result[i], 1 + result[j]);
				}
			}
		}
		System.out.println(Arrays.toString(result));
		int max = 0;
		for (int i = 0; i < result.length; i++) {
			if (result[i] > max)
				max = result[i];
		}
		return max;
	}

	public static void main(String[] args) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int[] input = { 10, 9, 2, 5, 3, 7, 101, 18 };
		// int[] input = { 1, 3, 6, 7, 9, 4, 10, 5, 6 };
		System.out.println(lis.lengthOfLIS(input));
	}
}
