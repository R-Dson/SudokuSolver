package Sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class GuiBuilder {
	
	private Sudoku s;
	
	/**
	 * skapar guin
	 */
	public GuiBuilder() {
		
		s = new Sudoku();
		
		//fixar Jframe, rutan som kommer upp
		JFrame frame = new JFrame("Sudoku Solver");		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setSize(400, 400);
		frame.setBackground(new Color(249, 249, 249));
		
		//skapar rutan där allt sparas
		Container pane = frame.getContentPane();
		
		//skapar grid
		JPanel sudPanel = new JPanel();
		
		sudPanel.setLayout(new GridLayout (9,9));
		sudPanel.setPreferredSize(new Dimension(400,400));
		
		int c = 0;
		for(int i = 0; i < 9; i++) {
			c++;
			if(c % 8 == 0)
				c = 0;
			
			if(c < 4 || c > 6) {
				for(int j = 0; j < 3; j++) {
					red(sudPanel);
				}
				for(int j = 0; j < 3; j++) {
					white(sudPanel);
				}
				for(int j = 0; j < 3; j++) {
					red(sudPanel);
				}
			}
			else {
				for(int j = 0; j < 3; j++) {
					white(sudPanel);
				}
				for(int j = 0; j < 3; j++) {
					red(sudPanel);
				}
				for(int j = 0; j < 3; j++) {
					white(sudPanel);
				}
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
		
		frame.pack();
		//gör den synlig efter den är byggd
		frame.setVisible(true);
	}
	
	/**
	 * skapar en röd textruta
	 * @param sudPanel
	 */
	private void red(JPanel sudPanel) {
		JTextField temp = new JTextField();
		temp.setHorizontalAlignment(JTextField.CENTER);
		sudPanel.add(temp);
		temp.setBackground(new Color(245, 129, 129));
	}
	
	/**
	 * skapar en vit textruta
	 * @param sudPanel
	 */
	private void white(JPanel sudPanel) {
		JTextField temp = new JTextField();
		temp.setHorizontalAlignment(JTextField.CENTER);
		temp.setBackground(new Color(249, 249, 249));
		sudPanel.add(temp);
	}
}
