package GameFiles;


public class StrategyMedium extends Strategy implements StratInterface{

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
			return win(player);
			
		// block opponent

		super.update(player^3);
		best = bot.getBestCombo(player^3);
		bestCounter = bot.getBestCounter();
		if(bestCounter >= 2)
			return block(player^3);
	
		return pickRandom();
	}
	
	
	
}
