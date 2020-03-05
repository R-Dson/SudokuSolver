package Sudoku;

import javax.swing.JPanel;

public class Solver {
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public static boolean solve(Sudoku s) {
		
		//går igenom hela från 0 till 9
		int[][] matrix = s.getMatrix();
		
		boolean firsttest = true;
		for (int i = 1; i <= 9; i++) {
			for (int row = 0; row < matrix.length; row++) {
				for (int col = 0; col < matrix.length; col++) {
					if (Solver.checkRow(matrix, i, row) && Solver.checkColumn(matrix, i, col)
							&& Solver.checkSquare(matrix, i, col, row) && firsttest) {
						firsttest = true;
					} else {
						firsttest = false;
					}
				}
			}
		}

		if (firsttest) {
			return solveRec(s);
		} else {
			System.out.println("saknas lösning");
			return false;
		}

		
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	private static boolean solveRec(Sudoku s) {
		int[][] matrix = s.getMatrix();

		for (int row = 0; row < matrix.length; row++) { // för varje rad
			for (int col = 0; col < matrix.length; col++) { // för varje col
				if (matrix[row][col] == -1) { // om värde saknas
					for (int k = 1; k <= 9; k++) { // alla värden 1-9
						matrix[row][col] = k;
						if (checkRow(matrix, k, row) && checkColumn(matrix, k, col) && checkSquare(matrix, k, col, row)) {
							boolean test = solveRec(s);
							if (test) {
								return true;
							}

						}
						matrix[row][col] = -1;
					}
					return false;
				}
			}

		}
		return true;
	}
	
	public static void createSudoku(JPanel panel) {
		//använd panel till att bygga upp ett Sudoku objekt
	}
	
	/**
	 * 
	 * @param coll
	 * @param roww
	 * @param val
	 * @param matrix
	 * @return
	 */

	/**
	 * 
	 * @param matrix
	 * @param number
	 * @param row
	 * @return
	 */
	public static boolean checkRow(int[][] matrix, int number, int row) {
		int occ = 0;
		for(int i = 0; i < matrix.length; i++) {
			if(matrix[row][i] == number) {
				occ++;
				if (occ > 1) {
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
	public static boolean checkColumn(int[][] matrix, int number, int col) {
		int occ = 0;
		for(int i = 0; i < matrix.length; i++) {
			if(matrix[i][col] == number) {
				occ++;
				if (occ > 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Return falskt om numret existerar inom en kvadrat
	 * @param matrix
	 * @param number
	 * @param col
	 * @param row
	 * @return
	 */
	public static boolean checkSquare(int[][] matrix, int number, int col, int row) {
		//x är vilken kvadrat vi ska kolla och y är vilken höjd kvadraten är i. Från 0 till 2
		int x = row/3;
		int y = col/3;
		int occ = 0;
		System.out.println(x);
		System.out.println(y);
		for(int i = y * 3; i < 3 *(y+1); i++) {
			for(int j = x * 3; j < 3 * (x+1); j++) {
				if(matrix[j][i] == number) {
					occ++;
					if (occ > 1) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
}
