package blackjack;

import blackjack.human.*;
import blackjack.tramp.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class BlackJack {
	private Scanner scanner = new Scanner(System.in);
	// 何人プレイするかを保持するリスト
	private List<String> humans = new ArrayList<String>();
	// 実際のインスタンスを保持するリスト
	private List<Player> players = new ArrayList<Player>();

	public void game() {	

		// 複数人プレイに対応
		countPlayer();	

		// 山札インスタンスとディーラーインスタンスの生成
		Deck deck = new Deck();
		Dealer dealer = new Dealer("ディーラー", deck);

		// 人数分インスタンスを生成
		for (int itr = 0; itr < humans.size(); itr++){
			Player player = new Player(humans.get(itr));
			players.add(player);			
		}
		System.out.println("");

		// ディーラーの初期手札
		dealer.firstDealToDealer();

		// 人数分初期手札を配る
		for (int itr = 0; itr < players.size(); itr++){
			dealer.firstDealToPlayer(players.get(itr));
		}

		// プレイヤーたちの番
		for (int itr = 0;itr < players.size(); itr++){
			players.get(itr).play(dealer);

			if(itr == players.size() - 1) {
				System.out.println("他にプレイヤーが残っていないため、ディーラーの番になります");
			}
			
		}

		// ディーラーの番
		dealer.play();

		// 判定
		for (int itr = 0; itr < players.size(); itr++) {
			dealer.judge(players.get(itr), dealer);
		}
	}

	public void countPlayer() {
		System.out.print("プレイする人数を入力してください＞");
		int human = scanner.nextInt();

		for (int itr = 0; itr < human; itr++){
			System.out.print("プレイする人の名前を一人ずつ入力してください＞");
			String name = scanner.next();
			humans.add(name);
		}
	}

}