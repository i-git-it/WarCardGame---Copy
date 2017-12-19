
public class WarCard {

	public int getINTCardRank (int card)
	{
		int rank = card % 13;
		return rank;
	}
	
	//This Method might be useles.. use cardToEnglish
	public String getStringCardRank(int card)
	{
		String[] rank = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		int tempCard = card % 13; //divide into 1-13
		return rank [tempCard] ;	
	}
	
	public String cardToEnglish(int card)
	{
		String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
		int tempCard = card / 13; //divide into 1-13
		return getStringCardRank(card) + " of " + suits[tempCard];	
	}
	
	// get suit
}
