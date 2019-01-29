package GameFiles;

import java.util.ArrayList;

public class StrategyEasy extends Strategy{
	

	public StrategyEasy(TTT_Bot bot) {
		super(bot);
	}

	@Override
	public int makeMove()
	{
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
		
		return x;
	}
	
}
