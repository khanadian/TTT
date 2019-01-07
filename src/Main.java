import java.util.ArrayList;

public class Main 
{
	private Tile[] tileList = new Tile[9];
	private ArrayList<Tile[]> winningCombos;
	
	public static void main(String[] args)
	{
		
	}
	
	private void setupList()
	{
		for(int i = 0; i < 9; i++)
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
	}
	
}


//for running the program
/*public class Paint {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Paint();
			}
		});
	}*/
