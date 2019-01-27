package GameFiles;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.WindowEvent;
  

public class View extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;  // just in case
	private TTT_Model model;
	
	private int botExists; // 0 = true
	private TTT_Bot bot;
	private int playerTurn;
	
	private JFrame frame;
	private JLabel instructions;
	JButton[] tile = new JButton[10];
	
	public View(TTT_Model m)
	{
		model = m;
		setUI();
	}
	
	private void restartUI()
	{
		model = new TTT_Model();
		for(int i = 1; i < 10; i++)
		{
			tile[i].setEnabled(true);
			tile[i].setText(Integer.toString(i));
		}
		instructions.setText(model.getSymbol(1));
		
		botExists = JOptionPane.showConfirmDialog(null,"Would you like to play against a bot?", "choose one", JOptionPane.YES_NO_OPTION);
		if (botExists == 0)
		{
			playerTurn = JOptionPane.showConfirmDialog(null,"Would you like to go first?", "choose one", JOptionPane.YES_NO_OPTION) + 1;
			bot = new TTT_Bot(-1, playerTurn ^ 3, model);
			botMove();
		}
	}
	
	
	private void setUI()
	{
		frame = new JFrame("Tic Tac Toe");
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel jPan = new JPanel(new GridLayout(3,3));
		
		for(int i = 1; i < 10; i++)
		{
			tile[i]= new JButton(Integer.toString(i));
			tile[i].addActionListener(this);
			tile[i].setPreferredSize(new Dimension(100, 100));
			jPan.add(tile[i]);
		}
		
		instructions = new JLabel(model.getSymbol(1), SwingConstants.CENTER);
		
		frame.add(jPan, BorderLayout.CENTER);
		frame.add(instructions, BorderLayout.NORTH);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		botExists = JOptionPane.showConfirmDialog(null,"Would you like to play against a bot?", "choose one", JOptionPane.YES_NO_OPTION);
		if (botExists == 0)
		{
			playerTurn = JOptionPane.showConfirmDialog(null,"Would you like to go first?", "choose one", JOptionPane.YES_NO_OPTION) + 1;
			bot = new TTT_Bot(-1, playerTurn ^ 3, model);
			botMove();
		}
	}
	
	private void botMove()
	{
		if (botExists == 0 && model.getPlayerTurn() == bot.getBotTurn())
		{
			tile[bot.makeMove()].doClick();
		}
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
			model.switchPlayer();
			instructions.setText(model.getSymbol(model.getPlayerTurn()));
			
			botMove();
		}
		else
		{
			Tile[] winCombo = model.getWinCombo();
			for(int i = 1; i < 10; i++)
			{
				// TODO : check if tile is part of winning combo
				// if it is, don't disable it
				
				tile[i].setEnabled(false);
			}
			
			if (model.checkEnd(win) == 1)
			{
				if (botExists == 0)
				{
					if (model.getPlayerTurn() == bot.getBotTurn())
					{
						instructions.setText("Bot wins!");
					}
					else
					{
						instructions.setText("Player wins!");
					}
				}
				else
				{
					instructions.setText("Player " + model.getPlayerTurn() + " wins!");
				}
				
			}
			else if (model.checkEnd(win) == 2)
			{
				instructions.setText("Draw!");
			}
			
			int option = JOptionPane.showConfirmDialog(null,"Would you like to play again?", "choose one", JOptionPane.YES_NO_OPTION);
			if (option == 0)
			{
				restartUI();
			}
			else
			{
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		}
	}
}
