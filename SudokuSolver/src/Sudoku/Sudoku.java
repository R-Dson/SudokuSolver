package Sudoku;

import java.util.Arrays;

public class Sudoku {
	int[][] matrix = new int[9][9];
	
	/**
	 * Comment
	 */
	public Sudoku() {
		for(int[] a : matrix) {
			Arrays.fill(a, -1);
		}
	}
	
	/**
	 * Returns the value of x, y
	 */
	public int getValuexy (int x, int y){
		return matrix[x][y];
	}
	
	/**
	 * Returns true if value was added to matrix, else false
	 */
	public boolean setValuexy (int val, int x, int y){
		if(matrix[x][y] == -1) {
			matrix[x][y] = val;
			return true;
		}
		return false;
	}
}
