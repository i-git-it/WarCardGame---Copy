
public class Round {

	private int player1Card;
	private int player2Card;
	private int [] warWinnings = new int[0];
	
	WarCard card = new WarCard();
	
	public Round()
	{
		
	}
	
	public void playRound(Player player1, Player player2)
	{
		player1Card = player1.playCard();
		player2Card = player2.playCard();
		
		System.out.println (player1.getName() + " " + card.cardToEnglish(player1Card));
		System.out.println (player2.getName() + " " + card.cardToEnglish(player2Card));

		
		if (card.getINTCardRank(player1Card) != card.getINTCardRank(player2Card))
		{
			if (card.getINTCardRank(player1Card) > card.getINTCardRank(player2Card) )
			   {
					System.out.println(player1.getName() + " Wins");
					player1.addToSideDeck(this.player1Card, this.player2Card);
			   } else 
			     {
				    System.out.println(player2.getName() + " Wins");
				    player2.addToSideDeck(this.player1Card, this.player2Card);
			     }
		} else{// its war
		         System.out.println("It's WAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		         warHandler(player1,player1Card,player2,player2Card);
 
		       }
	}//end playRound()
	
	private void warHandler(Player player1, int card1, Player player2, int card2)
	{ 
		addTwoCardsToWarWinnings(card1,card2);
		addTwoCardsToWarWinnings(player1.playCard(),player2.playCard());// add cards face down
		addTwoCardsToWarWinnings(player1.playCard(),player2.playCard());
		System.out.println("Bothe players play 2 cards face down");
		
		int P1EndWar = player1.playCard();
		System.out.println (player1.getName() + " " + card.cardToEnglish(P1EndWar));
		int P2EndWar = player2.playCard();
		System.out.println (player2.getName() + " " + card.cardToEnglish(P2EndWar));
		
		if(card.getINTCardRank(P1EndWar) != card.getINTCardRank(P2EndWar))
		{  addTwoCardsToWarWinnings(P1EndWar,P2EndWar);
					if(card.getINTCardRank(P1EndWar)>card.getINTCardRank(P2EndWar))
					{
						System.out.println (player1.getName() + " Won the War!");
						// add warWinnings to player1 side deck
						player1.addWarWinningsToSideDeck(warWinnings);
						warWinnings = new int[0];// Clear Aray
						
						
					}else{
						System.out.println (player2.getName() + " Won the War!");
						// add warWinnings to player2 side deck
						player2.addWarWinningsToSideDeck(warWinnings);
						warWinnings = new int[0]; // Clear Aray

					}
			
		}else
		{
			System.out.println ("WOW ANOTHER WAR!!!!!!!!!*******************************");
			warHandler(player1,P1EndWar,player2,P2EndWar);
		}
		
	}//end warHandler
	
	
	public void addTwoCardsToWarWinnings(int card1, int card2)
	{
		int n = warWinnings.length +2;
		int [] newArray = new int[n];
		System.arraycopy(warWinnings,0,newArray,0,warWinnings.length); 
		newArray[n - 1] = card1;
		newArray[n - 2] = card2;
		warWinnings = newArray;
	}

	
}//end Round Class
