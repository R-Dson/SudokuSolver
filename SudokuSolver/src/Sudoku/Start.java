package Sudoku;

public class Start {

	public static void main(String[] args) {
		Sudoku s = new Sudoku();
		if(Solver.solve(s)) {
			s.print();
		}

		GuiBuilder gb = new GuiBuilder(s);
	}

}
