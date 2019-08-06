package blackjack.tramp;

import blackjack.tramp.Suit;

public class Card {
	private Suit suit;
	private int rank;

	private String toDisplayValue() {
		switch (this.rank) {
			case 1:
				return "A";
			case 11:
				return "J";
			case 12:
				return "Q";
			case 13:
				return "K";
			default:
				return String.valueOf(this.rank);
		}
	}

	public Card(Suit suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public int getRank() {
		return this.rank;
	}
	
	public int getPoint() {
		if (this.rank > 10) {
			return 10;
		} else {
			return this.rank;
		}
	}
	public String toString() {
		return suit.getMark() + "‚Ì" + toDisplayValue();
	}
}