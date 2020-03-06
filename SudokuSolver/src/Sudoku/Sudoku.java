package Sudoku;

import java.util.Arrays;

public class Sudoku {
	private int[][] matrix = new int[9][9];
	
	/**
	 * Comment
	 */
	public Sudoku() {
		for(int[] a : matrix) {
			Arrays.fill(a, -1);
		}
		matrix[0][0] = 6;
		matrix[2][2] = 7;
		matrix[2][1] = 2;
	}
	

	/**
	 * returnerar värdet i x, y
	 * @param x
	 * @param y
	 * @return
	 */
	public int getValuexy (int row, int col){
		return matrix[row][col];
	}
	
	/**
	 * Returns true if value was added to matrix, else false
	 * @param x
	 * @param y
	 * @param val
	 * @return
	 */
	public void setValuexy (int row, int col, int val){
			matrix[row][col] = val;
	}
	
	public boolean checkAll(int value, int col, int row) {
		if(checkRow(value, row) && checkColumn(value, col) && checkSquare(value, col, row)) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public int[][] getMatrix(){
		return matrix;
	}
	
	public void print() {
		for(int row = 0; row < matrix.length; row++) {
			for(int col = 0; col < matrix.length; col++) {
				System.out.print(matrix[row][col] + " ");
				if(col == 2 || col == 5) {
					System.out.print(" | ");
				}

			}
			if(row == 2 || row == 5) {
				System.out.println("\n");
				System.out.print("------------------------------");
			}
			System.out.println("\n");
		}
	}
	
	public boolean checkRow(int number, int row) {
		int occ = 0;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[row][i] == number) {
				occ++;
				if (occ >= 2) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param matrix
	 * @param number
	 * @param col
	 * @return
	 */
	public boolean checkColumn(int number, int col) {
		int occ = 0;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][col] == number) {
				occ++;
				if (occ >= 2) {
					return false;

				}
			}
		}
		return true;
	}
	
	/**
	 * Return sant om numret existerar inom en kvadrat
	 * 
	 * @param matrix
	 * @param number
	 * @param col
	 * @param row
	 * @return
	 */
	public boolean checkSquare(int number, int col, int row) {
		// x är vilken kvadrat vi ska kolla och y är vilken höjd kvadraten är i. Från 0
		// till 2
		int occ = 0;
		int x = row / 3;
		int y = col / 3;
		// System.out.println(x);
		// System.out.println(y);
		for (int i = y * 3; i < 3 * (y + 1); i++) {
			for (int j = x * 3; j < 3 * (x + 1); j++) {
				if (matrix[j][i] == number) {
					occ++;
					if (occ == 2) {
						return false;
					}
				}
			}
		}

		return true;
	}
}
