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
}
