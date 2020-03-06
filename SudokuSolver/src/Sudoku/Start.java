package Sudoku;

public class Start {

	public static void main(String[] args) {
		Sudoku s = new Sudoku();

		//bygger gui innan vi löser det
		GuiBuilder gb = new GuiBuilder(s);
		
		//Solver.solve(s);
		
		/*if(Solver.solve(s)) {
			s.print();
		}*/
    
	}

}
