package com.dsa.general;

/**
 * Pascal Triangle
 * 
 * @author Goutam
 *
 */
public class PascalTriangle {

	public int pascal_recurion(int i, int j) {
		if (j == 0)
			return 1;
		else if (i == j)
			return 1;
		else
			return pascal_recurion(i - 1, j - 1) + pascal_recurion(i - 1, j);
	}

	public void print_pascal(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = n; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print(pascal_recurion(i, j) + " ");
			}
			System.out.println();
		}
	}

	public void pascalUsingMatrix(int n) {
		int[][] auxMat = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = n; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				if (i == j || j == 0) {
					auxMat[i][j] = 1;
				} else {
					auxMat[i][j] = auxMat[i - 1][j - 1] + auxMat[i - 1][j];
				}
				System.out.print(auxMat[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void pascalUsingVariable(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = n; j > i; j--) {
				System.out.print(" ");
			}
			int c=1;
			for (int j = 1; j <= i ; j++) {
				System.out.print(c+" ");
				c=c*(i-j)/j;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		PascalTriangle pascal = new PascalTriangle();
		pascal.print_pascal(4);
		pascal.pascalUsingMatrix(4);
		pascal.pascalUsingVariable(4);
	}
}
