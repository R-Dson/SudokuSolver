package Sudoku;

import javax.swing.JPanel;

public class Solver {
	
	
	public static void solve(Sudoku s) {
		
		//går igenom hela från 0 till 9
		int[][] matrix = s.getMatrix();
		
	}
	
	private static boolean sudRec(int[][] matrix) {
		
		//n mellan 0 och 9
		for(int n = 0; n < 10; n++) {
			//kollar om talet får vara i raden, kolumnen och rutan
			
		}
		
		return false;
	}
	
	public static void createSudoku(JPanel panel) {
		//använd panel till att bygga upp ett Sudoku objekt
	}
	
	/**
	 * 
	 * @param matrix
	 * @param number
	 * @param row
	 * @return
	 */
	public static boolean checkRow(int[][] matrix, int number, int row) {
		for(int i = 0; i < matrix.length; i++) {
			if(matrix[row][i] == number) {
				return true;
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
		for(int i = 0; i < matrix.length; i++) {
			if(matrix[i][col] == number) {
				return true;
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
	public static boolean checkSquare(int[][] matrix, int number, int col, int row) {
		//x är vilken kvadrat vi ska kolla och y är vilken höjd kvadraten är i. Från 0 till 2
		int x = row/3;
		int y = col/3;
		System.out.println(x);
		System.out.println(y);
		for(int i = y * 3; i < 3 *(y+1); i++) {
			for(int j = x * 3; j < 3 * (x+1); j++) {
				if(matrix[j][i] == number) {
					return true;
				}
			}
		}
		
		return false;
	}
}
