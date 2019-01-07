import java.util.ArrayList;
import java.util.Scanner;

public class Game 
{
	private Tile[] tileList = new Tile[10];
	private ArrayList<Tile[]> winningCombos;
	Scanner sc = new Scanner(System.in);
	private int playerTurn; // indicates which player is playing
	
	
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
		setupList();
		playerTurn = 1;
		
		
		
	}
	
	private void setupList()
	{
		// only needs setup once
		for(int i = 1; i < 10; i++)
		{
			tileList[i] = new Tile();
		}
		
		//these need to be setup after every time the game is played. The code about does not
		winningCombos = new ArrayList<Tile[]>();
		winningCombos.add(new Tile[] {tileList[1], tileList[2], tileList[3]});
		winningCombos.add(new Tile[] {tileList[4], tileList[5], tileList[6]});
		winningCombos.add(new Tile[] {tileList[7], tileList[8], tileList[9]});
		winningCombos.add(new Tile[] {tileList[1], tileList[4], tileList[7]});
		winningCombos.add(new Tile[] {tileList[2], tileList[5], tileList[8]});
		winningCombos.add(new Tile[] {tileList[3], tileList[6], tileList[9]});
		winningCombos.add(new Tile[] {tileList[1], tileList[5], tileList[9]});
		winningCombos.add(new Tile[] {tileList[3], tileList[5], tileList[7]});
		
		System.out.println("hi");
	}
	
}

