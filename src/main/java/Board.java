import java.util.HashMap;
import java.util.Map;

public class Board {

    private HashMap<Integer, Integer> playerPositions;
    private int currentPlayer;
    final int _maximumPointsInOneTurn = 12;

    public Board() {
        playerPositions = new HashMap<Integer, Integer>() {{
            put(1, 0);
            put(2, 0);
        }};
        currentPlayer = 1;
    }

    public int position(int player) {
        return playerPositions.get(player);
    }

    public String play(int dice1, int dice2) {
        final int newPosition = getNewPosition(dice1, dice2);

        playerPositions.replace(currentPlayer, newPosition);

        final String message = String.format("Player %s is on square %s", currentPlayer, newPosition);

        decideNextPlayer(dice1 + dice2);

        return message;
    }

    private int getNewPosition(int dice1, int dice2) {
        final Integer currentPosition = playerPositions.get(currentPlayer);
        return currentPosition + dice1 + dice2;
    }

    private void decideNextPlayer(int totalpoints) {
        if(totalpoints == _maximumPointsInOneTurn)
            return;
        else
            currentPlayer = currentPlayer == 1 ? 2 : 1;
    }
}
