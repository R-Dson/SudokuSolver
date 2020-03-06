package Sudoku;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.*;

public class GuiBuilder {
	
	public GuiBuilder(Sudoku s) {
		
		//fixar Jframe, rutan som kommer upp
		JFrame frame = new JFrame("Sudoku Solver");		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		
		//skapar rutan där allt sparas
		Container pane = frame.getContentPane();
		
		//skapar grid
		JPanel sudPanel = new JPanel();
		sudPanel.setLayout(new GridLayout (9,9));
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				JTextField temp = new JTextField();
				temp.setHorizontalAlignment(JTextField.CENTER);
				sudPanel.add(temp);
			}
		}
		//lägger till "sudokut" till rutan
		pane.add(sudPanel, BorderLayout.CENTER);

		
		//panelen med knapparna
		JPanel bottomPanel = new JPanel();

		//skapar knapparna + lägger till dem i panelen + lägger till panelen i rutan
		JButton bsolve = new JButton("Solve");
		bottomPanel.add(bsolve, BorderLayout.WEST);
		JButton bclear = new JButton("Clear");
		bottomPanel.add(bclear, BorderLayout.EAST);
		
		pane.add(bottomPanel, BorderLayout.SOUTH);
		
		bsolve.addActionListener(e -> Solver.createSudoku(sudPanel, s));
		bclear.addActionListener(e -> Solver.clearSudoku(sudPanel));
		
		
		//gör den synlig efter den är byggd
		frame.setVisible(true);
	}
}
