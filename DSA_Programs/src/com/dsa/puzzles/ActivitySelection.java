package com.dsa.puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Goutam
 *
 */
public class ActivitySelection {

	public List<Integer> selectMaximumActivity(int[] start, int[] finish, int totalActivities) {
		int i = 0;
		List<Integer> result = new ArrayList<Integer>();
		result.add(i);
		for (int j = 1; j < totalActivities; j++) {
			if (start[j] >= finish[i]) {
				result.add(j);
				i = j;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ActivitySelection actSel = new ActivitySelection();
		int[] start = { 1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12 };
		int[] finish = { 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };

		List<Integer> possibleActivity = actSel.selectMaximumActivity(start, finish, start.length);

		for (int i = 0; i < possibleActivity.size(); i++) {
			System.out.print("{" + start[possibleActivity.get(i)] + "," + finish[possibleActivity.get(i)] + "} ");
			// output : {1,4} {5,7} {8,11} {12,14}
		}
	}

}
