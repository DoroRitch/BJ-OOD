package blackjack.human;

import blackjack.tramp.*;

public class Dealer extends Human {
	private Deck bills = new Deck();

	public Dealer(String name, Deck deck) {
		super(name);
		this.bills = deck;
	}

	public void firstDealToDealer() {
		// �f�B�[���[�ɃJ�[�h��2���z��
		dealFirstCard(this);
		dealFirstCard(this);
		// �f�B�[���[�̃J�[�h��1�������\��
		message(getName() + " �̎�D�� " + getHand().firstCard() + " �Ƃ����ꖇ�͓���");
		message("");
	}

	public void firstDealToPlayer(Player player) {
		dealFirstCard(player);
		dealFirstCard(player);
		player.showHave();
		message("");
	}

	// ������D�Ƃ��ăJ�[�h���������߈������J�[�h���J�����Ȃ�
	public void dealFirstCard(Human player) {
		Card card = bills.getTop();
		player.draw(card);
		bills.remove();
	}

	// play()���\�b�h�ŃJ�[�h���������߈������J�[�h���J������
	public void dealCard(Human player) {
		Card card = bills.getTop();
		player.draw(card);
		message("�������J�[�h�́@" + card.toString() + "�@�ł�");
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
				// Burst�����Ƃ�
				setBust(true);
				message(getName() + "���o�X�g���܂����B");
				message("");
				break;
			} else {
				// 17�ȏ�ɂȂ����Ƃ�
				setBust(false);
				message(getName() + "��Stand���܂����B����Ɉڂ�܂��B");
				message("");
				break;
			}
		}
	}

	public void judge(Player player, Dealer dealer) {
		message("--------" + player.getName() + " vs " + dealer.getName() + "--------");

		if (!dealer.getBust()) {
			// �f�B�[���[���o�X�g���Ă��Ȃ��ꍇ

			if (!player.getBust()) {
				// �v���C���[���o�X�g���Ă��Ȃ��ꍇ

				if (player.calcScore() >= dealer.calcScore()) {
					message(player.getName() + "�̏����ł��B");
				} else {
					message(dealer.getName() + "�̏����ł��B");
				}

			} else {
				message(dealer.getName() + "�̏����ł��B");
			}

		} else if (!player.getBust()){
			// �f�B�[���[���o�X�g���Ă��ăv���C���[���o�X�g���Ă��Ȃ��ꍇ
			message(player.getName() + "�̏����ł�");
		} else {
			// �f�B�[���[���v���C���[���o�X�g���Ă����ꍇ
			message(dealer.getName() + "�̏����ł�");
		}

		message("�܂��V��łˁI");
		message("");
	}
}