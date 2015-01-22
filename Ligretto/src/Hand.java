import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ralph on 11.01.2015.
 */
public class Hand {
    List<Card> cards = new ArrayList<Card>();

    public Hand() {
        for (int color = 1; color <= 4; color++) {
            for (int value = 1; value <= 10; value++ ) {
                cards.add(new Card(color,value));
            }
        }
        Collections.shuffle(cards);
    }

    public boolean isEmpty() {
        return cards.size() == 0;
    }

    public Card takeCard() {
        if (isEmpty())
            return null;
        else
            return cards.remove(0);
    }

    public void pushBack(Card card) {
        cards.add(card);
    }

    public int getSize() {
        return cards.size();
    }
}
