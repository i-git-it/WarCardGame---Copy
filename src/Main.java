import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main {
	// Stoped in background
	//https://www.youtube.com/watch?v=9dzhgsVaiSo
	// 29:36

	public static void main(String[] args) {
		Player player1 = new Player("Nathan");
		Player player2 = new Player("Melinda");
		WarCard card = new WarCard();
		Dealer dealer = new Dealer ();
		Round round = new Round();
		
		dealer.DealNewGame(); // shuffle a new deck and cut it in half

		//give a half to each player
		player1.setMainDeck(dealer.getFirstHalf());
		player2.setMainDeck(dealer.getSecondHalf());

		// play 5000 or until some one has lost
		for (int i=0; i<5000; i++){
		round.playRound(player1,player2);
		//System.out.println(player1.getName() + " Main deck " + Arrays.toString(player1.getMainDeck()));
		//System.out.println(player1.getName() + " side deck " + Arrays.toString(player1.getSideDeck()));
		//System.out.println(player2.getName() + " Main deck " + Arrays.toString(player2.getMainDeck()));
		//System.out.println(player2.getName() + " side deck " + Arrays.toString(player2.getSideDeck()));
		System.out.println("");

		}
		
	}

}
