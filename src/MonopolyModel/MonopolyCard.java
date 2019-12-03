package MonopolyModel;

import GameFramework.Card;

public class MonopolyCard extends Card {
	private String color;
	private int cost;
	private MonopolyPlayer player;
	
	public MonopolyCard() {
		super();
	}
	
	public MonopolyCard(int id, String name, int score, String c, MonopolyPlayer p) {
		super(id, name, score);
		this.color = c;
		this.player = p;
		this.cost = 500;
	}

	public int getCardId() {
        return getId();
    }

    public void setCardId(int id) {
        setId(id);
    }

    public String getCardName() {
        return getName();
    }

    public void setCardName(String name) {
        setName(name);
    }
    
    public int getCardScore() { 
    	return getScore(); 
    }

    public void setCardScore(int score) { 
    	setScore(score); 
    }
    public MonopolyPlayer getCardPlayer() {
        return player;
    }

    public void setCardPlayer(MonopolyPlayer p) {
        this.player=p;
    }

    public String getCardColor() { return color; }

    public void setCardColor(String c) {
        this.color=c;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
