package com.dsa.practice.leetcode.easy;

/**
 * 1281. Subtract the Product and Sum of Digits of an Integer
 * https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 * 
 * Input: n = 234
 * Output: 15 
 * Explanation: 
 * Product of digits = 2 * 3 * 4 = 24 
 * Sum of digits = 2 + 3 + 4 = 9 
 * Result = 24 - 9 = 15
 * 
 * @author Goutam
 *
 */
public class SubtractProductAndSum {
	public int subtractProductAndSum(int n) {
		int sum = 0;
		int product = 1;
		while (n > 0) {
			sum = sum + n % 10;
			product = product * (n % 10);
			n = n / 10;
		}
		return product - sum;
	}

	public static void main(String[] args) {
		SubtractProductAndSum leetMath = new SubtractProductAndSum();
		int input = 234;
		System.out.println(leetMath.subtractProductAndSum(input));
	}
}
