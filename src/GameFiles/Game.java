package GameFiles;
import java.util.ArrayList;
import java.util.Scanner;

//game of tic tac toe
public class Game 
{
	
	
	
	
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
		//boolean keepPlaying = true;
		TTT_Model model = new TTT_Model();
		View view = new View(model);
		TTT_Controller cont = new TTT_Controller(model, view);
		
	}
	
}


	