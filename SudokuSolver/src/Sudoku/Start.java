package Sudoku;

public class Start {

	/**
	 * startar programmet
	 * @param args
	 */
	public static void main(String[] args) {
		
		Sudoku s = new Sudoku();
		
		//bygger gui
		GuiBuilder gb = new GuiBuilder(s);
		Solver solver = new Solver();
		
		//lägger till ett event på solve knappen
		gb.addActionSolve(e -> {
			gb.panelToMatrix();
			//solver.solves(s);
			
			//om det är löst skriver vi ut det i gui
			if(solver.solve(s)) {
				//skruver ut det i rutorna
				gb.matrixtopanels();
			}else {
				gb.errorMessage("Sudoku not solvable");
			}
		});
		
	}

}
