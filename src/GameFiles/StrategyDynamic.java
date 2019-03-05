package GameFiles;

public class StrategyDynamic  extends Strategy implements StratInterface{

	public StrategyDynamic(TTT_Bot bot) {
		super(bot);
	}

	
	
	public int makeMove()
	{
		return 0;
	}
	
	/*@Override
	public int makeMove()
	{
		super.update(player);
		int bestCounter = bot.getBestCounter();
		int player = bot.getBotTurn();
		Tile[] best = bot.getBestCombo(player);
		
		if(bestCounter >= 2)
			return win(player);
		
		int counter = bestCounter; // temporary storage of best counter and combos for bot
		Tile[] actBest = best;
		// block opponent
		
		
		super.update(player^3);
		best = bot.getBestCombo(player^3);
		bestCounter = bot.getBestCounter();
		if (bestCounter >= 2) 
			return block(player^3);
		
		
		if(counter >= 1)
		{
			Tile highPriority = new Tile(0); // must have priority of -1
			
			
			for(int i = 0; i < 3; i++)
				if (actBest[i].getSymbText().equals(bot.getSymbol(player)) == false 
						&& highPriority.getPriority() < actBest[i].getPriority())
					highPriority = actBest[i];
			
			return highPriority.getID();
		}
		
		return pickSmart();
		
	}*/
	
}
