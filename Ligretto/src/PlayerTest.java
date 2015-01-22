import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testPlay() throws Exception {
        Desk desk = new Desk();
        Player player = new Player(1);
        PlayerActivity playerActivity = new PlayerActivity(player,desk);
        playerActivity.run();
        Assert.assertEquals(4,desk.numberOfCardStacks());
        for (int i = 0; i < desk.numberOfCardStacks(); i++) {
            CardStack cardStack = desk.getCardStack(i);
            assertEquals(10, cardStack.getTopMostCard().getValue());
        }

    }

    @Test
    public void testTwoPlayers() throws Exception {
        Desk desk = new Desk();
        Player player1 = new Player(1);
        PlayerActivity playerActivity1 = new PlayerActivity(player1,desk);
        playerActivity1.run();
        Player player2 = new Player(1);
        PlayerActivity playerActivity2 = new PlayerActivity(player2,desk);
        playerActivity2.run();
        Assert.assertEquals(8,desk.numberOfCardStacks());
        for (int i = 0; i < desk.numberOfCardStacks(); i++) {
            CardStack cardStack = desk.getCardStack(i);
            assertEquals(10, cardStack.getTopMostCard().getValue());
        }

    }
}