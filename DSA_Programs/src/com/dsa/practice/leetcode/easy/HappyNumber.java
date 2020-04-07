package com.dsa.practice.leetcode.easy;

/**
 * https://leetcode.com/problems/happy-number/
 * 
 * @author Goutam
 *
 */
public class HappyNumber {
	public boolean isHappy(int n) {
		if (n == 1 || n == 7) {
			return true;
		}
		if (n < 1 || n < 10)
			return false;

		return isHappy(sumAndSquare(n)) == true;
	}

	public int sumAndSquare(int n) {
		int sum = 0;
		while (n > 0) {
			int num = n % 10;
			sum += (num * num);
			n = n / 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		HappyNumber leetCode = new HappyNumber();
		System.out.println(leetCode.isHappy(2));
	}
}
