package Sudoku;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SudokuTest {
	private Sudoku s = new Sudoku();
		
	@Test
	void solveEmpty() {
		Solver solver = new Solver();
		assertTrue(solver.solve(s));
	}
	
	@Test
	void solveSudokuFig1() {
		Solver solver = new Solver();
		s.setValuexy(0, 2, 8);
		s.setValuexy(0, 5, 9);
		s.setValuexy(0, 7, 6);
		s.setValuexy(0, 8, 2);
		s.setValuexy(1, 8, 5);
		s.setValuexy(2, 0, 1);
		s.setValuexy(2, 2, 2);
		s.setValuexy(2, 3, 5);
		s.setValuexy(3, 3, 2);
		s.setValuexy(3, 4, 1);
		s.setValuexy(3, 7, 9);
		s.setValuexy(4, 1, 5);
		s.setValuexy(4, 6, 6);
		s.setValuexy(5, 0, 6);
		s.setValuexy(5, 7, 2);
		s.setValuexy(5, 8, 8);
		s.setValuexy(6, 0, 4);
		s.setValuexy(6, 1, 1);
		s.setValuexy(6, 3, 6);
		s.setValuexy(6, 5, 8);
		s.setValuexy(7, 0, 8);
		s.setValuexy(7, 1, 6);
		s.setValuexy(7, 4, 3);
		s.setValuexy(7, 6, 1);
		s.setValuexy(8, 6, 4);
		solver.solve(s);
		s.print();
	}
	
	@Test 
	void solveNonSolveable() {
		Solver solver = new Solver();
		s.setValuexy(4, 4, 1);
		s.setValuexy(5, 5, 1);
		assertFalse(solver.solve(s));
	}

}
