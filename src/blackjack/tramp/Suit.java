package blackjack.tramp;

public enum Suit {
	SPADE("�X�y�[�h"),
	CLUB("�N���u"),
	HEART("�n�[�g"),
	DIAMOND("�_�C��");

	private String mark;

	Suit(String mark) {
		this.mark = mark;
	}
	public String getMark() {
		return this.mark;
	}
}