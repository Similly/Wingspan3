package MonopolyTest;

import GameFramework.Card;
import MonopolyModel.MonopolyCard;
import MonopolyModel.MonopolyPlayer;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MonopolyPlayerTest {

    @Test
    public void addCard() {
        MonopolyPlayer player = new MonopolyPlayer(0);

        ArrayList<MonopolyCard> cards = new ArrayList<>();

        MonopolyCard card = new MonopolyCard();

        cards.add(card);

        player.addCard(card);

        assertEquals(cards, player.getCards());
    }
}