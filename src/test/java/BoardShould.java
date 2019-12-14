import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardShould {

    @Test
    @DisplayName("Both players start at default position")
    void make_Both_Players_Start_At_Default_Position() {
        Board board = new Board();

        assertAll(() -> assertEquals(0, board.position(1)),
                  () -> assertEquals(0, board.position(2)));
    }

    @Test
    @DisplayName("Player 1 should make a normal move")
    void let_Player1_Make_The_First_Move() {
        Board board = new Board();

        assertEquals("Player 1 is on square 3", board.play(1, 2));
    }


    @Test
    @DisplayName("Player 2 should play after player 1 when both dice are not maximum")
    void let_Player2_Play_When_Both_Dice_Are_Not_Maximum() {
        Board board = new Board();

        assertAll(() -> assertEquals("Player 1 is on square 3", board.play(1, 2)),
                  () -> assertEquals("Player 2 is on square 3", board.play(1,2)));
    }


    @Test
    @DisplayName("Player 1 should play again when both dice are maximum")
    void let_Player1_Play_Again_When_Maximum_Is_Scored() {
        Board board = new Board();

        assertAll(() -> assertEquals("Player 1 is on square 12", board.play(6, 6)),
                () -> assertEquals("Player 1 is on square 24", board.play(6, 6)));
    }

    @Test
    @DisplayName("Player 2 should play again when both dice are maximum")
    void let_Player2_Play_Again_When_Maximum_Is_Scored() {
        Board board = new Board();

        assertAll(() -> assertEquals("Player 1 is on square 11", board.play(5, 6)),
                () -> assertEquals("Player 2 is on square 12", board.play(6, 6)),
                () -> assertEquals("Player 2 is on square 24", board.play(6, 6)));
    }
}
