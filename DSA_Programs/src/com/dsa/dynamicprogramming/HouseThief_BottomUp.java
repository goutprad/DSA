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
public class HouseThief_BottomUp {
	
	public int maxMoney(int[] houseNetWorth) {
		int[] dp = new int[houseNetWorth.length + 2];
		for (int i = houseNetWorth.length - 1; i >= 0; i--) {
			dp[i] = Math.max(houseNetWorth[i] + dp[i + 2], dp[i + 1]);
		}
		return dp[0];
	}

	public static void main(String[] args) {
		HouseThief_BottomUp dpBottomUp = new HouseThief_BottomUp();
		int[] input = { 6, 7, 1, 30, 8, 2, 4 };
		System.out.println(dpBottomUp.maxMoney(input));
	}
}
