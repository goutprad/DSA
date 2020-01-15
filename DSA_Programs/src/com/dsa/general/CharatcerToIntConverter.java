package com.dsa.general;

/**
 * Character to Integer Conversion
 * 
 * "-88297 248252140B12 37" => -88297, "75 6 " => 75, "+349A756" => 349
 * 
 * @author Goutam
 */
public class CharatcerToIntConverter {

	public static void main(String[] args) {
		String input1 = "-88297 248252140B12 37";
		String input2 = "75 6 ";
		String input3 = "+349A756";
		int out = charToIntegerConverter(input3);
		System.out.println(out); //-88297,75,349
	}

	/**
	 * find the Integer from String
	 * 
	 * @param st
	 * @return int
	 */
	static int charToIntegerConverter(String st) {
		boolean isNeg = false;
		int i = 0;
		if (st.charAt(0) == '-') {
			i = 1;
			isNeg = true;
		} else if (st.charAt(0) == '+') {
			i = 1;
			isNeg = false;
		}
		int sum = 0;
		for (i = i; i < st.length(); i++) {
			char ch = st.charAt(i);
			int a = ch - '0';
			if (a > 0 && a <= 9) {
				sum = sum * 10;
				sum = sum + a;
			} else {
				break;
			}
		}
		if (isNeg) {
			return -sum;
		} else {
			return sum;
		}
	}
}
