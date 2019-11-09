package Test;

import Controller.Main;
import Model.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PlayerTest {

    @Before
    public void setUp() throws Exception {
        Main.initBirds();
    }

    @Test
    public void drawBird() {
        Player player = new Player(1);
        int expected = 4;

        player.drawBird();

        assertEquals(expected,player.getBirds().size());
    }

    @Test
    public void getAvailableMoves() {
        Player player = new Player(1);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("1: place bird");
        expected.add("2: gain food");
        expected.add("3: lay eggs");
        expected.add("4: draw bird card");

        assertEquals(expected, player.getAvailableMoves());
    }

    @After
    public void tearDown(){
        Main.initBirds();
    }
}