package com.dsa.practice.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 1051. Height Checker
 * https://leetcode.com/problems/height-checker/
 * 
 * @author Goutam
 *
 */
public class HeightChecker {
	public int heightChecker(int[] heights) {
		ArrayList<Integer> original = new ArrayList<Integer>();
		//final int[] original = Arrays.copyOf(heights, heights.length); or array clone
		for (int i = 0; i < heights.length; i++) {
			original.add(heights[i]);
		}
		Arrays.sort(heights);
		int moveCount = 0;
		for (int i = 0; i < heights.length; i++) {
			if (original.get(i) != heights[i]) {
				moveCount++;
			}
		}
		return moveCount;
	}

	public static void main(String[] args) {
		HeightChecker leetcode = new HeightChecker();
		int[] heights = { 1, 1, 4, 2, 1, 3 }; // non-decreasing [1,1,1,2,3,4]
		int result = leetcode.heightChecker(heights);
		System.out.println(result);
	}

}
