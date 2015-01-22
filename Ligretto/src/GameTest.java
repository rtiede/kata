import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void testRun() throws Exception {
        Game game = new Game(3);
        game.run();
        assertEquals(12,game.desk.numberOfCardStacks());
    }
}