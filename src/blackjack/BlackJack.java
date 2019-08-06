package blackjack;

import blackjack.human.*;
import blackjack.tramp.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class BlackJack {
	private Scanner scanner = new Scanner(System.in);
	// ���l�v���C���邩��ێ����郊�X�g
	private List<String> humans = new ArrayList<String>();
	// ���ۂ̃C���X�^���X��ێ����郊�X�g
	private List<Player> players = new ArrayList<Player>();

	public void game() {	

		// �����l�v���C�ɑΉ�
		countPlayer();	

		// �R�D�C���X�^���X�ƃf�B�[���[�C���X�^���X�̐���
		Deck deck = new Deck();
		Dealer dealer = new Dealer("�f�B�[���[", deck);

		// �l�����C���X�^���X�𐶐�
		for (int itr = 0; itr < humans.size(); itr++){
			Player player = new Player(humans.get(itr));
			players.add(player);			
		}
		System.out.println("");

		// �f�B�[���[�̏�����D
		dealer.firstDealToDealer();

		// �l����������D��z��
		for (int itr = 0; itr < players.size(); itr++){
			dealer.firstDealToPlayer(players.get(itr));
		}

		// �v���C���[�����̔�
		for (int itr = 0;itr < players.size(); itr++){
			players.get(itr).play(dealer);

			if(itr == players.size() - 1) {
				System.out.println("���Ƀv���C���[���c���Ă��Ȃ����߁A�f�B�[���[�̔ԂɂȂ�܂�");
			}
			
		}

		// �f�B�[���[�̔�
		dealer.play();

		// ����
		for (int itr = 0; itr < players.size(); itr++) {
			dealer.judge(players.get(itr), dealer);
		}
	}

	public void countPlayer() {
		System.out.print("�v���C����l������͂��Ă���������");
		int human = scanner.nextInt();

		for (int itr = 0; itr < human; itr++){
			System.out.print("�v���C����l�̖��O����l�����͂��Ă���������");
			String name = scanner.next();
			humans.add(name);
		}
	}

}