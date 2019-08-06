package blackjack.human;

import blackjack.tramp.*;
import java.util.Scanner;

public class Player extends Human {
	private Scanner scanner = new Scanner(System.in);

	public Player(String name) {
		super(name);
	}
	
	public boolean askToHit() {
		while(!isBust()) {
			message(getName() + "の番です。");
			showHave();
			message("ヒットしますか？する場合はYを、しない場合はNを入力してください");

			String ans = scanner.next();

			if (ans.equals("Y")) {
				return true;
			} else if (ans.equals("N")){
				return false;
			} else {
				message("Y/N以外が入力されました");
				continue;
			}
		} 
		return false;
	}

	public void play(Dealer dealer) {
		while(true) {
			
			if (askToHit()) {
					// Hitの場合
					dealer.dealCard(this);
					message("");
				} else if(isBust()){
					// Burstした場合
					showHave();
					setBust(true);
					message("--------" + getName() + "はバストしました--------");
					message("次のプレイヤーに番が回ります。");
					message("");
					break;
				} else {
					// Standの場合
					setBust(false);
					message(getName() + "はStandしました");
					message("次のプレイヤーに番が回ります");
					message("");
					break;
				}
		}
	}

}