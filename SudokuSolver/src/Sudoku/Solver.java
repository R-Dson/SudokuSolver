package Sudoku;

public class Solver {
	
	/**
	 * Lösningen av sudokut
	 * 
	 * @param s
	 * @return
	 */
	public boolean solve(Sudoku s) {
		for (int i = 1; i <= 9; i++) {
			for (int row = 0; row < 9; row++) {
				for (int col = 0; col < 9; col++) {
					// kollar att alla värden som är utplacerade följer reglerna
					if (!s.checkAll(i, col, row)) { // om de inte gör det så avbryts allt och returnerar false
						return false;
					}
				}
			}
		}
		return solveRec(s, 0, 0); // om alla inputs följer reglerna så försöker vi lösa sudokut

	}
  
	/**
	 * vår Rekursiv algoritm
	 * 
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

					if (row == 8 && col == 8) { // om vi gått igenom alla rutor, returnera true
						return true;
					}

					if (col == 8) { // om vi kommit till sista rutan på en rad, börja om med första på nästa rad
						col = -1;
						row++;
					}

					col++;

					if (solveRec(s, row, col)) {// anropar rekursion igen, om det går att lösa, returnera true
						return true;
					} else {
						s.resetValuexy(staticrow, staticcol); // annars återställ värdet som ändrades ovan
						row = staticrow;
						col = staticcol;
					}
				}
				s.resetValuexy(staticrow, staticcol); // återställer värdet om det inte fick placeras på den positionen
														// enligt sudokus regler
			}
			return false;
		} else { // om värdet redan utsatt, fortsätt utan att kolla något

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
			if (solveRec(s, row, col)) {
				return true;
			} else {
				row = staticrow;
				col = staticcol;
			}
		}

		return false; //om det inte ännu returnerat true så går det inte att lösa; returnera false
	}
}
