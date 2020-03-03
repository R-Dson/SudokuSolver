package Sudoku;

public class Start {
	
	public static void main(String[] args) {
		Sudoku s = new Sudoku();
		Solver.solve(s);
		GuiBuilder gb = new GuiBuilder();
		
		System.out.println(Solver.checkSquare(s.getMatrix(), 9, 3, 3));
	}

}
