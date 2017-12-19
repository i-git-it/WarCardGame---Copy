

// The Dealer can start a new game and dose all the shuffling 
public class Dealer {
	
		// for starting the game

	private int [] firstHalf = new int[26];
	private int [] secondHalf = new int [26];
	
	//SHUFFLE
	public int [] shuffle (int deck[])
	{	
		 for (int i = 0; i < deck.length; i++) {
			 int index = (int)(Math.random() * deck.length);
			 int temp = deck[i];
			 deck[i] = deck[index];
			 deck[index] = temp;
		 }

		return deck;
	}
	
	
	public void DealNewGame()
	{  
		int[] deck = new int[52];
    
		// Initialize cards
		for (int i = 0; i < deck.length; i++) {
			deck[i] = i;
		}	
		//shuffle
		shuffle(deck);

		// split the deck in half
//		              (src   , src-offset  , dest , offset, count)
		System.arraycopy(deck, 0           , firstHalf, 0     , firstHalf.length);
		System.arraycopy(deck, firstHalf.length, secondHalf, 0     , secondHalf.length);
	}
	
	public int[] getFirstHalf()
	{
		return firstHalf;
	}
	public int[] getSecondHalf()
	{
		return secondHalf;
	}
	
}
