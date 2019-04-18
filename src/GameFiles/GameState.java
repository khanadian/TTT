package GameFiles;

import java.util.*;
import java.io.*;

public class GameState {

	private Tile[] tileList;
	private ArrayList<Integer> freeTiles = new ArrayList<Integer>();
	private ArrayList<Tile[]> myWinCombo; // used to check for win states for bot
	private ArrayList<Tile[]> oppWinCombo; // used to check for win states for opponent
	private int player;
	private TTT_Model model;
	private int move;
	
	//boolean opponent;
	String[] states; // current turn symbol, is that me?(boolean), myScore, oppScore
	private static final int SYMBOL = 0;
	private static final int MYTURN = 1;
	private static final int MYSCORE = 2;
	private static final int OPPSCORE = 3;
	
	public GameState(TTT_Model m, int p)//, boolean opp) // TODO myturn is never set
	{
		model = m;
		tileList = m.getTileList();
		freeTiles = m.getFreeTiles();
		player = p;
		
		myWinCombo = model.getWinningCombos(player);
		oppWinCombo = model.getWinningCombos(player^3);
		
		//opponent = opp;
		states = new String[4];
		
		saveState();
		
		
	}
	
	private void saveState()
	{
		//TODO save the state into a text file or database.
		String title;
		String text;
		
		title = getTitle();
		states[SYMBOL] = model.getSymbol(player);
		//states[1] = Boolean.toString(opponent);
		calcScore();
		
		text = Arrays.toString(states);
		try
		{
			FileWriter write = new FileWriter(title);
			PrintWriter print = new PrintWriter(write);
			print.printf("%s" + "%n", text);
			print.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(1);
		}
		
	}
	private void calcScore()
	{
		
		int score = 0;
		int oppScore = 0;
		boolean myTurn = Boolean.parseBoolean(states[MYTURN]);
		
		if(freeTiles.size() == 1)
		{
			if (myTurn && myWinCombo.size() > 0)
				score = 10;
			else if(!myTurn && oppWinCombo.size() > 0)
				oppScore = 10;
		}
		else
		{
			int m = 0;
			for (int i = 0; i < freeTiles.size(); i++)
			{
				TTT_Model mod = new TTT_Model(model);
				int tileNum = freeTiles.get(i);
				
				mod.makeMove(tileNum);
				String[] split = readFile(tileNum, i);
				
				try
				{
					int myValue = Integer.parseInt(split[2].substring(1));
					int oppValue = Integer.parseInt(split[3].substring(1));
					String symb = split[0].substring(1);
					
					if (myTurn && myValue > score && myValue > oppScore)
					{
						score = myValue;
						m = tileNum;
					}
					else if(!myTurn &&  oppValue > oppScore)
					{
						oppScore = oppValue;
					}
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
					System.out.println(2);
				}
			}
			if (score > 0)
				score--;
			if (oppScore > 0)
				oppScore--;
				
			if(score > oppScore)
				move = m;
			else
				move = 0;
		}
			
		
		states[MYSCORE] = Integer.toString(score);
		states[OPPSCORE] = Integer.toString(oppScore);
	}
	
	// starts off 123456789x
	private String getTitle()
	{
		String title = "";
		for(int i = 1; i < 10; i++)
		{
			title = title + tileList[i].getSymbText();
		}
		title = title+states[SYMBOL];
		return title;
	}
	
	//makes a new game state for the database
	private void makeNewState(int tileNum, int i)
	{
		Tile[] t = tileList;
		t[tileNum].setSymbText(states[SYMBOL]);
		
		ArrayList<Integer> ft = freeTiles;
		ft.remove(i);
		
		String symb; 
		if(states[SYMBOL] == "O") //cheese way to do this
			symb = "X";
		else
			symb = "O";
		 
		new GameState(model, player);//, !opponent);
	}
	
	public int getMove()
	{
		return 1;
	}
	
	private String[] readFile(int tileNum, int i)
	{
		try
		{
		String title = getTitle();
		title = title.substring(0, tileNum) + states[SYMBOL] + title.substring(tileNum, title.length()) + states[SYMBOL];
		File f = new File(title + ".txt");
		while(!f.exists())
		{
			System.out.println("il");
			//set up new game state
			makeNewState(tileNum, i);
			System.out.println("state made");
		}
		System.out.println("ool");
		Scanner sc = new Scanner(f);
		String line = sc.nextLine();
		line = line.substring(1, line.length()); //remove brackets
		sc.close();
		return line.split(",");
		}
		catch(Exception x)
		{
			System.out.println(x.getMessage());
			System.out.println(3);
			return "hi".split(" ");
		}
	}
}

/* score: 
 * loss = -ve win, 
 * draw = 0, 
 * can win in 5 turns = n-4 
 * can win in 4 turns = n-3
 * can win in 3 turns = n-2
 * can win in 1 turn = n-1
 * can win right now = n
 */