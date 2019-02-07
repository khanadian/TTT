package GameFiles;


public class StrategyEasy extends Strategy{
	

	public StrategyEasy(TTT_Bot bot) {
		super(bot);
	}

	@Override
	public int makeMove()
	{
		return pickRandom();
	}
	
}
