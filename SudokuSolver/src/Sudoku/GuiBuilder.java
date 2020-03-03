package Sudoku;

import java.awt.GridLayout;
import javax.swing.*;

public class GuiBuilder {
	public GuiBuilder() {
		
		//fixar Jframe, rutan som kommer upp
		JFrame frame = new JFrame("Sudoku Solver");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		
		//skapar grid
		JPanel sudPanel = new JPanel ();
		sudPanel.setLayout(new GridLayout (9,9));
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				JTextField temp = new JTextField();
				temp.setHorizontalAlignment(JTextField.CENTER);
				sudPanel.add(temp);
			}
		}
		frame.getContentPane().add(sudPanel);
		
		JButton bsolve = new JButton("Solve");
		
		frame.getContentPane().add(bsolve);
		frame.getContentPane().add(sudPanel);
		
		bsolve.addActionListener(e -> Solver.createSudoku(sudPanel));
		
		//gör den synlig efter den är byggd
		frame.setVisible(true);
	}
}
