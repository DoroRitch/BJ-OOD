package blackjack.human;

import blackjack.tramp.*;
import java.util.ArrayList;

public abstract class Human {
	// ���O�������Ă���
	private String name;
	// ��D�������Ă���
	private Hand hand;
	// �o�[�X�g���Ă��邩�ǂ���
	private boolean bust;

	// �R���X�g���N�^
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

	// �J�[�h���������ǂ����錾����
	public abstract boolean askToHit();

	// �J�[�h������
	public void draw(Card card) {
		hand.add(card);
	}

	// ���b�Z�[�W�̕\��
	public void message(String text) {
		System.out.println(text);
	}

	// ��D�ƃ|�C���g�̊J��
	public void showHave() {
		message(getName() + " �̎�D�� " + getHand().toString() + " �ł�");
		message(getName() + " �̓��_�� " + calcScore() + " �_�ł�");
	}

	// �|�C���g�v�Z
	public int calcScore() {
		int score = hand.getPoints();
		return score;
	}

	// �o�[�X�g���Ă邩�̌v�Z
	public boolean isBust() {
		if (calcScore() > 21){
			return true;
		} else {
			return false;
		}
	}
}