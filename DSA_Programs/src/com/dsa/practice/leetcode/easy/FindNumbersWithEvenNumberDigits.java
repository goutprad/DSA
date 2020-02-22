package com.dsa.practice.leetcode.easy;

/**
 * 1295. Find Numbers with Even Number of Digits
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 * 
 * @author Goutam
 *
 */
public class FindNumbersWithEvenNumberDigits {
	public int findNumbers(int[] nums) {
		int result=0;
		for (int i = 0; i < nums.length; i++) {
			//String a = Integer.toString(nums[i]); 
			if(countDigits(nums[i])%2 ==0) {
				result++;
			}
		}
		return result;
	}
	
	/**
	 * method to count no of digit in a number
	 * 
	 * @param number
	 * @return
	 */
	private int countDigits(int number){
        return (int) Math.floor(Math.log10(number) + 1);
    }

	public static void main(String[] args) {
		FindNumbersWithEvenNumberDigits leetcode = new FindNumbersWithEvenNumberDigits();
		int[] nums = { 12, 345, 2, 6, 7896 };
		int result = leetcode.findNumbers(nums);
		System.out.println("even number digit available in array :"+result);
	}

}
