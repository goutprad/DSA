package com.dsa.practice.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/group-anagrams/
 * 
 * @author Goutam
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams_usingSort(String[] strs) {
		HashMap<String, List<String>> result = new HashMap<String, List<String>>();
		for (int i = 0; i < strs.length; i++) {
			String word = strs[i];
			char[] letters = word.toCharArray();
			Arrays.sort(letters);
			String newword = new String(letters);
			if (result.containsKey(newword)) {
				result.get(newword).add(word);
			} else {
				List<String> words = new ArrayList<String>();
				words.add(word);
				result.put(newword, words);
			}
		}
		return new ArrayList<>(result.values());
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> resultMap = new HashMap<String, List<String>>();
		for (int i = 0; i < strs.length; i++) {
			String k = hash(strs[i]);
			if (!resultMap.containsKey(k)) {
				resultMap.put(k, new ArrayList<>());
			}
			resultMap.get(k).add(strs[i]);
		}
		return new ArrayList<>(resultMap.values());
	}

	private String hash(String st) {
		int[] ch = new int[26];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < st.length(); i++) {
			ch[st.charAt(i) - 'a'] += 1;
		}
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] != 0) {
				sb.append(ch[i]);
				sb.append((char) 'a' + i);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		GroupAnagrams leetCode = new GroupAnagrams();
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> result = leetCode.groupAnagrams(strs);
		System.out.println(result);
	}
}