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
	
	void update(int p)
	{
		freeTiles = bot.getFrTiles(); 
		best = bot.getBestCombo(p);
		bestCounter = bot.getBestCounter();
	}
	
	//must be overridden by inheriting classes
	public int makeMove()
	{
		return 0;
	}
	
	// will act upon a row of 2
	int win(int p)
	{
		for(int i = 0; i < 3; i++)
			if (best[i].getSymbText().equals(bot.getSymbol(p)) == false)
				return best[i].getID();
		
		return 0;
	}
	
	// chooses a tile that would have let the opponent win
	int block(int p)
	{
		return win(p);
	}
	
	
	// picks a tile randomly
	int pickRandom()
	{
		freeTiles = bot.getFrTiles(); 
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
		
		return x;
	}
	
	//picks a tile based off its win potential (center > corners > sides)
	int pickSmart()
	{
		freeTiles = bot.getFrTiles(); 
		
		if(freeTiles.contains(Tile.CENTER))
			return Tile.CENTER;
		
		for (int i = 0; i < 4; i++)
			if(freeTiles.contains(Tile.CORNERS[i]))
				return Tile.CORNERS[i];
		
		for (int i = 0; i < 4; i++)
			if(freeTiles.contains(Tile.SIDES[i]))
				return Tile.SIDES[i];
		
		// should never run
		return 0;
	}
	
}
