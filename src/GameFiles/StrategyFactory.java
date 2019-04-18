package GameFiles;

public class StrategyFactory {

	public Strategy getStrat(int diff, TTT_Bot bot){
		if(diff == -1)
			return new StrategyEasy(bot);
		else if(diff == 0)
			return new StrategyMedium(bot);
		else if(diff == 1)
			return new StrategyHard(bot);
		else
			return new StrategyDynamic(bot);//Impossible(bot);
		
	}
	
}
