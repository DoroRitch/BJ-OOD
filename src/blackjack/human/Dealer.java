package blackjack.human;

import blackjack.tramp.*;

public class Dealer extends Human {
	private Deck bills = new Deck();

	public Dealer(String name, Deck deck) {
		super(name);
		this.bills = deck;
	}

	public void firstDealToDealer() {
		// ディーラーにカードを2枚配る
		dealFirstCard(this);
		dealFirstCard(this);
		// ディーラーのカードは1枚だけ表示
		message(getName() + " の手札は " + getHand().firstCard() + " ともう一枚は内緒");
		message("");
	}

	public void firstDealToPlayer(Player player) {
		dealFirstCard(player);
		dealFirstCard(player);
		player.showHave();
		message("");
	}

	// 初期手札としてカードを引くため引いたカードを開示しない
	public void dealFirstCard(Human player) {
		Card card = bills.getTop();
		player.draw(card);
		bills.remove();
	}

	// play()メソッドでカードを引くため引いたカードを開示する
	public void dealCard(Human player) {
		Card card = bills.getTop();
		player.draw(card);
		message("引いたカードは　" + card.toString() + "　です");
		bills.remove();
	}

	public boolean askToHit() {
		return calcScore() < 17;
	}

	public void play() {
		while(true) {
			showHave();

			if (askToHit()) {
				dealCard(this);
				message("");
			} else if(isBust()) {
				// Burstしたとき
				setBust(true);
				message(getName() + "がバストしました。");
				message("");
				break;
			} else {
				// 17以上になったとき
				setBust(false);
				message(getName() + "がStandしました。判定に移ります。");
				message("");
				break;
			}
		}
	}

	public void judge(Player player, Dealer dealer) {
		message("--------" + player.getName() + " vs " + dealer.getName() + "--------");

		if (!dealer.getBust()) {
			// ディーラーがバストしていない場合

			if (!player.getBust()) {
				// プレイヤーがバストしていない場合

				if (player.calcScore() >= dealer.calcScore()) {
					message(player.getName() + "の勝利です。");
				} else {
					message(dealer.getName() + "の勝利です。");
				}

			} else {
				message(dealer.getName() + "の勝利です。");
			}

		} else if (!player.getBust()){
			// ディーラーがバストしていてプレイヤーがバストしていない場合
			message(player.getName() + "の勝利です");
		} else {
			// ディーラーもプレイヤーもバストしていた場合
			message(dealer.getName() + "の勝利です");
		}

		message("また遊んでね！");
		message("");
	}
}