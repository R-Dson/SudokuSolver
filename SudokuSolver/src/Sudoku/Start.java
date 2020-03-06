package Sudoku;

public class Start {

	public static void main(String[] args) {
		Sudoku s = new Sudoku();

		Solver.solve(s);
    //bygger gui innan vi löser det
		GuiBuilder gb = new GuiBuilder();
		
		if(Solver.solve(s)) {
			s.print();
		}
    
	}

}
