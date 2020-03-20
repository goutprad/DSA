package com.dsa.stringmatching;

public class StringSearch {
	/**
	 * simpleTextSearch
	 * 
	 * @param input
	 * @param pattern
	 * 
	 *                Time Complexity - O(m(n-m + 1))
	 */
	public int simpleTextSearch(String input, String pattern) {
		int textSize = input.length();
		int patternSize = pattern.length();

		int i = 0;
		while (i + patternSize <= textSize) {
			int j = 0;
			while (input.charAt(i + j) == pattern.charAt(j)) {
				j += 1;
				if (j >= patternSize) {
					return i;
				}
			}
			i += 1;
		}
		return -1;
	}

	public int textSearch(String text, String pattern) {
		int textLength = text.length();
		int patternLengh = pattern.length();
		for (int i = 0; i <= textLength - patternLengh; i++) {
			int j;
			for (j = 0; j < patternLengh; j++) {
				if (text.charAt(i + j) != pattern.charAt(j)) {
					break;
				}
			}
			if (j == patternLengh) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		StringSearch search = new StringSearch();
		String input = "THIS IS A TEST TEXTZ";
		String pattern = "Z";
		System.out.println(search.simpleTextSearch(input, pattern)); // -1 : Not Found otherwise will print first index
																		// of
																		// text matched
		System.out.println(search.textSearch(input, pattern));
	}
}
