import java.util.ArrayList;

public class Main 
{
	private Tile[] tileList = new Tile[9];
	private ArrayList<Tile[]> winningCombos = new ArrayList<Tile[]>();
	
	public static void main(String[] args)
	{
		//System.out.println("hello world");
	}
	
	private void setupList()
	{
		for(int i = 0; i < 9; i++)
		{
			tileList[i] = new Tile();
		}
		
		winningCombos.add(new Tile[] {tileList[1], tileList[2], tileList[3]});
		winningCombos.add(new Tile[] {tileList[4], tileList[5], tileList[6]});
		winningCombos.add(new Tile[] {tileList[7], tileList[8], tileList[9]});
		winningCombos.add(new Tile[] {tileList[1], tileList[4], tileList[7]});
		winningCombos.add(new Tile[] {tileList[2], tileList[5], tileList[8]});
		winningCombos.add(new Tile[] {tileList[3], tileList[6], tileList[9]});
		winningCombos.add(new Tile[] {tileList[1], tileList[5], tileList[9]});
		winningCombos.add(new Tile[] {tileList[3], tileList[5], tileList[7]});
		
	}
	
}


