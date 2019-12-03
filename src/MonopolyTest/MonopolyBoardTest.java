package MonopolyTest;

import MonopolyController.Main;
import MonopolyModel.MonopolyBoard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonopolyBoardTest {

    @Before
    public void setUp() throws Exception{

    }

    @Test
    public void spaceFree() {
        MonopolyBoard board = new MonopolyBoard(true);
        board.getBoard()[0][1].setCardId(-1);

        assertEquals(true, board.spacefree(0,1));
    }
}
