package GameFramework;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class CardStack {
    private ArrayList<Card> cards;

    public CardStack(){
        this.cards = new ArrayList<>();
    }

    public CardStack(ArrayList<Card> cards){
        this.cards = cards;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public void deleteCard(Card card){
        cards.remove(card);
    }

    public void deleteCard(int index){
        cards.remove(index);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Card getRandomCard(){
        Random r = new Random();
        int index = r.nextInt(cards.size());
        Card card = cards.get(index);
        cards.remove(index);
        return card;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardStack cardStack = (CardStack) o;
        return Objects.equals(cards, cardStack.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }

    @Override
    public String toString() {
        return "CardStack{" +
                "cards=" + cards +
                '}';
    }
}
