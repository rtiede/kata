/**
 * Created by Ralph on 11.01.2015.
 */
public class Card {
    final int color;
    final int value;

    public Card(int color, int value) {
        this.color = color;
        this.value = value;
    }

    public int getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "color=" + color +
                ", value=" + value +
                '}';
    }
}
