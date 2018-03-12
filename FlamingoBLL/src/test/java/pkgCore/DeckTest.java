package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class DeckTest {

	@Test
	public void TestDeck() {
		
		//	TODO: Build a deck(1), make sure there are 52 cards in the deck
		Deck d_1 = new Deck(1);
		assertEquals(d_1.getNumOfCards(), 52);	
//		assertEquals(d_1.getRemaining(eRank.TWO), 4);
//		assertEquals(d_1.getRemaining(eSuit.CLUBS), 13);
		
		//	TODO: Build a deck(6), make sure there are 312 cards in the deck 
		Deck d_2 = new Deck(6);
		assertEquals(d_2.getNumOfCards(), 312);
	}

}
