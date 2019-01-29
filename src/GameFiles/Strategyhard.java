package GameFiles;

import java.util.ArrayList;

public class Strategyhard extends Strategy{

	public Strategyhard(TTT_Bot bot) {
		super(bot);
	}

	@Override
	public int makeMove()
	{
		int bestCounter = bot.getBestCounter();
		int player = bot.getBotTurn();
		Tile[] best = bot.getBestCombo(player);
		
		// combine these 2 ifs
		if(bestCounter >= 2)
		{
			
			for(int i = 0; i < 3; i++)
			{
				if (best[i].getSymbText().equals(bot.getSymbol(player)) == false)
					return best[i].getID();
			}
		}
		
		best = bot.getBestCombo(player^3);
		if (bestCounter >= 2) 
		{
			for (int i = 0; i < 3; i++) 
			{
				if (best[i].getSymbText().equals(bot.getSymbol(player^3)) == false)
					return best[i].getID();
			}
		}
		
		
		if(freeTiles.contains(Tile.CENTER))
		{
			return Tile.CENTER;
		}
		for (int i = 0; i < 4; i++)
		{
			if(freeTiles.contains(Tile.CORNERS[i]))
			{
				return Tile.CORNERS[i];
			}
		}
		
		for (int i = 0; i < 4; i++)
		{
			if(freeTiles.contains(Tile.SIDES[i]))
			{
				return Tile.SIDES[i];
			}
		}
		
		return 0;
	}
	
}
