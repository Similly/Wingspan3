package Test;

import Controller.Main;
import Model.Bird;
import Model.FoodTypes;
import Model.Habitats;
import Model.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

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

    //This test sometimes fails, because the player object is created with 3 random birds, so sometimes the start food is not enough to play any bird.
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

    @Test
    public void getAvailableBirds(){
        Player player = new Player(1);
        ArrayList<Bird> expectedBirds = new ArrayList<>();
        HashMap<FoodTypes, Integer> food = new HashMap<>();
        food.put(FoodTypes.Seed, 1);
        ArrayList<Habitats> habitats = new ArrayList<>();
        habitats.add(Habitats.Forrest);

        Bird bird = new Bird(0, 1 , "Bird1", 4, 2, food, habitats);

        ArrayList<Bird> birds = player.getBirds();
        while (birds.size() > 0){
            birds.remove(0);
        }

        expectedBirds.add(bird);
        birds.add(bird);

        player.setBirds(birds);

        assertEquals(expectedBirds, player.getAvailableBirds());
    }

    @Test
    public void layEggs(){

    }

    @After
    public void tearDown(){
        Main.initBirds();
    }
}