package GameFiles;


public class Strategyhard extends Strategy implements StratInterface{

	public Strategyhard(TTT_Bot bot) {
		super(bot);
	}

	@Override
	public int makeMove()
	{
		int bestCounter = bot.getBestCounter();
		int player = bot.getBotTurn();
		
		if(bestCounter >= 2)
		{
			
			return win(player);
		}
		
		best = bot.getBestCombo(player^3);
		if (bestCounter >= 2) 
		{
			return block(player^3);
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
