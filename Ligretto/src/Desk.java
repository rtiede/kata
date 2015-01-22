import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ralph on 11.01.2015.
 */
public class Desk {
    List<CardStack> cardStacks = new ArrayList<CardStack>();
    private Integer playerWins = 0;


    public void addCardStack(Card card) {
        synchronized (cardStacks) {
            CardStack cardStack = new CardStack(cardStacks.size());
            cardStack.addCard(card);
            cardStacks.add(cardStack);
        }
    }

    public int numberOfCardStacks() {
        return cardStacks.size();
    }

    public CardStack getCardStack(int i) {
        return cardStacks.get(i);
    }

    public void win(int playerNumber) {
        synchronized (playerWins) {
            if (playerWins == 0) {
                playerWins = playerNumber;
            }
        }
    }

    public boolean didSomeBodyWin() {
        return playerWins != 0;
    }

    public Integer getPlayerWins() {
        return playerWins;
    }
}
