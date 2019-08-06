package blackjack.tramp;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class Deck {
	private List<Card> bill = new ArrayList<Card>();

	public Deck() {
		for (Suit suit : Suit.values()) {

			for (int i = 0; i < 13; i++){
				Card card = new Card(suit, i + 1);
				bill.add(card);
			}
			
		}
		Collections.shuffle(bill);
	}

	public Card getTop() {
		return bill.get(0);
	}

	public void remove(){
		bill.remove(0);
	}
}