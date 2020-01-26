package com.dsa.practice.leetcode.hard;

import java.util.HashMap;
import java.util.Stack;

/**
 * 895. Maximum Frequency Stack 
 * 1. push(int x), which pushes an integer x onto the stack. 
 * 2. pop(), which removes and returns the most frequent element in the stack. 
 * 		- If there is a tie for most frequent element, the element closest
 *        to the top of the stack is removed and returned.
 * 
 * https://leetcode.com/problems/maximum-frequency-stack/
 * 
 * @author Goutam
 *
 */
public class MaximumFrequencyStack {
	private HashMap<Integer, Integer> freq;
	private HashMap<Integer, Stack<Integer>> bucketStack;
	int maxfreq;
	
	/**
	 * Initialize MaximumFrequencyStack
	 */
	public MaximumFrequencyStack() {
		freq = new HashMap<Integer, Integer>();
		bucketStack = new HashMap<Integer, Stack<Integer>>();
		maxfreq = 0;
	}

	/**
	 * push() - insert to stack
	 * 
	 * @param item
	 */
	public void push(int item) {
		if (freq.containsKey(item)) {
			freq.put(item, freq.get(item) + 1);
		} else {
			freq.put(item, 1);
		}
		int count = freq.get(item);
		if (bucketStack.isEmpty() || !bucketStack.containsKey(count)) {

			bucketStack.put(count, new Stack<Integer>());
		}
		bucketStack.get(count).add(item);
		maxfreq = Math.max(count, maxfreq);
	}

	/**
	 * pop() - It will pop out the maximum frequency item
	 * 
	 * @return
	 */
	public Object pop() {
		int result = Integer.MIN_VALUE;
		if (bucketStack.containsKey(maxfreq)) {
			result = bucketStack.get(maxfreq).pop();
			freq.put(result, maxfreq - 1);
			if (bucketStack.get(maxfreq).empty()) {
				maxfreq--;
			}
		} else {
			return "Stack Is empty!!";
		}
		return result;
	}

	public static void main(String[] args) {
		MaximumFrequencyStack maxfreq = new MaximumFrequencyStack();
		maxfreq.push(5);
		maxfreq.push(7);
		maxfreq.push(5);
		maxfreq.push(7);
		maxfreq.push(4);
		maxfreq.push(5);
		System.out.println("Max frequency item: " + maxfreq.pop());
		System.out.println("Max frequency item: " + maxfreq.pop());
		System.out.println("Max frequency item: " + maxfreq.pop());
		System.out.println("Max frequency item: " + maxfreq.pop());
		System.out.println("Max frequency item: " + maxfreq.pop());
		System.out.println("Max frequency item: " + maxfreq.pop());
		System.out.println("Max frequency item: " + maxfreq.pop());
	}

}
