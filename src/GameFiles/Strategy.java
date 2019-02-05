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
		System.out.println(bestCounter);
	}
	
	public int makeMove()
	{
		return 0;
	}
	
	// will act upon a row of 2
	public int winOrBlock(int p)
	{
		for(int i = 0; i < 3; i++)
		{
			System.out.println(best[i]);
			if (best[i].getSymbText().equals(bot.getSymbol(p)) == false)
				return best[i].getID();
		}
		
		return 0;
	}
	
	
	
	
	
}
