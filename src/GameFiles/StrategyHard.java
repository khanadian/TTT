package GameFiles;


public class StrategyHard extends Strategy implements StratInterface
{
	
	public StrategyHard(TTT_Bot bot) 
	{
		super(bot);
	}

	@Override
	public int makeMove()
	{
		int bestCounter = bot.getBestCounter();
		int player = bot.getBotTurn();
		
		if(bestCounter >= 2)
			return win(player);
		
		super.update(player^3);
		best = bot.getBestCombo(player^3);
		bestCounter = bot.getBestCounter();
		if (bestCounter >= 2) 
			return block(player^3);
		
		return pickSmart();
		
	}
	
}
