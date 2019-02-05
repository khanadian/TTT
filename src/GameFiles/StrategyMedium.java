package GameFiles;


public class StrategyMedium extends Strategy{

	public StrategyMedium(TTT_Bot bot) {
		super(bot);
	}

	@Override
	public int makeMove()
	{
		int bestCounter = bot.getBestCounter();
		int player = bot.getBotTurn();
		
		// go for the win
		if(bestCounter >= 1)
		{
			return win(player);
		}
			
		// block opponent
		best = bot.getBestCombo(player^3); // best opponent combo
		if(bestCounter >= 2)
		{
			return block(player^3);
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
