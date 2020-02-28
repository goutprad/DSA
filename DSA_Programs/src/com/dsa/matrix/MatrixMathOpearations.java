package com.dsa.matrix;

import java.util.Arrays;

public class MatrixMathOpearations {

	public void print2D_01(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		System.out.println("\n");
	}

	public void print2D_02(int[][] matrix) {
		System.out.println(Arrays.deepToString(matrix));
		System.out.println("\n");
	}

	public void print2D_03(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				System.out.print(matrix[row][col] + "\t");
			}
			System.out.println();
		}
		System.out.println("\n");
	}

	public void print2D_04(int[][] matrix) {
		for (int[] row : matrix) {
			for (int x : row) {
				System.out.print(x + "\t");
			}
			System.out.println();
		}
		System.out.println("\n");
	}

	public int[][] addTwoMatrix(int[][] first, int[][] second) {
		int[][] sum = new int[first.length][first[0].length];
		for (int i = 0; i < first.length; i++) {
			for (int j = 0; j < first[i].length; j++) {
				sum[i][j] = first[i][j] + second[i][j];
			}
		}
		return sum;
	}
	
	public int[][] substractTwoMatrix(int[][] first, int[][] second) {
		int[][] substract = new int[first.length][first[0].length];
		for (int i = 0; i < first.length; i++) {
			for (int j = 0; j < first[i].length; j++) {
				substract[i][j] = second[i][j] - first[i][j];
			}
		}
		return substract;
	}
	
	public int[][] multiplyTwoMatrix(int[][] first, int[][] second) {
		int[][] multiply = new int[first.length][first[0].length];
		for (int i = 0; i < first.length; i++) {
			for (int j = 0; j < first[i].length; j++) {
				multiply[i][j] = second[i][j] * first[i][j];
			}
		}
		return multiply;
	}

	public static void main(String[] args) {
		MatrixMathOpearations matrixObj = new MatrixMathOpearations();
		int[][] first = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] second = { { 11, 12, 13 }, { 14, 15, 16 }, { 17, 18, 19 } };
		matrixObj.print2D_01(first);
		matrixObj.print2D_02(first);
		matrixObj.print2D_03(first);
		matrixObj.print2D_04(first);

		int[][] sum = matrixObj.addTwoMatrix(first, second);
		matrixObj.print2D_01(sum);
		
		int[][] substract = matrixObj.substractTwoMatrix(first, second);
		matrixObj.print2D_01(substract);
		
		int[][] multiply = matrixObj.multiplyTwoMatrix(first, second);
		matrixObj.print2D_01(multiply);
	}

}
