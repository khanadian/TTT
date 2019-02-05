package GameFiles;

import java.util.ArrayList;

public class Strategy {

	protected ArrayList<Integer> freeTiles;
	protected int bestCounter;
	protected int player;
	protected Tile[] best;
	TTT_Bot bot;
	
	
	public Strategy(TTT_Bot b)
	{
		bot = b;
		player = bot.getBotTurn();
		update(player);
	}
	
	public void update(int p)
	{
		freeTiles = bot.getFrTiles(); 
		best = bot.getBestCombo(p);
		bestCounter = bot.getBestCounter();
	}
	
	public int makeMove()
	{
		return 0;
	}
	
	// will act upon a row of 2
	public int win(int p)
	{
		for(int i = 0; i < 3; i++)
		{
			if (best[i].getSymbText().equals(bot.getSymbol(p)) == false)
				return best[i].getID();
		}
		
		return 0;
	}
	
	// chooses a tile that would have let the opponent win
	public int block(int p)
	{
		return win(p);
	}
	
	
	
}
