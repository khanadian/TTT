package GameFiles;

import java.util.ArrayList;

public class StrategyImpossible extends Strategy{

	public StrategyImpossible(TTT_Bot bot) {
		super(bot);
	}

	@Override
	public int makeMove()
	{
		int bestCounter = bot.getBestCounter();
		int player = bot.getBotTurn();
		Tile[] best = bot.getBestCombo(player);
		System.out.println("can I win?");
		if(bestCounter >= 2)
		{
			System.out.println("in it to win it");
			winOrBlock(player);
		}
		int counter = bestCounter; // temporary storage of best counter and combos for bot
		Tile[] actBest = best;
		// block opponent
		
		System.out.println("can I block?");
		
		super.update(player^3);
		best = bot.getBestCombo(player^3);
		bestCounter = bot.getBestCounter();
		System.out.println(bestCounter);
		if (bestCounter >= 2) 
		{
			System.out.println("reached");
			for(int i = 0; i < 3; i++) // replace with winOrBlock()
			{
				if (best[i].getSymbText().equals(bot.getSymbol(player^3)) == false)
					return best[i].getID();
			}
		}
		
		System.out.println("can I build?");
		
		if(counter >= 1)
		{
			Tile highPriority = new Tile(0); // must have priority of -1
			System.out.println("hm");
			
			for(int i = 0; i < 3; i++)
			{
				System.out.println(i);
				System.out.println(actBest[i]);
				if (actBest[i].getSymbText().equals(bot.getSymbol(player)) == false && highPriority.getPriority() < actBest[i].getPriority())
				{
					highPriority = actBest[i];
				}
			}
			return highPriority.getID();
		}
		
		System.out.println("prioritize");
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
