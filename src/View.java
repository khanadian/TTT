import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
  

public class View extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;  // just in case
	private JLabel instructions;
	private TTT_Model model;
	JButton[] tile = new JButton[10];
	
	// different panels for different parts of the screen
	
	
	public View(TTT_Model m)
	{
		model = m;
		setUI();
	}
	private void setUI()
	{
		JFrame frame = new JFrame("Tic Tac Toe");
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel jPan = new JPanel(new GridLayout(3,3));
		
		instructions = new JLabel(model.getSymbol(1), SwingConstants.CENTER);
		
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
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		JButton button = (JButton) e.getSource();
		button.setEnabled(false);
		int turn = model.getPlayerTurn();
		// make the move and check if it is over
		ArrayList<Tile[]> win = model.makeMove(Integer.parseInt(button.getText()));
		button.setText(model.getSymbol(turn));
		
		if (model.checkEnd(win) == 0) 
		{
			instructions.setText(model.getSymbol(model.getPlayerTurn()));
		}
		else
		{
			for(int i = 1; i < 10; i++)
			{
				tile[i].setEnabled(false);
			}
			
			if (model.checkEnd(win) == 1)
			{
				instructions.setText(model.getPlayerTurn() + " wins!");
			}
			else if (model.checkEnd(win) == 2)
			{
				instructions.setText("Draw!");
			}
			
		}
	}
}
