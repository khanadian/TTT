package GameFiles;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TTT_Controller {

	private TTT_Model model;
	private View view;
	
	public TTT_Controller(TTT_Model m, View v)
	{
		model = m;
		view = v;
	}
	
	class TileListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			view.actionPerformed(e);
		}
	}
}
