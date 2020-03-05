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
		setValuexy(2, 0, 8);
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
		
		setValuexy(6, 8, 4);

		
	}
	

	/**
	 * returnerar värdet i x, y
	 * @param x
	 * @param y
	 * @return
	 */
	public int getValuexy (int x, int y){
		return matrix[y][x];
	}
	
	/**
	 * Returns true if value was added to matrix, else false
	 * @param x
	 * @param y
	 * @param val
	 * @return
	 */
	public boolean setValuexy (int x, int y, int val){
		
		//kollar om rad existerar redan
		boolean row = Solver.checkRow(matrix, val, y);
		//kollar om kolumn existerar redan
		boolean col = Solver.checkColumn(matrix, val, x);
		
		//antar värdet om allt är sant
		if(matrix[y][x] == -1 && val > -1 && row && col) {
			matrix[y][x] = val;
			return true;
		}
		return false;
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
	
}
