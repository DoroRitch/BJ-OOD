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
			message(getName() + "�̔Ԃł��B");
			showHave();
			message("�q�b�g���܂����H����ꍇ��Y���A���Ȃ��ꍇ��N����͂��Ă�������");

			String ans = scanner.next();

			if (ans.equals("Y")) {
				return true;
			} else if (ans.equals("N")){
				return false;
			} else {
				message("Y/N�ȊO�����͂���܂���");
				continue;
			}
		} 
		return false;
	}

	public void play(Dealer dealer) {
		while(true) {
			
			if (askToHit()) {
					// Hit�̏ꍇ
					dealer.dealCard(this);
					message("");
				} else if(isBust()){
					// Burst�����ꍇ
					showHave();
					setBust(true);
					message("--------" + getName() + "�̓o�X�g���܂���--------");
					message("���̃v���C���[�ɔԂ����܂��B");
					message("");
					break;
				} else {
					// Stand�̏ꍇ
					setBust(false);
					message(getName() + "��Stand���܂���");
					message("���̃v���C���[�ɔԂ����܂�");
					message("");
					break;
				}
		}
	}

}