import java.util.stream.IntStream;

// a tile in the game of tic tac toe. 9 tiles in a 3x3 fashion make one board
public class Tile 
{
	private boolean empty;
	private String symbText;
	private int id;
	
	
	// bot stuff
	public static final int[] CORNERS = new int[]{1,3,7,9};
	public static final int[] SIDES = new int[]{2,4,6,8};
	public static final int CENTER = 5;
	private int priority;
	
	public Tile(String symbText, int ID)
	{
		this.empty = false;
		this.symbText = symbText;
		this.id = ID;
		this.priority = setPriority();
	}
	
	public Tile(int number)
	{
		this.id = number;
		this.symbText = Integer.toString(number);
		this.empty = true;
		this.priority = setPriority();
	}
	
	public int getID()
	{
		return this.id;
	}
	
	public boolean isEmpty()
	{
		return this.empty;
	}
	
	public void setSymbText(String symbText)
	{
		this.symbText = symbText;
		this.empty = false;
	}
	
	public String getSymbText()
	{
		return symbText;
	}
	
	public int getPriority()
	{
		return priority;
	}
	
	public String toString()
	{
		return Integer.toString(id);
	}
	
	private int setPriority()
	{
		if(id == CENTER)
			return 2;
		else if(IntStream.of(CORNERS).anyMatch(x -> x == id))
			return 1;
		else if(IntStream.of(SIDES).anyMatch(x -> x == id))
			return 0;
		return -1;
	}
}

