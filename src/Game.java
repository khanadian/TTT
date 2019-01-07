import java.util.ArrayList;
import java.util.Scanner;

public class Game 
{
	private Tile[] tileList = new Tile[10];
	private ArrayList<Tile[]> winningCombos1; // used to check for win states for player 1
	private ArrayList<Tile[]> winningCombos2; // used to check for win states for player 2
	Scanner sc = new Scanner(System.in);
	private int playerTurn; // indicates which player is playing
	private boolean play;
	
	public static void main(String[] args) 
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() { // this is to follow active program protocols
			public void run() 
			{
				new Game();
			}});
	}
	
	private Game()
	{
		//setting up
		for(int i = 1; i < 10; i++)
		{
			tileList[i] = new Tile();
		}
		play = true;
		
		while(play)
		{
			//starting new game
			setupList(winningCombos1);
			setupList(winningCombos2);
			playerTurn = 1;
			
		}
		
		
		
		
	}
	
	/*
	 * sets up the winning combos for a player
	 * input: list of winning combinations
	 */
	private void setupList(ArrayList<Tile[]> combos)
	{
		
		combos = new ArrayList<Tile[]>();
		combos.add(new Tile[] {tileList[1], tileList[2], tileList[3]});
		combos.add(new Tile[] {tileList[4], tileList[5], tileList[6]});
		combos.add(new Tile[] {tileList[7], tileList[8], tileList[9]});
		combos.add(new Tile[] {tileList[1], tileList[4], tileList[7]});
		combos.add(new Tile[] {tileList[2], tileList[5], tileList[8]});
		combos.add(new Tile[] {tileList[3], tileList[6], tileList[9]});
		combos.add(new Tile[] {tileList[1], tileList[5], tileList[9]});
		combos.add(new Tile[] {tileList[3], tileList[5], tileList[7]});
		
		
		System.out.println("hi");
	}
	
}

