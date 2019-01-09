
public class Tile 
{
	private boolean empty;
	private int symbol; // 0 = empty, 1 = X, 2 = O
	private String symbText;
	
	public Tile(boolean empty, int symbol, String symbText)
	{
		this.symbol = symbol;
		this.empty = empty;
		this.symbText = symbText;
	}
	
	public Tile()
	{
		this.empty = true;
		this.symbol = 0;
		symbText = " ";
	}
	
	public boolean isEmpty()
	{
		return this.empty;
	}
	
	public int getSymbol()
	{
		return symbol;
	}
	
	public void setSymbol(int symbol)
	{
		this.symbol = symbol;
		if(symbol == 1)
			symbText = "X";
		else if(symbol == 2)
			symbText = "O";
		else
			symbText = "ERROR";
		this.empty = false;
	}
	
	public String getSymbText()
	{
		return symbText;
	}
	
}

