package GameFiles;

import java.util.ArrayList;

public class StrategyMedium extends Strategy{

	public StrategyMedium(TTT_Bot bot) {
		super(bot);
	}

	@Override
	public int makeMove()
	{
		int bestCounter = bot.getBestCounter();
		int player = bot.getBotTurn();
		Tile[] best = bot.getBestCombo(player);
		
		// go for the win
		if(bestCounter >= 1)
		{
			for(int i = 0; i < 3; i++)
			{
				if (best[i].getSymbText().equals(bot.getSymbol(player)) == false)
					return best[i].getID();
			}
		}
			
		// block opponent
		String opponentSymbol = bot.getSymbol(player^3);
		best = bot.getBestCombo(player^3); // best opponent combo
		if(bestCounter >= 2)
		{
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
	
	
	
}
