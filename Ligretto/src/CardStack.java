import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ralph on 11.01.2015.
 */
public class CardStack {
    List<Card> cards = new ArrayList<Card>();
    int stackNumber;

    public CardStack(int stackNumber) {
        this.stackNumber = stackNumber;
    }

    boolean addCard(Card card) {
        if (cards.size() == 0) {
            if (card.getValue() == 1) {
                cards.add(card);
                return true;
            }

        }
        else {
            Card topMostCard = getTopMostCard();
            if (card.getColor() == topMostCard.getColor() && card.getValue() == topMostCard.getValue()+1) {
                cards.add(card);
                return true;
            }
        }
        return false;
    }

    public Card getTopMostCard() {
        if (cards.size() == 0)
            return null;
        else
            return cards.get(cards.size()-1);
    }

    public int getStackNumber() {
        return stackNumber;
    }
}
