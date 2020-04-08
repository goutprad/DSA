package com.dsa.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Goutam
 *
 */
public class FunWithAnagram {

	public static List<String> funWithAnagrams(List<String> s) {
		Set<String> st = new HashSet<String>();
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < s.size(); i++) {
			char[] word = s.get(i).toCharArray();
			Arrays.sort(word);
			String newWord = new String(word);
			if (!st.contains(newWord)) {
				st.add(newWord);
				result.add(s.get(i));
			}
		}
		Collections.sort(result);
		return result;
	}

	public static void main(String[] args) {
		FunWithAnagram anagram = new FunWithAnagram();
		List<String> s = new ArrayList<String>();
		s.add("code");
		s.add("doce");
		s.add("ecod");
		s.add("framer");
		s.add("frame");
		List<String> output = anagram.funWithAnagrams(s);
		System.out.println(output);
	}

}
