package blackjack.tramp;

public enum Suit {
	SPADE("スペード"),
	CLUB("クラブ"),
	HEART("ハート"),
	DIAMOND("ダイヤ");

	private String mark;

	Suit(String mark) {
		this.mark = mark;
	}
	public String getMark() {
		return this.mark;
	}
}