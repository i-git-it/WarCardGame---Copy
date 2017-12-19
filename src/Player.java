import java.util.Arrays;

public class Player {
	int playCount=0;

	boolean hasLost= false;
	private String name;
	private int [] mainDeck;
	private int [] sideDeck = new int[0];
	Dealer dealer = new Dealer();
	
	//NAME
	public Player (String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return this.name;
	}

	public void setMainDeck(int [] deck)
	{
		this.mainDeck = deck;
	}
	
	public int [] getMainDeck()
	{
		return this.mainDeck;
	}
	
	public int [] getSideDeck()
	{
		return this.sideDeck;
	}
	
	public int getTopCard()
	{
	return mainDeck[0];
	}
	

	
	public int playCard() // plays top card and then removes it from the main deck
	{	playCount++;
		if (mainDeck.length<1)//mainDeck Ran out
		{
			System.out.println(this.name + "'s Main Deck ran out..");
			if(sideDeck.length<1)
			{ 
				System.out.println(this.name + " Has Lost");
				hasLost= true; //GAME OVER***************** working here Add chek in main
				System.out.println("Play Count = " + playCount);
				System.exit(0);
			}
			mainDeck = dealer.shuffle(sideDeck); //shuffel Side Deck and give it to Main Deck
			int [] temp = new int [0];     // create a null aray leangth 1
			this.sideDeck = temp; // make side Deck = 0
		}
		
		int topCard = getTopCard();
		int n=mainDeck.length-1;
		int[] newArray=new int[n];
		System.arraycopy(mainDeck,1,newArray,0,n);
		this.setMainDeck(newArray);
		return topCard; 
		     
	}
	
	
	public void addToSideDeck(int card1, int card2)
	{
		int n = sideDeck.length +2;
		int [] newArray = new int[n];
		System.arraycopy(sideDeck,0,newArray,0,sideDeck.length); 
		newArray[n - 1] = card1;
		newArray[n - 2] = card2;
		sideDeck = newArray;
	}
	
	public void addWarWinningsToSideDeck(int[]warWinnings)
	{
		int n = sideDeck.length + warWinnings.length;
		int [] newArray = new int[n];
		System.arraycopy(sideDeck,0,newArray,0,sideDeck.length); 
		System.arraycopy(warWinnings,0,newArray,sideDeck.length, warWinnings.length);
		sideDeck = newArray;
		
	}

}
