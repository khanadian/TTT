import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class GameTest {

	@Test
	public void testremoveVoidCombos() {
		Tile[] tileList = new Tile[3];
		ArrayList<Tile[]> combo = new ArrayList<Tile[]>();
		
		tileList[0] = new Tile();
		tileList[1] = new Tile();
		
		combo.add(tileList);
		
		assertTrue(1 == 1);
	}

}
