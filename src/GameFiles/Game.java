package GameFiles;

//game of tic tac toe
public class Game 
{
	public static void main(String[] args) 
	{
		new Game();
	}
	
	private Game()
	{
		TTT_Model model = new TTT_Model();
		View view = new View(model);
	}
	
}


	