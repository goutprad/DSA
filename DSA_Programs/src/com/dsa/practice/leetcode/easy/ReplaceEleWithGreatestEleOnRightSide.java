package com.dsa.practice.leetcode.easy;

import java.util.Arrays;

/**
 * 1299. Replace Elements with Greatest Element on Right Side
 * https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
 * 
 * @author Goutam
 *
 */
public class ReplaceEleWithGreatestEleOnRightSide {
	public int[] replaceElements(int[] arr) {
		int max = -1;
		int cur=0;
		for (int i = arr.length - 1; i > -1; --i) {
			cur = arr[i];
			arr[i] = max;
			max = Math.max(max, cur);
		}
		return arr;
	}

	public static void main(String[] args) {
		ReplaceEleWithGreatestEleOnRightSide leetcode = new ReplaceEleWithGreatestEleOnRightSide();
		int[] arr = { 17, 18, 5, 4, 6, 1 };
		int[] result = leetcode.replaceElements(arr);
		System.out.println(Arrays.toString(result));
	}

}
