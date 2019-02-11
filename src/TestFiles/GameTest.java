package TestFiles;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import GameFiles.Tile;

public class GameTest {

	@Test
	public void testremoveVoidCombos() {
		Tile[] tileList = new Tile[3];
		ArrayList<Tile[]> combo = new ArrayList<Tile[]>();
		
		
		combo.add(tileList);
		
		assertTrue(tileList[0].getSymbText().equals(" "));
	}

}
