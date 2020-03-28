package com.dsa.stringmatching;

public class RabinKarpAlgorithm {
	int q = 101;
	int d = 256;

	public void search(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		int i, j;
		int p = 0;
		int t = 0;
		int h = 1;

//		for (i = 0; i < M - 1; i++) {
//			System.out.println("h->" + h);
//			h = (h * d) % q;
//		}

		h = (int) (Math.pow(d, m - 1) % q);
		//System.out.println("h-->"+h);
		for (i = 0; i < m; i++) {
			p = (d * p + pattern.charAt(i)) % q;
			t = (d * t + text.charAt(i)) % q;
			System.out.println("p-->" + p+"  t->"+t);
		}

		for (i = 0; i <= n - m; i++) {
			if (p == t) {
				for (j = 0; j < m; j++) {
					if (text.charAt(i + j) != pattern.charAt(j))
						break;
				}
				if (j == m) {
					System.out.println("Pattern found at index " + i);
				}
			}
			if (i < n - m) {
				t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
				System.out.println("t->"+t);
				if (t < 0)
					t = (t + q);
				System.out.println("p-->" + p+"  t->"+t);
			}
		}
	}

	public static void main(String[] args) {
		RabinKarpAlgorithm rabinkarp = new RabinKarpAlgorithm();
		String text = "AABAACAADAABAABA";
		String pattern = "AABA";
		rabinkarp.search(text, pattern);
	}

}
