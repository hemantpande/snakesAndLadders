import java.util.HashMap;
import java.util.Map;

public class Board {

    private HashMap<Integer, Integer> playerPositions;
    private int currentPlayer;

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
        return String.format("Player %s is on square %s", currentPlayer, playerPositions.get(currentPlayer));
    }
}
