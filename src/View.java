import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;

  

public class View extends JFrame implements ActionListener {

	//private static final long serialVersionUID = 1L;  // just in case
	
	private Game game;
	
	// different panels for different parts of the screen
	
	
	public View(Game g)
	{
		game = g;
		setUI();
	}
	private void setUI()
	{
		JFrame frame = new JFrame("Tic Tac Toe");
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel jPan = new JPanel(new GridLayout(3,3));
		
		JLabel instructions = new JLabel(game.getSymbol(1), SwingConstants.CENTER);
		
		JButton[] tile = new JButton[10];
		for(int i = 1; i < 10; i++)
		{
			tile[i]= new JButton(Integer.toString(i));
			tile[i].addActionListener(this);
			tile[i].setPreferredSize(new Dimension(100, 100));
			jPan.add(tile[i]);
		}
		
		
		frame.add(jPan, BorderLayout.CENTER);
		frame.add(instructions, BorderLayout.NORTH);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		
	}
}
