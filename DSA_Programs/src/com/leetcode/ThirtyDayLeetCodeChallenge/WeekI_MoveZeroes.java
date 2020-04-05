package com.leetcode.ThirtyDayLeetCodeChallenge;

import java.util.Arrays;

public class WeekI_MoveZeroes {
	public void moveZeroes(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[count++] = nums[i];
			}
		}
		while (count < nums.length) {
			nums[count++] = 0;
		}
	}
	
	public static void main(String[] args) {
		WeekI_MoveZeroes moveZero = new WeekI_MoveZeroes();
		int[] arr = { 1, 0, 4, 5, 6, 0, 4, 0, 3, 0, 1, 0, 5 };
		moveZero.moveZeroes(arr);
		System.out.println(Arrays.toString(arr));
	}
}
