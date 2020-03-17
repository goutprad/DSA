package com.dsa.divideandconquer;

/**
 * We are given string s1 and s2. we need to convert s2 into s1 by deleting,
 * inserting or replacing characters. write a function to calculte the count of
 * minimum number of edits operations
 * 
 * @author Goutam
 *
 */
public class FindMinimumOperations {

	public int findMinimumOperations(String s1, String s2, int i1, int i2) {
		if (s1.length() == i1) { // if we have reached the end of s1, so rest of the character of s2 to be
									// deleted
			return s2.length() - i2;
		}
		if (s2.length() == i2) { // if we have reached the end of s2, so rest of the character of s1 to be
									// deleted
			return s1.length() - i1;
		}
		if (s1.charAt(i1) == s2.charAt(i2)) {
			return findMinimumOperations(s1, s2, i1 + 1, i2 + 1);
		}
		int c1 = 1 + findMinimumOperations(s1, s2, i1 + 1, i2); // insert
		int c2 = 1 + findMinimumOperations(s1, s2, i1, i2 + 1); // deletion
		int c3 = 1 + findMinimumOperations(s1, s2, i1 + 1, i2 + 1); // replacement
		int minc = Math.min(c1, c2);
		return Math.min(c3, minc);
	}

	public static void main(String[] args) {
		FindMinimumOperations dq = new FindMinimumOperations();
		String s1 = "table";
		String s2 = "tcblekl";
		System.out.println(dq.findMinimumOperations(s1, s2, 0, 0));
	}

}
