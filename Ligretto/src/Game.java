import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ralph on 11.01.2015.
 */
public class Game {
    Desk desk = new Desk();
    List<Player> players = new ArrayList<Player>();
    List<PlayerActivity> playerActivities = new ArrayList<PlayerActivity>();

    public Game(int numberOfPlayers) {
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(i+1));
        }

    }

    public void run() {
        for (Player player : players) {
             playerActivities.add(new PlayerActivity(player, desk));
        }
        for (PlayerActivity playerActivity : playerActivities) {
            playerActivity.start();
        }

        for (PlayerActivity playerActivity : playerActivities) {
            try {
                playerActivity.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Player "+desk.getPlayerWins()+" wins");

        for (Player player : players) {
            if (!player.getHand().isEmpty()) {
                System.out.println("Player " + player.getPlayerNumber() + " has " + player.getHand().getSize() + " cards left");

            }
        }

        //join();
//        notifyAll();
    }
}
