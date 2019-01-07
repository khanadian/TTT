import java.util.ArrayList;
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
	int i;
	boolean verified;
	String input;

	
	
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
		for(int i = 1; i < 10; i++)
			tileList[i] = new Tile();
		
		play = true;
		
		while(play)
		{
			//starting new game
			setupList(winningCombos1);
			setupList(winningCombos2);
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
						i = Integer.parseInt(input);
						
						if (i < 1 || i > 9)
							System.out.println("thats not between 1-9");
						else if ((tileList[i].isEmpty()) == false)
							System.out.println("that tile's already taken");
						else	
							verified = true;
						
						
					}
					catch(Exception e){System.out.println("thats not a number");}
				}
				//change the free tiles list
				freeTiles.set(i-1, 0);
				
				tileList[i].setSymbol(playerTurn);
				
				
				playerTurn++;
				playerTurn = playerTurn % 2; // fancy way of alternating between players
			}
		}
		
		
		
		
	}
	
	/*
	 * sets up the winning combos for a player
	 * input: list of winning combinations
	 */
	private void setupList(ArrayList<Tile[]> combos)
	{
		combos = new ArrayList<Tile[]>();
		combos.add(new Tile[] {tileList[1], tileList[2], tileList[3]});
		combos.add(new Tile[] {tileList[4], tileList[5], tileList[6]});
		combos.add(new Tile[] {tileList[7], tileList[8], tileList[9]});
		combos.add(new Tile[] {tileList[1], tileList[4], tileList[7]});
		combos.add(new Tile[] {tileList[2], tileList[5], tileList[8]});
		combos.add(new Tile[] {tileList[3], tileList[6], tileList[9]});
		combos.add(new Tile[] {tileList[1], tileList[5], tileList[9]});
		combos.add(new Tile[] {tileList[3], tileList[5], tileList[7]});
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

//System.out.println("hi");