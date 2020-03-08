package Sudoku;

public class Solver {
	
	/**
	 * Lösningen av sudokut
	 * @param s
	 * @return
	 */
	public boolean solve(Sudoku s) {
		// går igenom hela från 0 till 9
		boolean firsttest = true;
		for (int i = 1; i <= 9; i++) {
			for (int row = 0; row < 9; row++) {
				for (int col = 0; col < 9; col++) {
					if (s.checkAll(i, col, row) && firsttest) {
						firsttest = true;
					} else {
						firsttest = false;
					}
				}
			}
		}

		if (firsttest) {
			return solveRec(s, 0, 0);
		} else {
			System.out.println("saknas lösning");
			return false;
		}

	}
	
	/**
	 * vår Rekursiv algoritm
	 * @param s
	 * @param row
	 * @param col
	 * @return
	 */
	private boolean solveRec(Sudoku s, int row, int col) {
		int staticrow = row;
		int staticcol = col;
		
		if (s.getValuexy(row, col) == -1) {
			for (int value = 1; value <= 9; value++) {
				
				s.setValuexy(row, col, value);
				
				if (s.checkAll(value, col, row)) {
					
					if (row == 8 && col == 8) {
						return true;
					}

					if (col == 8) {
						col = -1;
						row++;
					}
					
					col++;
					
					if(solveRec(s, row, col)) {
						return true;
					}else {
						s.resetValuexy(staticrow, staticcol);
						row = staticrow;
						col = staticcol;
					}
				}
				s.resetValuexy(staticrow, staticcol);

			}
			return false;
		}else {
			
			if (row == 8 && col == 8) {
				return true;
			}

			if (col == 8) {
				if (row < 8) {
					col = -1;
					row++;
				}
			}
			col++;
			if(solveRec(s, row, col)) {
				return true;
			}else {
				row = staticrow;
				col = staticcol;
			}
		}

		return false;
	}
}
