package com.dsa.practice.leetcode.easy;

import java.util.HashMap;

/**
 * 1. Two Sum
 * 
 * https://leetcode.com/problems/two-sum/
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * @author Goutam
 *
 */
public class TwoSum {
	//brute force
	public int[] twoSum_bruteForce(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if(nums[i]==(target-nums[j])) {
					return new int[] {i,j};
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> hash=new HashMap<Integer, Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			hash.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int y=target-nums[i];
			if (hash.containsKey(y) && hash.get(y)!=i) {
				return new int[] {i,hash.get(y)};
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	public int[] twoSum_OnePass(int[] nums, int target) {
		HashMap<Integer, Integer> hash=new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int y=target-nums[i];
			if(hash.containsKey(y))
				return new int[] {hash.get(y),i};
			else
				hash.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	

	public static void main(String[] args) {
		TwoSum tsum= new TwoSum();
		int[] input = {2,7,11,15};
		int[] output =tsum.twoSum_bruteForce(input, 9);
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i]+" ");
		}
		System.out.println();
		int[] output1 =tsum.twoSum(input, 9);
		for (int i = 0; i < output1.length; i++) {
			System.out.print(output1[i]+" ");
		}
		System.out.println();
		int[] output2 =tsum.twoSum_OnePass(input, 9);
		for (int i = 0; i < output2.length; i++) {
			System.out.print(output2[i]+" ");
		}
	}

}
