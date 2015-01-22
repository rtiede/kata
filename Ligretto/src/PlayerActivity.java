import java.util.List;

/**
 * Created by Ralph on 11.01.2015.
 */
public class PlayerActivity extends Thread {
    private Desk desk;
    private Player player;

    public PlayerActivity(Player player, Desk desk) {
        this.player = player;
        this.desk = desk;
    }

    @Override
    public void run() {
/*
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/
        while (!player.getHand().isEmpty() && !desk.didSomeBodyWin()) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Card card = player.getHand().takeCard();
            if (card.getValue() == 1) {
                desk.addCardStack(card);
                System.out.println("Player " + player.getPlayerNumber() + " placed " + card + " on new stack "+desk.numberOfCardStacks());
            }
            else {
                int numberOfCardStacks = desk.numberOfCardStacks();
                for (int i = 0; i < numberOfCardStacks; i++) {
                    CardStack cardStack = desk.getCardStack(i);
                    synchronized (cardStack) {
                        if (cardStack.getTopMostCard().getColor() == card.getColor() && cardStack.getTopMostCard().getValue() + 1 == card.getValue()) {
                            if (!desk.didSomeBodyWin()) {
                                cardStack.addCard(card);
                                System.out.println("Player " + player.getPlayerNumber() + " placed " + card + " on stack " + cardStack.getStackNumber());
                            }

                            card = null;
                            break;
                        }
                    }
                }
                if (card != null) {
                    player.getHand().pushBack(card);
                }
            }
        }
        desk.win(player.getPlayerNumber());
    }
}
