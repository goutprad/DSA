package com.dsa.practice.leetcode.hard;

import java.util.Stack;

/**
 * 42. Trapping Rain Water 
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * @author Goutam
 *
 */
public class RainWaterTrap {
	/**
	 * Solution 1:
	 * 
	 * @param input
	 * @return
	 */
	public int waterTrapSolution1(int[] input) {
		int lMax = Integer.MIN_VALUE;
		int[] rMax = new int[input.length];

		int max = input[input.length - 1];
		for (int i = input.length - 1; i >= 0; i--) {
			if (max < input[i]) {
				max = input[i];
			}
			rMax[i] = max;
		}
		int waterTrapped = 0;
		for (int j = 0; j < input.length - 1; j++) {
			if (lMax < input[j]) {
				lMax = input[j];
			}
			waterTrapped += Math.min(lMax, rMax[j]) - input[j];
		}
		return waterTrapped;
	}

	/**
	 * Solution 2- By using stack
	 * 
	 * @description- push index to stack by descending order of value, if any
	 *               greater value occur pop them out and use formula to calculate
	 *               area of water
	 * 
	 * @param input
	 * @return
	 */
	public int waterTrapSolution2(int[] input) {
		Stack<Integer> stack = new Stack<Integer>();
		int poped = Integer.MIN_VALUE;
		int waterTrapped = 0;
		stack.push(0);
		for (int i = 1; i < input.length; i++) {
			if (input[i] < input[stack.peek()]) {
				stack.push(i);
			} else {
				while (!stack.isEmpty() && input[i] > input[stack.peek()]) {
					poped = stack.pop();
					if (!stack.isEmpty())
						waterTrapped += (Math.min(input[i], input[stack.peek()]) - input[poped])
								* (i - 1 - stack.peek()); //area of rectangle
				}
				stack.push(i);
			}

		}
		return waterTrapped;
	}

	public static void main(String[] args) {
		RainWaterTrap water = new RainWaterTrap();
		int[] input = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int[] input2 = { 4, 0, 2, 4, 3, 4, 2, 0, 4 };
		System.out.println("Solution-1: Water traped : " + water.waterTrapSolution1(input));
		System.out.println("Solution-1: Water traped : " + water.waterTrapSolution1(input2));
		System.out.println("Solution-2: Water traped : " + water.waterTrapSolution2(input));
		System.out.println("Solution-2: Water traped : " + water.waterTrapSolution2(input2));
	}

}
