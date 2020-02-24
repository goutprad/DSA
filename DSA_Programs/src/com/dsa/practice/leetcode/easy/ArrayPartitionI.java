package com.dsa.practice.leetcode.easy;

import java.util.Arrays;

public class ArrayPartitionI {
	public int arrayPairSum(int[] nums) {
		int result = 0;
		int size = nums.length;
		Arrays.sort(nums);
		for (int i = 0; i < size; i += 2) {
			result += Math.min(nums[i], nums[i + 1]);
		}
		return result;
	}

	public int[] sort(int[] nums) { //this exceed time limit in leetcode
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 0; j < nums.length - 1 - i; j++) {
				if (nums[j] > nums[j + 1]) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
		}
		return nums;
	}

	public static void main(String[] args) {
		ArrayPartitionI leetcode = new ArrayPartitionI();
		int[] nums = { 3, 1, 4, 2 };
		int result = leetcode.arrayPairSum(nums);
		System.out.println(result);
	}

}
