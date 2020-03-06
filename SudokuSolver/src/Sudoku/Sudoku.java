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
		
		//remove later
		//x och y är från 0 till 8, värdet är 1 till 9 som sudoku ska vara.
		//saknar lösning
		/*setValuexy(2, 0, 8);
		setValuexy(5, 0, 9);
		setValuexy(7, 0, 6);
		setValuexy(8, 0, 2);
		
		setValuexy(3, 1, 5);
		
		setValuexy(0, 2, 1);
		setValuexy(2, 2, 2);
		setValuexy(3, 2, 5);
		
		setValuexy(3, 3, 2);
		setValuexy(4, 3, 1);
		setValuexy(7, 3, 9);

		setValuexy(1, 4, 5);
		setValuexy(6, 4, 6);
		
		setValuexy(0, 5, 6);
		setValuexy(7, 5, 2);
		setValuexy(8, 5, 8);
		
		setValuexy(0, 6, 4);
		setValuexy(1, 6, 1);
		setValuexy(3, 6, 6);
		setValuexy(5, 6, 8);
		
		setValuexy(0, 7, 8);
		setValuexy(1, 7, 6);
		setValuexy(4, 7, 3);
		setValuexy(6, 7, 1);
		
		setValuexy(6, 8, 4);*/
		
		//setValuexy(0,0,6);
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
		if(checkAll(val, col, row) && val > -1 && val < 10 && col > -1 && col < 10 && row > -1 && row < 10)
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
