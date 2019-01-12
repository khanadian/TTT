import java.util.ArrayList;
import java.util.Scanner;

//game of tic tac toe
public class Game 
{
	private Tile[] tileList = new Tile[10];
	private int[] freeTiles;
	private ArrayList<Tile[]> winningCombos1; // used to check for win states for player 1
	private ArrayList<Tile[]> winningCombos2; // used to check for win states for player 2                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
	Scanner sc = new Scanner(System.in);
	private boolean keepPlaying;

	private String playerOneSymbol = "X";
	private String playerTwoSymbol = "O";
	
	public static void main(String[] args) 
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() { // this is to follow active program protocols
			public void run() 
			{
				new Game();
			}});
	}
	
	private Game()
	{
		//setting up
		int playerTurn;
		int check = 0;
		int inp = 0;
		String input = "DEFAULT";
		boolean verified;
		boolean isGameOver;
		keepPlaying = true;
		String[] playerSymbol = new String[] {"ERROR", playerOneSymbol, playerTwoSymbol};
		
		System.out.println("Let's play some Tic Tac Toe!");
		
		while(keepPlaying)
		{
			//starting new game
			
			for(int i = 1; i < 10; i++)
				tileList[i] = new Tile(i);
			
			winningCombos1 = setupList();
			winningCombos2 = setupList();
			playerTurn = 1;
			isGameOver = false;
			
			freeTiles = new int[] {1,2,3,4,5,6,7,8,9};
			
			while(isGameOver == false)
			{
				verified = false;
				while(verified == false)
				{
					displayGrid();
					System.out.println("Pick a tile ("+ printFree() +")");
					
					try 
					{
						input = sc.next();
						inp = Integer.parseInt(input);
						
						if (inp < 1 || inp > 9)
							System.out.println(inp +" is not between 1-9");
						else if ((tileList[inp].isEmpty()) == false)
							System.out.println("that tile's already taken");
						else	
							verified = true;
						
						
					}
					catch(Exception e){System.out.println("\"" + input +"\" is not a number");}
				}
				
				//player has chosen their move
				freeTiles[inp-1] = 0;
				tileList[inp].setSymbText(playerSymbol[playerTurn]);
				
				if(playerTurn == 1)
				{
					removeVoidCombos(winningCombos2, playerOneSymbol);
					check = checkEnd(winningCombos1);
				}
				else
				{
					removeVoidCombos(winningCombos1, playerTwoSymbol);
					check = checkEnd(winningCombos2);
				}
				
				
				
				if(check == 0)
					playerTurn = playerTurn ^ 3; //XOR, switches bits from 01 to 10, and vice versa
				else
					isGameOver = true;
			}
			displayGrid();
			System.out.println("Game Over!");
			if(check != 2)
				System.out.println("Player "+ playerTurn + " wins!");
			else
				System.out.println("It is a tie!");	
			
			verified = false;
			while(verified == false)
			{
				System.out.println("Want to keep playing? (y/n)");
				
				try 
				{
					input = sc.next();
					
					if (input.equals("y"))
					{
						System.out.println("Yay!");
						verified = true;
					}
					else if (input.equals("n"))
					{
						System.out.println("aw...");
						verified = true;
						keepPlaying = false;
					}
					else	
						System.out.println("\"" + input +"\" is not a proper input");
					
				}
				catch(Exception e){System.out.println("thats not a proper input");}
			}
			
		}
		
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
	
	// displays the board
	private void displayGrid()
	{
		for (int i = 0; i < 5; i++)
		{
			if(i % 2 == 0)
				displayLine( (int) (i * 1.5 + 1),(int) (i * 1.5 + 2),(int)( i * 1.5 + 3));
			else
				System.out.println("--+-+--");
		}
		
		
	}
	
	// displays individual lines for the board containing the tiles
	private void displayLine(int i, int j, int k)
	{
		System.out.println(" " + tileList[i].getSymbText() +"|"+ tileList[j].getSymbText() +"|"+  tileList[k].getSymbText());
	}
	
	//string representation of free/empty tiles
	private String printFree()
	{
		boolean comma = false;
		String nums = "";
		
		for (int tile = 1; tile < 10; tile++)
		{
			if(freeTiles[tile-1] != 0)
			{
				if(comma)
					nums = nums + ", ";
				
				nums = nums + Integer.toString(tile);
				comma = true;
			}
		}
		return nums;
	}
	
	//checks if game has ended, 1 = win, 2 = draw, 0 = continue
	private int checkEnd(ArrayList<Tile[]> array)
	{
		//printFree().equals("")                                   <- let them play it out
		//winningCombos1.isEmpty() && winningCombos2.isEmpty()     <- would draw early, no need to play out
		if(winningCombos1.isEmpty() && winningCombos2.isEmpty())
			return 2;
		
		for (Tile[] combos: array)
		{
			if((combos[0].getSymbText().equals(combos[1].getSymbText()) && 
					combos[2].getSymbText().equals(combos[1].getSymbText())))
			{
				return 1;
			}
		}
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
	
	// lets the user see their winning options
	private void printWinningCombos(ArrayList<Tile[]> win)
	{
		for (Tile[] combo : win)
		{
			System.out.print("(");
			for (int i = 0; i < 3; i++)
			{
				System.out.print(combo[i]);
				if (i < 2)
					System.out.print(", ");
			}
			
			System.out.println(")");
		}
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
	
	public int[] getFreeTiles()
	{
		return freeTiles;
	}
}



/*
 - |   |\ /
| ||   | X
 - |   |/ \
-----------
   |   | 
   |   | 
   |   | 
-----------
   |   | 
   |   | 
   |   | 
   
   */

/*
 - |   |\ /
| ||   | X
 - |   |/ \
-----------
   |   | 
   |   | 
   |   | 
-----------
   |   | 
   |   | 
   |   | 
  
 O| |X
--+-+--
 O| |X
--+-+--
 X|O|
  */