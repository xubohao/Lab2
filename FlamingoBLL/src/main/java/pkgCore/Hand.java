package pkgCore;

import java.util.ArrayList;
import java.util.Collections;

import pkgEnum.eRank;

public class Hand {

	private int iScore;
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public Hand()
	{
		
	}
	
	public int[] ScoreHand()
	{
		int [] iScore = new int[2];
		
		iScore[0] = 0;
		iScore[1] = 0;
		
		Collections.sort(cards);
		
		//	DONE: Determine the score.  
		//			Cards:
		//			2-3-4 - score = 11
		//			5-J-Q - score = 25
		//			5-6-7-2 - score = 20
		//			J-Q	- score = 20
		//			8-A = score = 9 or 19
		//			4-A = score = 5 or 15
		int numOfAce = 0;
		for (Card c: cards)
		{
			if (c.geteRank() == eRank.ACE) {
				// for Ace:
				numOfAce += 1;
				iScore[0] += 11;
				iScore[1] += 11;
			} 
			else if (c.geteRank().getiRankNbr() >= eRank.JACK.getiRankNbr()) {
				// for Face:
				iScore[0] += 10;
				iScore[1] += 10;
			}
			else {
				iScore[0] += c.geteRank().getiRankNbr();
				iScore[1] += c.geteRank().getiRankNbr();
			}
		}
		if (numOfAce >= 1) {
			while (iScore[1] > 21 && numOfAce > 0) {
				iScore[1] -= 10;
				numOfAce -= 1;
			}
			if (numOfAce > 0 && iScore[1] != 21) {
				iScore[0] = iScore[1] - 10;
			} else {
				iScore[0] = iScore[1];
			}
		}
		
		return iScore;
	}
	
	public void Draw(Deck d)
	{
		//	DONE: add a card to 'cards' from a card drawn from Deck d
		cards.add(d.draw());
	}
	
	private void AddCard(Card c)
	{
		cards.add(c);
	}
	
}
