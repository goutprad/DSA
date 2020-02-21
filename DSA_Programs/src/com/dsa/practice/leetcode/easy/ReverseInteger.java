package com.dsa.practice.leetcode.easy;

/**
 * 
 * @author Goutam
 *
 */
public class ReverseInteger {
	public int reverse(int x) {
		boolean isNegative = false;
		long num = x;
		if (num < 0) {
			isNegative = true;
			num = -num;
		}

		if (num == 0)
			return 0;
		long result = 0;
		while (num > 0) {
			Long digit = num % 10;
			result = result * 10 + digit;
			num = num / 10;
		}

		if (isNegative) {
			result = -result;
		}
		int resultAsInt = (int) result;
		if (resultAsInt != result)
			return 0;
		return resultAsInt;
	}

	public static void main(String[] args) {
		ReverseInteger rev = new ReverseInteger();
		System.out.println(rev.reverse(1534236469));

	}

}
