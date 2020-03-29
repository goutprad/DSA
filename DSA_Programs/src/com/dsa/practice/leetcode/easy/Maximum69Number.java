package com.dsa.practice.leetcode.easy;

/**
 * https://leetcode.com/problems/maximum-69-number/
 * 1323. Maximum 69 Number
 * 
 * @author Goutam
 *
 */
public class Maximum69Number {
	public int maximum69Number(int num) {
		int max = num;
		for (int i = 1, n = 1000; i <= 4; i++, n /= 10) {
			if (num / n == 6)
				return (max + 3 * n);
			num %= n;
		}
		return max;
	}

	public int maximum69NumberUsingSB(int num) {
		StringBuilder sb = new StringBuilder();
		sb.append(num);
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) != 9) {
				sb.setCharAt(i, '9');
				break;
			}
		}
		return Integer.parseInt(sb.toString());
	}

	public static void main(String[] args) {
		Maximum69Number leetMath = new Maximum69Number();
		int input = 9669;
		System.out.println(leetMath.maximum69Number(input)); //9969
		System.out.println(leetMath.maximum69NumberUsingSB(input)); //9969
	}
}
