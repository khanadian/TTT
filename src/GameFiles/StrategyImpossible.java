package GameFiles;

import java.util.ArrayList;

public class StrategyImpossible extends Strategy{

	public StrategyImpossible(TTT_Bot bot) {
		super(bot);
	}

	@Override
	public int makeMove()
	{
		super.update(player);
		int bestCounter = bot.getBestCounter();
		int player = bot.getBotTurn();
		Tile[] best = bot.getBestCombo(player);
		
		if(bestCounter >= 2)
		{
			
			return winOrBlock(player);
		}
		int counter = bestCounter; // temporary storage of best counter and combos for bot
		Tile[] actBest = best;
		// block opponent
		
		
		super.update(player^3);
		best = bot.getBestCombo(player^3);
		bestCounter = bot.getBestCounter();
		if (bestCounter >= 2) 
		{
			return winOrBlock(player^3);
		}
		
		
		if(counter >= 1)
		{
			Tile highPriority = new Tile(0); // must have priority of -1
			
			for(int i = 0; i < 3; i++)
			{
				if (actBest[i].getSymbText().equals(bot.getSymbol(player)) == false && highPriority.getPriority() < actBest[i].getPriority())
				{
					highPriority = actBest[i];
				}
			}
			return highPriority.getID();
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
