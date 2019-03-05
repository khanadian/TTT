package GameFiles;

import java.util.ArrayList;

public class gameState {

	private Tile[] tileList;
	private ArrayList<Integer> freeTiles = new ArrayList<Integer>();
	private ArrayList<Tile[]> winningCombos1; // used to check for win states for player 1
	private ArrayList<Tile[]> winningCombos2; // used to check for win states for player 2
	private int score; //indicates how good of a move this is
	private String currSymbol;
	boolean opponent;
	
	public gameState(Tile[] tl, ArrayList<Integer> free, ArrayList<Tile[]> com1, ArrayList<Tile[]> com2, String symb, boolean opp)
	{
		tileList = tl;
		freeTiles = free;
		winningCombos1 = com1;
		winningCombos2 = com2;
		currSymbol = symb;
		opponent = opp;
		
		setScore();
		saveState();
	}
	
	private void saveState()
	{
		//TODO save the state into a text file.
		String title = "";
		for(int i = 0; i < 9; i++)
		{
			title = title + tileList[i].getSymbText();
		}
		title = title+currSymbol;
		
		
	}
	private void setScore()
	{
		
		score = 0;
		if (freeTiles.size() == 1)
		{
			if(winningCombos1.size() == 1)
			{
				score = 10;
			}
		}
		else
		{
			for (int i = 0; i < freeTiles.size(); i++)
			{
				// check to see if state exists
					// if it does, take the score
					// otherwise, make a new state with it
				boolean stateExists = true;
				if (!stateExists)
				{
					//set up new game state
					Tile[] t = tileList;
					t[freeTiles.get(i)].setSymbText(currSymbol);
					
					ArrayList<Integer> ft = freeTiles;
					ft.remove(i);
					
					String symb; 
					if(currSymbol == "O") //cheesy way to do this
						symb = "X";
					else
						symb = "O";
					 
					new gameState(t, ft, winningCombos1, winningCombos2, symb, !opponent);
				}
				
				// now use game state
				
			}
		}	
		
		
		
		
		if(opponent)
		{
			score = -score;
		}
	}
}

/* score: 
 * loss = 0, 
 * draw = 1, 
 * win in 5 moves = n-4 
 * win in 4 moves = n-3
 * win in 3 moves = n-2
 * win in 2 moves = n-1
 * win in 1 move = n
 */