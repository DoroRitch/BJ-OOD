package blackjack.tramp;

import java.util.List;
import java.util.ArrayList;

public class Hand {
	private List<Card> hands = new ArrayList<Card>();
	private int points;

	public void add(Card card) {
		hands.add(card);
	}
	public List<Card> getHand() {
		return this.hands;
	}

	public String toString() {
		String handList = "";

		for (int itr = 0; itr < hands.size(); itr++) {

			if (itr == hands.size() - 1) {
				handList += this.hands.get(itr);
			} else {
				handList += this.hands.get(itr) + " ‚Æ ";
			}

		}
		return handList;
	}

	public int getPoints() {
		points = 0;

		for (int itr = 0; itr < hands.size(); itr++) {
			points += hands.get(itr).getPoint();
		}

		if (hasAce() && points <=11) {
			points += 10;
		}
		return points;
	}
	public boolean hasAce() {
		boolean check = false;

		for (int itr = 0; itr < hands.size(); itr++) {

			if (hands.get(itr).getRank() == 1) {
				check = true;
			}
			
		} 
		return check;
	}

	public Card firstCard() {
		return hands.get(0);
	}
}