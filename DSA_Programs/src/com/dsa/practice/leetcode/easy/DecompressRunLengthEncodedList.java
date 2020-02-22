package com.dsa.practice.leetcode.easy;

import java.util.Arrays;

/**
 * 1313. Decompress Run-Length Encoded List
 * https://leetcode.com/problems/decompress-run-length-encoded-list/
 * 
 * @author Goutam
 *
 */
public class DecompressRunLengthEncodedList {
	/**
	 * Time Complexity
	 * 
	 * @param nums
	 * @return
	 */
	public int[] decompressRLElist(int[] nums) {
		int resultSize = 0;
		for (int i = 0; i < nums.length; i += 2) {
			resultSize += nums[i];
		}
		int[] result = new int[resultSize];
		int j = 0;
		for (int i = 0; i < nums.length; i += 2) {
			int freq = nums[i];
			int val = nums[i + 1];
			while (freq > 0) {
				result[j++] = val;
				freq--;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		DecompressRunLengthEncodedList leetcode = new DecompressRunLengthEncodedList();
		int[] nums = { 1, 2, 3, 4 };
		int[] result = leetcode.decompressRLElist(nums);
		System.out.println(Arrays.toString(result)); // [2, 4, 4, 4]
	}

}
