import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TTT_Controller {

	private Game game;
	private View view;
	
	public TTT_Controller(Game g, View v)
	{
		game = g;
		view = v;
	}
	
	class TileListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
}
