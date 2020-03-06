package Sudoku;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Solver {

	public static boolean solve(Sudoku s) {

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
			return solveRec(s);
		} else {
			System.out.println("saknas lösning");
			return false;
		}

	}
          
  private static boolean solveRec(Sudoku s) {
		for (int row = 0; row < 9; row++) { // för varje rad
			for (int col = 0; col < 9; col++) { // för varje col
				if (s.getValuexy(row, col) == -1) { // om värde saknas
					for (int value = 1; value <= 9; value++) { // alla värden 1-9
						s.setValuexy(row, col, value);
						if (s.checkAll(value, col, row)) {
							boolean test = solveRec(s);
							if (test) {
								return true; // ändra här till en metod som kopierar matrisen och sparar den i en lista om man vill spara alla lösningar
							}else {
								// returnera false här för att gå igenom fler alternativ
							}

						}
						s.setValuexy(row, col, -1);
					}
					return false;

				}
			}

		}
  
		return true;
	}

  public static void createSudoku(JPanel panel, Sudoku s) {
	  int x = 0;
	  int y = 0;
		for(Component comp : panel.getComponents()) {
			if(comp instanceof JTextField) {
				
				JTextField textf = (JTextField)comp;
				
				if(x % 9 == 0 && x != 0) {
					y++;
					x = 0;
				}
				if(y % 9 == 0 && y != 0) {
					y = 0;
				}
				//System.out.println(x + " " + y);
				int i = -1;
				
				try {
					i = Integer.parseInt(textf.getText());
				}
				catch(Exception e) {
					if(i != -1)
						System.out.println("One or more values are invalid, they will be ignored.");
				}
				
				s.setValuexy(y, x, i);

				x++;
			}
		}
		
		
		//löser sudokut
		Solver.solve(s);
		s.print();
		
		//skruver ut det i rutorna
		Solver.matrixtopanels(panel, s);
	}
  
	private static void matrixtopanels(JPanel panel, Sudoku s) {
		int x = 0;
		int y = 0;
		for(Component comp : panel.getComponents()) {
			if(comp instanceof JTextField) {
				
				JTextField textf = (JTextField)comp;
				
				if(x % 9 == 0 && x != 0) {
					y++;
					x = 0;
				}
				if(y % 9 == 0 && y != 0) {
					y = 0;
				}
				textf.setText(Integer.toString(s.getMatrix()[x][y]));

				x++;
			}
		}
		
	}

	public static void clearSudoku(JPanel sudPanel) {
		for(Component comp : sudPanel.getComponents()) {
			if(comp instanceof JTextField) {
				JTextField textf = (JTextField)comp;
				textf.setText("");
			}
		}
	}



}
