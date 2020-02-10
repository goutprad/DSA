package com.dsa.practice.leetcode.medium;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 281. Zigzag Iterator https://leetcode.com/problems/zigzag-iterator/
 * 
 * Given two 1d vectors, implement an iterator to return their elements
 * alternately. Example: Input: v1 = [1,2], v2 = [3,4,5,6] Output: [1,3,2,4,5,6]
 * 
 * Explanation: By calling next repeatedly until hasNext returns false, the
 * order of elements returned by next should be: [1,3,2,4,5,6].
 * 
 * @author Goutam
 *
 */
public class ZigZagIterator_01 {
	LinkedList<Iterator<Integer>> queue;

	public ZigZagIterator_01(List<Integer> v1, List<Integer> v2) {
		queue = new LinkedList<Iterator<Integer>>();
		if (!v1.isEmpty()) {
			queue.add(v1.iterator());
		}
		if (!v2.isEmpty()) {
			queue.add(v2.iterator());
		}
	}

	public int next() {
		Iterator<Integer> itr = queue.remove();
		int item = (int) itr.next();
		if (itr.hasNext())
			queue.add(itr);
		return item;

	}

	public boolean hasNext() {
		return !queue.isEmpty();

	}

	public static void main(String[] args) {
		List<Integer> v1 = Arrays.asList(1, 2);
		List<Integer> v2 = Arrays.asList(3, 4, 5, 6);
		ZigZagIterator_01 zigZag = new ZigZagIterator_01(v1, v2);
		while (zigZag.hasNext()) {
			System.out.print(zigZag.next() + " ");
		}
	}

}
