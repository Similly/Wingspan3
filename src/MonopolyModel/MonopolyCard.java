package MonopolyModel;

import GameFramework.Card;

public class MonopolyCard extends Card {
	private String color;
	
	public MonopolyCard() {
		super();
	}
	
	public MonopolyCard(int id,String name, int score, String c) {
		super(id,name,score);
		this.color=c;
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
}
