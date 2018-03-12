package pkgCore;

import pkgEnum.eRank;
import pkgEnum.eSuit;

import java.util.ArrayList;

public class Deck {

	//	DONE: Add 'cards' attribute that is an ArrayList of Card
	private ArrayList<Card> cards  = new ArrayList<Card>();
	
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public int getNumOfCards() {
		return cards.size();
	}
	//	DONE: Add a contructor that passes in the number of decks, and then populates
	//			ArrayList<Card> with cards (depending on number of decks).
	
	//			Example: Deck(1) will build one 52-card deck.  There are 52 different cards
	//			2 clubs, 3 clubs... Ace clubs, 2 hearts, 3 hearts... Ace hearts, etc

	//			Deck(2) will create an array of 104 cards.
    public Deck(int numOfDeck) {   	
        // for each rank:
    	// Note that ONE is not a valid rank!
        for (int r = 1; r < 14; ++r) {
            // for each suit:
            for (eSuit suit : eSuit.values()) {
                // add numOfDeck cards with same rank and suit:
                for (int i = 0; i < numOfDeck; ++i) {
                	eRank rank = eRank.values()[r];
                    Card c = new Card(suit, rank);
                    cards.add(c);
                }
            }
        }
    }
	
	//	DONE: Add a draw() method that will take a card from the deck and
	//			return it to the caller
    public Card draw() {
        Card c = cards.get(0);
        cards.remove(0);
        return c;
    }

    // NEW: return of the count of Suit or Rank (depending on which enum you pass).
    long getRemaining(Object obj) {
    	if (obj instanceof eSuit) {
    		return cards.stream().filter(c -> c.geteSuit() == (eSuit)obj).count();
    	} else if (obj instanceof eRank) {
    		return cards.stream().filter(c -> c.geteRank() == (eRank)obj).count();
    	} else {
    		throw new RuntimeException("Cannot accept object other than eSuit or eRank");
    	}
    }
}
