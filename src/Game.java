import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game 
{
	private Tile[] tileList = new Tile[10];
	private ArrayList<Integer> freeTiles;
	private ArrayList<Tile[]> winningCombos1; // used to check for win states for player 1
	private ArrayList<Tile[]> winningCombos2; // used to check for win states for player 2                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
	Scanner sc = new Scanner(System.in);
	private int playerTurn; // indicates which player is playing
	private boolean play;
	private boolean isOver;
	int inp;
	boolean verified;
	String input;
	int check;
	
	
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
		play = true;
		
		while(play)
		{
			//starting new game
			
			for(int i = 1; i < 10; i++)
				tileList[i] = new Tile();
			
			winningCombos1 = setupList();
			winningCombos2 = setupList();
			playerTurn = 1;
			isOver = false;
			
			
			
			freeTiles = new ArrayList<Integer>();
			for(int i = 1; i < 10; i++)
				freeTiles.add(Integer.valueOf(i));
			
			while(isOver == false)
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
							System.out.println("thats not between 1-9");
						else if ((tileList[inp].isEmpty()) == false)
							System.out.println("that tile's already taken");
						else	
							verified = true;
						
						
					}
					catch(Exception e){System.out.println("thats not a number");}
				}
				
				//player has chosen their move
				freeTiles.set(inp-1, 0);
				tileList[inp].setSymbol(playerTurn);
				
				if(playerTurn == 1)
				{
					removeVoidCombos(winningCombos2, "X"); //error occurs at this line
					check = checkEnd(winningCombos2);
				}
				else
				{
					removeVoidCombos(winningCombos1, "O");
					check = checkEnd(winningCombos1);
				}
				
				
				if(check == 0)
				{
					playerTurn++;
					playerTurn = playerTurn % 2; // fancy way of alternating between players
				}
				else
					isOver = true;
			}
			System.out.println("Game Over!");
			System.out.println("Player "+ playerTurn + " wins!");
		}
		
	}
	
	/*
	 * sets up the winning combos for a player
	 * input: list of winning combinations
	 */
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
	
	private String printFree()
	{
		boolean comma = false;
		String nums = "";
		
		for (int tile : freeTiles)
		{
			if(tile != 0)
			{
				if(comma)
					nums = nums + ", ";
				
				nums = nums + Integer.toString(tile);
				comma = true;
			}
		}
		return nums;
	}
	
	//checks if game has ended, 1 = win, 2 = draw
	private int checkEnd(ArrayList<Tile[]> array)
	{
		if(winningCombos1.isEmpty() && winningCombos2.isEmpty())
			return 2;
		
		for (Tile[] combos: array)
		{
			if(combos[0].getSymbol() != 2 && (combos[0].getSymbol() == combos[1].getSymbol()) && 
					combos[1].getSymbol() == combos[2].getSymbol())
			{
				return 1;
			}
		}
		return 0;
	}
	
	private void removeVoidCombos(ArrayList<Tile[]> array, String symb)
	{
		boolean skip = true;
		List<Integer> toRemove = new ArrayList<Integer>();
		for (Tile[] combos : array)
		{
			skip = true;
			for(int i = 0; i < 3; i++)
			{
				if(combos[i].getSymbText().equals(symb) && skip == true)
				{
					toRemove.add(array.indexOf(combos));
					skip = false;
				}
			}
		}
		for(Integer i : toRemove) {
			array.remove(i);
		}
	}
}

// checks if the game has ended. 1 = current player won, 2 = draw, 0 = no ending


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

//System.out.println("hi");