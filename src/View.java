//import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

  

public class View extends JFrame {//implements ActionListener {

	//private static final long serialVersionUID = 1L;  // just in case
	
	private Game game;
	
	// different panels for different parts of the screen
	
	
	public static void main (String[] args)
	{
		JFrame frame = new JFrame("Tic Tac Toe");
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel jPan = new JPanel(new GridLayout(3,3));
		
		
		JLabel instructions = new JLabel("X", SwingConstants.CENTER);
		
		for(int i = 1; i < 10; i++)
		{
			JButton tile = new JButton(Integer.toString(i));
			tile.setPreferredSize(new Dimension(100, 100));
			jPan.add(tile);
		}
		
		
		frame.add(jPan, BorderLayout.CENTER);
		frame.add(instructions, BorderLayout.NORTH);
		
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	
	
}
