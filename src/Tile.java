
public class Tile 
{
	private boolean empty;
	private String symbText;
	private int id;
	
	
	public Tile(String symbText)
	{
		this.empty = false;
		this.symbText = symbText;
		int id = -1;
	}
	
	public Tile()
	{
		this.empty = true;
		symbText = " ";
	}
	
	public Tile(int number)
	{
		this.id = number;
		this.symbText = Integer.toString(number);
		this.empty = true;
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
	}
	
	public String getSymbText()
	{
		return symbText;
	}
	
	public String toString()
	{
		return Integer.toString(id);
	}
}

