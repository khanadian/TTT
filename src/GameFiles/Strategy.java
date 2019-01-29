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
	
	
	
	
}
