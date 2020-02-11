package com.dsa.puzzles;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Pair class to strore start time and finish time
 * 
 * @author Goutam
 *
 */
class Pair {
	private int start, finish;

	public Pair(int start, int finish) {
		this.start = start;
		this.finish = finish;
	}

	public int getStart() {
		return start;
	}

	public int getFinish() {
		return finish;
	}

	public String toString() {
		return "{" + getStart() + "," + getFinish() + "}";
	}
}

/**
 * ActivitySelectionUsingSet
 * 
 * @author Goutam
 *
 */
public class ActivitySelectionUsingSet {
	/**
	 * selectMaximumActivities
	 * 
	 * @param activities
	 * @return
	 */
	public Set<Integer> selectMaximumActivities(List<Pair> activities) {
		int i = 0;
		Set<Integer> result = new HashSet<Integer>(); // to avoid any conflict activity
		result.add(i); // choose first activity always
		for (int j = 1; j < activities.size(); j++) {
			if (activities.get(j).getStart() >= activities.get(i).getFinish()) {
				result.add(j);
				i = j;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ActivitySelectionUsingSet selActivity = new ActivitySelectionUsingSet();
		List<Pair> activities = Arrays.asList(new Pair(1, 4), new Pair(3, 5), new Pair(0, 6), new Pair(5, 7),
				new Pair(3, 8), new Pair(5, 9), new Pair(6, 10), new Pair(8, 11), new Pair(8, 12), new Pair(2, 13),
				new Pair(12, 14));
		// Thissort is to just confirm we have choose lower start point of
		// activity(optional)
		// Collections.sort(activities, (a,b)->a.getFinish()-b.getFinish());
		Set<Integer> result = selActivity.selectMaximumActivities(activities);
		for (Integer i : result) {
			System.out.println(activities.get(i));
		}
	}

}
