package Sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GuiBuilder {
	
	private Sudoku s;
	private JPanel sudPanel;
	private JButton bsolve;
	
	/**
	 * skapar guin
	 */
	public GuiBuilder(Sudoku s) {
		
		this.s = s;
		
		//fixar Jframe, rutan som kommer upp
		JFrame frame = new JFrame("Sudoku Solver");		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setSize(400, 400);
		frame.setBackground(new Color(249, 249, 249));
		
		//skapar rutan där allt sparas
		Container pane = frame.getContentPane();
		
		//skapar grid
		sudPanel = new JPanel();
		
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
		bsolve = new JButton("Solve");
		bottomPanel.add(bsolve, BorderLayout.WEST);
		JButton bclear = new JButton("Clear");
		bottomPanel.add(bclear, BorderLayout.EAST);
		
		pane.add(bottomPanel, BorderLayout.SOUTH);
		
		bclear.addActionListener(e -> this.clearSudoku());
		
		frame.pack();
		//gör den synlig efter den är byggd
		frame.setVisible(true);
	}
	
	public void addActionSolve(ActionListener listener) {
		bsolve.addActionListener(listener);
	}
	
	/**
	* Skapar en röd textruta
	* @param sudPanel
	*/
	private void red(JPanel sudPanel) {
		JTextField temp = new JTextField();
		temp.setHorizontalAlignment(JTextField.CENTER);
		sudPanel.add(temp);
		temp.setBackground(new Color(245, 129, 129));
	}
	
	/**
	* Skapar en vit textruta
	* @param sudPanel
	*/
	private void white(JPanel sudPanel) {
		JTextField temp = new JTextField();
		temp.setHorizontalAlignment(JTextField.CENTER);
		temp.setBackground(new Color(249, 249, 249));
		sudPanel.add(temp);
	}
	
	/**
	* Sätter in det lösta sudokut i gui
	*/
	public void matrixtopanels() {
		int x = 0;
		int y = 0;
		//går igenom var komponent i panelen
		for(Component comp : sudPanel.getComponents()) {
			//kollar om de är JTextField
			if(comp instanceof JTextField) {
				
				JTextField textf = (JTextField)comp;
				//fixar så att de placeras rätt i x och y
				if(x % 9 == 0 && x != 0) {
					y++;
					x = 0;
				}
				if(y % 9 == 0 && y != 0) {
					y = 0;
				}
				//sätter in de i JTextField
				textf.setText(Integer.toString(s.getValuexy(y, x)));

				x++;
			}
		}
		
	}
	
	/**
	 * Tar värdena från gui och plaserar de i sudokut
	 */
	public boolean panelToMatrix() {
		s.resetSudoku();
		int x = 0;
		int y = 0;
	
		boolean test = true;
		//går igenom var komponent i panelen
		for(Component comp : sudPanel.getComponents()) {
			//kollar om de är JTextField
			if(comp instanceof JTextField) {
				
				JTextField textf = (JTextField)comp;
				//fixar så att de placeras rätt i x och y
				if(x % 9 == 0 && x != 0) {
					y++;
					x = 0;
				}
				if(y % 9 == 0 && y != 0) {
					y = 0;
				}

				//-1 som standard då vi inte har ett värde
				int i = -1;
					
				try {
					i = Integer.parseInt(textf.getText());
					if(i > 9 || i < 1 && test) {
						test = false;
					}
				} catch(Exception e) {
					if(!textf.getText().isBlank()) {
						test = false;
					}
				}
				
				s.setValuexy(y, x, i);
				x++;
			}
		}
		
		if(test == false) {
			errorMessage("One or more values are invalid");
			return false;
		}
		return true;
	}
	
	/**
	 * Skriver ut ett felmeddelande i en ny ruta
	 * @param s, meddelandet
	 */
	public void errorMessage(String s) {
		JOptionPane.showMessageDialog(sudPanel, s);
	}
	
	/**
	 * Tar bort alla värden i gui sudokut.
	 * @param sudPanel
	 * @param s
	 */
	public void clearSudoku() {
		for(Component comp : sudPanel.getComponents()) {
			if(comp instanceof JTextField) {
				JTextField textf = (JTextField)comp;
				textf.setText("");
			}
		}
		s.resetSudoku();
	}
	
}
