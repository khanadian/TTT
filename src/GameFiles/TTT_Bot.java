package GameFiles;
import java.util.ArrayList;


// a computer opponent for the TTT_Model of tic tac toe.
// allows difficulty settings
// can take in the TTT_Model state and respond accordingly

class TTT_Bot {
	private int player; //bot's turn
	private int bestCounter;
	private TTT_Model TTT_Model;
	private Strategy strat; 
	
	
	public static final int EASY = -1;
	public static final int MEDIUM = 0;
	public static final int HARD = 1;
	public static final int IMPOSSIBLE = 2;
	int difficulty;
	
	TTT_Bot(int diff, int player, TTT_Model m)
	{
		this.player = player;
		this.TTT_Model = m;
		
		if (diff == -1)
		{
			strat = new StrategyEasy(this);
		}
		else if(diff == 0)
		{
			strat = new StrategyMedium(this);
		}
		else if(diff == 1)
		{
			strat = new Strategyhard(this);
		}
		else if(diff == 2)
		{
			strat = new StrategyImpossible(this);
		}
		else
		{
			strat = new Strategy(this);
		}
		
	}
	
	TTT_Bot(int player, TTT_Model m)
	{
		this(0, player, m);
	}
	
	// returns an int representing the tile (not index) that was picked
	public int makeMove()
	{
		strat.update(player);
		return strat.makeMove();
	}

	
	
	
// find the best combo
	private Tile[] bestCombo(ArrayList<Tile[]> winningCombos, String symbol)
	{
		if (winningCombos.isEmpty())
		{
			bestCounter = 0;
			return new Tile[] {};
		}
		Tile[] best = winningCombos.get(0);
		bestCounter = 0;
		int symbCounter = 0;
		
		for(Tile[] combo : winningCombos)
		{
			for(int i = 0; i < 3; i ++)
			{
				if (combo[i].getSymbText().equals(symbol))
					symbCounter ++;
			}
			if (symbCounter > bestCounter)
			{
				best = combo;
				bestCounter = symbCounter;
			}
			symbCounter = 0;
		}
		
		return best;
	}
	
	// next couple blocks are for strategy design pattern
	public Tile[] getBestCombo(int p)
	{
		return bestCombo(TTT_Model.getWinningCombos(p), getSymbol(p));
	}
	
	public int getBestCounter()
	{
		return bestCounter;
	}
	
	//this one is also used elsewhere
	public int getBotTurn()
	{
		return player;
	}
	
	public String getSymbol(int p)
	{
		return TTT_Model.getSymbol(p);
	}
	
	public ArrayList<Integer> getFrTiles()
	{
		return TTT_Model.getFreeTiles();
	}
}
