import java.util.HashMap;
import java.util.Map;

public class Board {

    private HashMap<Integer, Integer> playerPositions;
    private int currentPlayer;
    final int _maximumPointsInOneTurn = 12;
    private HashMap<Integer, Integer> hops;

    public Board() {
        playerPositions = new HashMap<Integer, Integer>() {{
            put(1, 0);
            put(2, 0);
        }};

        currentPlayer = 1;

        hops = new HashMap<Integer, Integer>() {{
            // ladders
            put(2, 38);
            put(7, 14);
            put(8, 31);
            put(15, 26);
            put(21, 42);
            put(28, 84);
            put(36, 44);
            put(51, 67);
            put(71, 91);
            put(78, 98);
            put(87, 94);

            // snakes
            put(16, 6);
            put(46, 25);
            put(49, 11);
            put(62, 19);
            put(64, 60);
            put(74, 53);
            put(89, 68);
            put(92, 88);
            put(95, 75);
            put(99, 80);
        }};
    }

    public int position(int player) {
        return playerPositions.get(player);
    }

    public String play(int die1, int die2) {

        final int newPosition = getNewPosition(die1, die2);

        playerPositions.replace(currentPlayer, newPosition);

        final String message = String.format("Player %s is on square %s", currentPlayer, newPosition);

        decideNextPlayer(die1 , die2);

        return message;
    }

    private int getNewPosition(int dice1, int dice2) {
        final Integer currentPosition = playerPositions.get(currentPlayer);

        int newPosition = currentPosition + dice1 + dice2;

        if(newPosition > 100)
            newPosition = 100 - (newPosition - 100);

        if(hops.get(newPosition) != null)
            return hops.get(newPosition);

        return newPosition;
    }

    private void decideNextPlayer(int die1, int die2) {
        if(die1 == die2)
            return;
        else
            currentPlayer = currentPlayer == 1 ? 2 : 1;
    }
}
