
public class Tile 
{
	boolean empty;
	int symbol; // 0 = O, 1 = empty, 2 = x
	
	public Tile(boolean empty, int symbol)
	{
		this.symbol = symbol;
		this.empty = empty;
	}
	
	public Tile()
	{
		this.empty = true;
		this.symbol = 1;
	}
	
}
