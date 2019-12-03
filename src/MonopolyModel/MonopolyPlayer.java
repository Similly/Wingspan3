package MonopolyModel;

import GameFramework.Player;

import java.util.ArrayList;

public class MonopolyPlayer extends Player{

	private int money;
	private ArrayList<MonopolyCard> cards;
	
	public MonopolyPlayer(int id) {
		super(id);
		this.money = 2000;
		this.cards = new ArrayList<>();
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public ArrayList<MonopolyCard> getCards() {
		return cards;
	}

	public void setCards(ArrayList<MonopolyCard> cards) {
		this.cards = cards;
	}

	public void addCard(MonopolyCard card) {
		cards.add(card);
	}
}
