import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardShould {

    @Test
    @DisplayName("Both players start at square 1")
    void makeBothPlayersStartAtDefaultPosition() {
        Board board = new Board();

        assertAll(() -> assertEquals(1, board.position(1)),
                () -> assertEquals(1, board.position(2)));
    }

    @Test
    void letPlayer1MakeTheFirstMove() {
        Board board = new Board();

        assertEquals("Player 1 is on square 3", board.play(1, 2));
    }
}
