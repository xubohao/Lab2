package pkgCore;
import pkgEnum.*;
public class Card implements Comparable {

	//	DONE: Card has two attributes, eRank and eSuit, add these attributes
	private eRank eRank;
	private eSuit eSuit;

	//	DONE: Build a constructor for Card passing in eRank and eSuit
	public Card(eSuit suit, eRank rank) {
		this.eRank = rank;
		this.eSuit = suit;
	}
	
	//	DONE: Add a public 'getter' method for eRank and eSuit.
	//			Add a private 'setter' method for eRank and eSuit
    public eRank geteRank() {
        return eRank;
    }

    public eSuit geteSuit() {
        return eSuit;
    }

    private void seteRank(eRank eRank) {
        this.eRank = eRank;
    }

    private void seteSuit(eSuit eSuit) {
	    this.eSuit = eSuit;
    }

    @Override
	public int compareTo(Object o) {
		Card c = (Card) o;
		//return 0;
		return c.geteRank().compareTo(this.geteRank());
    }

}
