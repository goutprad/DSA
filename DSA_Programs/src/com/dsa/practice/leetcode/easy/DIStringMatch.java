package com.dsa.practice.leetcode.easy;

import java.util.Arrays;
/**
 * 942. DI String Match
 * https://leetcode.com/problems/di-string-match/
 * 
 * @author Goutam
 *
 */
public class DIStringMatch {
	public int[] diStringMatch(String S) {
		int output[] = new int[S.length() + 1];
		int increase = 0;
		int decrease = S.length();
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == 'I') {
				output[i] = increase++;
			} else {
				output[i] = decrease--;
			}
		}
		output[S.length()] = decrease;
		return output;
	}

	public static void main(String[] args) {
		DIStringMatch leet = new DIStringMatch();
		String S = "III"; // [0,1,2,3]
		String S1 = "IDID"; // [0,4,1,3,2]
		String S2 = "DDI"; // [3,2,0,1]
		int[] result = leet.diStringMatch(S1);
		System.out.println(Arrays.toString(result));
	}
}
