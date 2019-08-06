package blackjack.human;

import blackjack.tramp.*;
import java.util.ArrayList;

public abstract class Human {
	// 名前を持っている
	private String name;
	// 手札を持っている
	private Hand hand;
	// バーストしているかどうか
	private boolean bust;

	// コンストラクタ
	public Human(String name) {
		this.name = name;
		this.hand = new Hand();
	}

	// toString
	public String toString() {
		return this.name;
	}

	public String getName() {
		return this.name;
	}

	public Hand getHand() {
		return this.hand;
	}

	public boolean getBust() {
		return this.bust;
	}

	public void setBust(boolean check) {
		this.bust = check;
	}

	// カードを引くかどうか宣言する
	public abstract boolean askToHit();

	// カードを引く
	public void draw(Card card) {
		hand.add(card);
	}

	// メッセージの表示
	public void message(String text) {
		System.out.println(text);
	}

	// 手札とポイントの開示
	public void showHave() {
		message(getName() + " の手札は " + getHand().toString() + " です");
		message(getName() + " の得点は " + calcScore() + " 点です");
	}

	// ポイント計算
	public int calcScore() {
		int score = hand.getPoints();
		return score;
	}

	// バーストしてるかの計算
	public boolean isBust() {
		if (calcScore() > 21){
			return true;
		} else {
			return false;
		}
	}
}