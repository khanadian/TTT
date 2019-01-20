import java.util.ArrayList;


// a computer opponent for the game of tic tac toe.
// allows difficulty settings
// can take in the game state and respond accordingly

class TTT_Bot {
	private int player;
	int bestCounter;
	private Game game;
	
	
	int difficulty; //0 = worst, 1 = medium, 2 = best
	
	TTT_Bot(int diff, int player, Game g)
	{
		this.difficulty = diff;
		this.player = player;
		this.game = g;
	}
	
	TTT_Bot(int player, Game g)
	{
		this(0, player, g);
	}
	
	// returns an int representing the tile (not index) that was picked
	public int makeMove()
	{
		int opponent = player ^ 3;
		String symbol = game.getSymbol(player);
		String opponentSymbol = game.getSymbol(opponent);
		Tile[] best = bestCombo(game.getWinningCombos(player), symbol);
		ArrayList<Integer> freeTiles = game.getFreeTiles();
		
		// easy
		if(difficulty == 0)
		{
			// go for the win
			if(bestCounter >= 1)
			{
			System.out.println("going to win");
				for(int i = 0; i < 3; i++)
				{
					System.out.println(best[i].getID());
					if (best[i].getSymbText().equals(symbol) == false)
						return best[i].getID();
				}
			}
			
			// block opponent
			best = bestCombo(game.getWinningCombos(opponent), opponentSymbol);
			if(bestCounter >= 2)
			{
				System.out.println("going to block");
				for(int i = 0; i < 3; i++)
				{
					
					if (best[i].getSymbText().equals(opponentSymbol) == false)
						return best[i].getID();
				}
			}
			
			// pick a random tile
			boolean isFree = false;
			int x = 0;
			Integer y;
			while (isFree == false)
			{
				// worst case,  this runs forever. average case, it'll run a few times.
				x = (int)Math.floor(Math.random() * 10);
				y = new Integer(x);
				if (freeTiles.contains(y))
				{
					isFree = true;
				}
			}
			
			return x; // 1-9
		}
		// medium
		else if(difficulty == 1)
		{
			if(bestCounter >= 2)
			{
				
				for(int i = 0; i < 3; i++)
				{
					if (best[i].getSymbText().equals(symbol) == false)
						return best[i].getID();
				}
			}
			
			best = bestCombo(game.getWinningCombos(opponent), opponentSymbol);
			if (bestCounter >= 2) 
			{
				for (int i = 0; i < 3; i++) 
				{
					if (best[i].getSymbText().equals(opponentSymbol) == false)
						return best[i].getID();
				}
			}
			
			if(game.getFreeTiles().contains(Tile.CENTER))
			{
				return Tile.CENTER;
			}
			for (int i = 0; i < 4; i++)
			{
				if(game.getFreeTiles().contains(Tile.CORNERS[i]))
				{
					return Tile.CORNERS[i];
				}
			}
			
			return 0;
		}
		// hard
		else if(difficulty == 2)
		{
			if(bestCounter >= 2)
			{
				
				for(int i = 0; i < 3; i++)
				{
					if (best[i].getSymbText().equals(symbol) == false)
						return best[i].getID();
				}
			}
			int counter = bestCounter; // temporary storage of best counter and combos for bot
			Tile[] actBest = best;
			// block opponent
			
			best = bestCombo(game.getWinningCombos(opponent), opponentSymbol);
			if (bestCounter >= 2) 
			{
				for (int i = 0; i < 3; i++) 
				{
					if (best[i].getSymbText().equals(opponentSymbol) == false)
						return best[i].getID();
				}
			}
			
			if(counter >= 1)
			{
				Tile highPriority = new Tile(0); // must have priority of -1
				for(int i = 0; i < 3; i++)
				{
					if (actBest[i].getSymbText().equals(symbol) == false && highPriority.getPriority() < actBest[i].getPriority())
					{
						highPriority = actBest[i];
					}
				}
				return highPriority.getID();
			}
			
			if(game.getFreeTiles().contains(Tile.CENTER))
			{
				return Tile.CENTER;
			}
			for (int i = 0; i < 4; i++)
			{
				if(game.getFreeTiles().contains(Tile.CORNERS[i]))
				{
					return Tile.CORNERS[i];
				}
			}
			
			return 0;
		}
		else 
		{
			return 10; // invalid difficulty value
		}
		
	}

// find the best combo
	private Tile[] bestCombo(ArrayList<Tile[]> winningCombos, String symbol)
	{
		if (winningCombos.isEmpty())
		{
			bestCounter = 0;
			return new Tile[] {};
		}
		Tile[] best = winningCombos.get(0);
		bestCounter = 0;
		int symbCounter = 0;
		
		for(Tile[] combo : winningCombos)
		{
			for(int i = 0; i < 3; i ++)
			{
				if (combo[i].getSymbText().equals(symbol))
					symbCounter ++;
			}
			if (symbCounter > bestCounter)
			{
				best = combo;
				bestCounter = symbCounter;
			}
			symbCounter = 0;
		}
		
		return best;
	}
	
	
}

/* DIFFICULTY
	worst:
*  1) go for the win (if you have one down, build upon it)
*  2) block opponent (if they have 2 in a row and a potential win) (THIS CODE IS NEVER EXECUTED)
*  3) put one down in random spot
*
	 medium:
*  1) get the win, if available
*  2) block opponent if they are about to win
*  3) go for high-win tiles (center, then corners, then sides)
*  
	best (hard coded):
*  hard code for each scenario (tiles, turn order, etc)
*
	best (dynamic programming):
*  split each option into possibilities and go for the one with no chance of losing
*/