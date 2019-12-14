import java.util.HashMap;
import java.util.Map;

public class Board {

    private HashMap<Integer, Integer> playerPositions;
    private int currentPlayer;
    final int _maximumPointsInOneTurn = 12;

    public Board() {
        playerPositions = new HashMap<Integer, Integer>() {{
            put(1, 1);
            put(2, 1);
        }};
        currentPlayer = 1;
    }

    public int position(int player) {
        return playerPositions.get(player);
    }

    public String play(int dice1, int dice2) {
        playerPositions.replace(currentPlayer, dice1 + dice2);

        final String message = String.format("Player %s is on square %s", currentPlayer, playerPositions.get(currentPlayer));

        decideNextPlayer(dice1 + dice2);

        return message;
    }

    private void decideNextPlayer(int totalpoints) {
        if(totalpoints == _maximumPointsInOneTurn)
            return;
        else
            currentPlayer = currentPlayer == 1 ? 2 : 1;
    }
}
