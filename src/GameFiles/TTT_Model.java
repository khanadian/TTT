package GameFiles;
import java.util.ArrayList;

//game of tic tac toe
public class TTT_Model 
{
	private Tile[] tileList = new Tile[10];
	private ArrayList<Integer> freeTiles = new ArrayList<Integer>();
	private ArrayList<Tile[]> winningCombos1; // used to check for win states for player 1
	private ArrayList<Tile[]> winningCombos2; // used to check for win states for player 2        
	int playerTurn;

	private String playerOneSymbol = "X";
	private String playerTwoSymbol = "O";
	String[] playerSymbol;
	
	private Tile[] winningCombo = new Tile[3]; // the combination that actually wins
	
	
	public TTT_Model()
	{
		//setting up
		playerSymbol = new String[] {"ERROR", playerOneSymbol, playerTwoSymbol};
		
		for(int i = 1; i < 10; i++)
			tileList[i] = new Tile(i);
			
		winningCombos1 = setupList();
		winningCombos2 = setupList();
		playerTurn = 1;
			
		freeTiles = new ArrayList<Integer>();
		for(int i = 1; i < 10; i ++)
		{
			freeTiles.add(i);
		}
	
	}
	// makes a move for the current player, given the tile Number
	public ArrayList<Tile[]> makeMove(int tileNum)
	{
		freeTiles.remove((Integer) (tileNum));
		tileList[tileNum].setSymbText(playerSymbol[playerTurn]);
		
		
		if(playerTurn == 1)
		{
			removeVoidCombos(winningCombos2, playerOneSymbol);
			}
		else
		{
			removeVoidCombos(winningCombos1, playerTwoSymbol);
		}
		
		
		
		if(playerTurn == 1)
		{
			return winningCombos1;
		}
		else
		{
			return winningCombos2;
		}
	}
	
	// alternates whose turn it is
	public void switchPlayer()
	{
		playerTurn = playerTurn ^ 3; //XOR, switches bits from 01 to 10, and vice versa
	}
	//sets up the winning combos for a player
	private ArrayList<Tile[]> setupList()
	{
		ArrayList<Tile[]> combos = new ArrayList<Tile[]>();
		combos.add(new Tile[] {tileList[1], tileList[2], tileList[3]});
		combos.add(new Tile[] {tileList[4], tileList[5], tileList[6]});
		combos.add(new Tile[] {tileList[7], tileList[8], tileList[9]});
		combos.add(new Tile[] {tileList[1], tileList[4], tileList[7]});
		combos.add(new Tile[] {tileList[2], tileList[5], tileList[8]});
		combos.add(new Tile[] {tileList[3], tileList[6], tileList[9]});
		combos.add(new Tile[] {tileList[1], tileList[5], tileList[9]});
		combos.add(new Tile[] {tileList[3], tileList[5], tileList[7]});
		return combos;
	}
	

	//TODO: needed for checkEnd(), do not remove
	private String printFree()
	{
		boolean comma = false;
		String nums = "";
		
		for (Integer tile : freeTiles)
		{
			if(comma)
					nums = nums + ", ";
				
			nums = nums + tile.toString();
			comma = true;
		}
		return nums;
	}
	
	//checks if game has ended, 1 = win, 2 = draw, 0 = continue
	public int checkEnd(ArrayList<Tile[]> array)
	{
		
		
		for (Tile[] combos: array)
		{
			if((combos[0].getSymbText().equals(combos[1].getSymbText()) && 
					combos[2].getSymbText().equals(combos[1].getSymbText())))
			{
				winningCombo = combos;
				return 1;
			}
		}
		
		//printFree().equals("")                                   <- let them play it out
		//winningCombos1.isEmpty() && winningCombos2.isEmpty()     <- would draw early, no need to play out
				
		if(printFree().equals(""))
			return 2;
		
		return 0;
	}
	
	//removes combos that can no longer be made
	private void removeVoidCombos(ArrayList<Tile[]> array, String symb)
	{
		boolean skip;
		int[] toRemove = new int[8];
		int counter = 0;
		
		for (Tile[] combo : array)
		{
			skip = false;
			for(int i = 0; i < 3; i++)
			{
				if(skip == false && combo[i].getSymbText().equals(symb)) // look up the number and its symbol
				{
					toRemove[counter] = (array.indexOf(combo));
					skip = true;
					counter++;
				}
			}
		}
		for(int i = counter - 1; i > -1; i--)
		{
			array.remove(toRemove[i]);
		}
	}

	// returns the combo that won the game
	public Tile[] getWinCombo()
	{
		return winningCombo;
	}
	
	public ArrayList<Tile[]> getWinningCombos(int player)
	{
		if(player == 1)
			return winningCombos1;
		return winningCombos2;
	}
	
	public String getSymbol(int player)
	{
		if (player == 1)
			return playerOneSymbol;
		return playerTwoSymbol;
	}
	//needed for the bot, do not remove
	public ArrayList<Integer> getFreeTiles()
	{
		return freeTiles;
	}
	
	public int getPlayerTurn()
	{
		return playerTurn;
	}
	
}
