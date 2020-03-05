package Sudoku;

public class Start {
	
	public static void main(String[] args) {
		Sudoku s = new Sudoku();
		Solver.solve(s);
		GuiBuilder gb = new GuiBuilder();
		
		if(Solver.solve(s)) {
			s.print();
		}
	}

}
