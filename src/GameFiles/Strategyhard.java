package GameFiles;


public class Strategyhard extends Strategy implements StratInterface
{
	
	public Strategyhard(TTT_Bot bot) 
	{
		super(bot);
	}

	@Override
	public int makeMove()
	{
		int bestCounter = bot.getBestCounter();
		int player = bot.getBotTurn();
		
		System.out.println(bestCounter);
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
