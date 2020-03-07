package Sudoku;

import java.util.Arrays;

public class Sudoku {
	private int[][] matrix = new int[9][9];
	
	/**
	 * Grunden till sudokut
	 */
	public Sudoku() {
		resetSudoku();
		for (int[] a : matrix) {
			Arrays.fill(a, -1);
		}
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
		//kollar 
		if(checkAll(val, col, row) && val > 0 && val < 10 && col > -1 && col < 10 && row > -1 && row < 10)
			matrix[row][col] = val;
		else
			if(val != -1);
				//System.out.println("One or more values are invalid, they will be ignored.");
	}
	
	/**
	 * checkar så att 
	 * @param value
	 * @param col
	 * @param row
	 * @return
	 */
	public boolean checkAll(int value, int col, int row) {
		if(checkRow(value, row) && checkColumn(value, col) && checkSquare(value, col, row)) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * sätter ett värde till -1
	 * @param row
	 * @param col
	 */
	public void resetValuexy(int row, int col) {
		matrix[row][col] = -1;
	}
	
	
	/**
	 * skriver ut matrisen i terminalen
	 */
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
  
	/*
	 * kollar raden
	 */
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
	 * kollar kolumnen
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
	
	public void resetSudoku() {
		for (int[] a : matrix) {
			Arrays.fill(a, -1);
		}
	}
}
