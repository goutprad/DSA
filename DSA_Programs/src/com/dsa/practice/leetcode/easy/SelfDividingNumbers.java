package com.dsa.practice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/self-dividing-numbers/submissions/
 * 728. Self Dividing Numbers
 * 
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * Input: 
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * 
 * @author Goutam
 *
 */
public class SelfDividingNumbers {
	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> result = new ArrayList();
		for (int i = left; i <= right; i++) {
			if (selfDivisible(i))
				result.add(i);
		}
		return result;

	}

	public boolean selfDivisible(int num) {
		int n = num;
		while (n > 0) {
			if (n % 10 == 0) {
				return false;
			}
			if (num % (n % 10) != 0)
				return false;
			n /= 10;
		}
		return true;
	}

	public static void main(String[] args) {
		SelfDividingNumbers leetMath = new SelfDividingNumbers();
		int left = 8;
		int right = 22;
		System.out.println(leetMath.selfDividingNumbers(left, right));
	}
}
