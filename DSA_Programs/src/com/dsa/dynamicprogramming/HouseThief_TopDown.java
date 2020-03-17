package com.dsa.dynamicprogramming;

/**
 * There are n house build in a line,each of which contains some value it it. A
 * thief can steal the maximal values of these houses. But he can't steal in two
 * adjacent houses.what is the maximum stolen value?
 * 
 * Example 1: Input:{6,7,1,30,8,2,4} output:41 Thief will steal:7,30,4
 * 
 * Example 2: Input:{20,5,1,13,6,11,40} output:73 Thief will steal:20,13,40
 * 
 * @author Goutam
 *
 */
public class HouseThief_TopDown {
	
	public int maxMoney(int[] dp, int[] houseNetWorth, int currentIndex) {
		if (currentIndex >= houseNetWorth.length) {
			return 0;
		}
		if (dp[currentIndex] == 0) {
			int stealCuurentHouse = houseNetWorth[currentIndex] + maxMoney(dp, houseNetWorth, currentIndex + 2);
			int skipCurrentHouse = maxMoney(dp, houseNetWorth, currentIndex + 1);
			dp[currentIndex] = Math.max(stealCuurentHouse, skipCurrentHouse);
		}
		return dp[currentIndex];
	}

	public static void main(String[] args) {
		HouseThief_TopDown dpTopDown = new HouseThief_TopDown();
		int[] input = { 6, 7, 1, 30, 8, 2, 4 };
		int[] dp = new int[input.length];
		System.out.println(dpTopDown.maxMoney(dp, input, 0));
	}
}
