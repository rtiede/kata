/**
 * Created by Ralph on 11.01.2015.
 */
public class Player {
    private final int playerNumber;
    private final Hand hand = new Hand();

    public int getPlayerNumber() {
        return playerNumber;
    }

    public Hand getHand() {
        return hand;
    }

    public Player(int playerNumber) {
        this.playerNumber = playerNumber;
    }
}
