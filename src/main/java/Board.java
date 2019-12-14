import java.util.HashMap;

public class Board {

    private HashMap<Integer, Integer> playerPositions;
    private int currentPlayer;
    private HashMap<Integer, Integer> hops;
    private int _maxNumberOfSquares;

    public Board() {
        _maxNumberOfSquares = 100;

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

        if (gameOver())
            return "Game over!";

        final int newPosition = getNewPosition(die1, die2);

        updateCurrentPlayerPosition(newPosition);

        if(hasCurrentPlayerWon(newPosition))
            return String.format("Player %s wins!", currentPlayer);

        final String message = String.format("Player %s is on square %s", currentPlayer, newPosition);

        decideNextPlayer(die1 , die2);

        return message;
    }

    private boolean hasCurrentPlayerWon(int newPosition) {
        return newPosition == _maxNumberOfSquares;
    }

    private void updateCurrentPlayerPosition(int newPosition) {
        playerPositions.replace(currentPlayer, newPosition);
    }

    private boolean gameOver() {
        final boolean player1HasAlreadyWon = playerPositions.get(1) == _maxNumberOfSquares;
        final boolean player2HasAlreadyWon = playerPositions.get(2) == _maxNumberOfSquares;

        if(player1HasAlreadyWon || player2HasAlreadyWon)
            return true;

        return false;
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
        else {
            toggleCurrentPlayer();
        }
    }

    private void toggleCurrentPlayer() {
        currentPlayer = currentPlayer == 1 ? 2 : 1;
    }
}
