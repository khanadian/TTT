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
		
		if(bestCounter >= 2)
		{
			
			winOrBlock(player);
		}
		
		best = bot.getBestCombo(player^3);
		if (bestCounter >= 2) 
		{
			winOrBlock(player^3);
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
