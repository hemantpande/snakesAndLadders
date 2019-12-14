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
    void let_Player2_Play_When_Player1_does_not_score_same_die() {
        Board board = new Board();

        assertAll(() -> assertEquals("Player 1 is on square 3", board.play(1, 2)),
                () -> assertEquals("Player 2 is on square 3", board.play(1, 2)));
    }

    @Test
    @DisplayName("Player 1 should play again when both dice are maximum")
    void let_Player1_Play_Again_When_same_die_Is_Scored() {
        Board board = new Board();

        assertAll(() -> assertEquals("Player 1 is on square 4", board.play(2, 2)),
                () -> assertEquals("Player 1 is on square 14", board.play(6, 4)));
    }

    @Test
    @DisplayName("Player 2 should play again when both dice are maximum")
    void let_Player2_Play_Again_When_same_die_Is_Scored() {
        Board board = new Board();

        assertAll(() -> assertEquals("Player 1 is on square 11", board.play(5, 6)),
                () -> assertEquals("Player 2 is on square 12", board.play(6, 6)),
                () -> assertEquals("Player 2 is on square 24", board.play(6, 6)));
    }

    @Test
    @DisplayName("Player 1 should take the ladder when encountered")
    void let_Player1_take_the_ladder_when_encountered() {
        Board board = new Board();

        assertEquals("Player 1 is on square 38", board.play(1, 1));
    }

    @Test
    @DisplayName("Player 1 bounces back when roll is high, near the finish line")
    void let_Player1_bounce_back_when_roll_is_too_high_near_the_finish_line() {
        Board board = new Board();

        assertAll(() -> assertEquals("Player 1 is on square 38", board.play(1, 1)),
                () -> assertEquals("Player 1 is on square 48", board.play(6, 4)),
                () -> assertEquals("Player 2 is on square 11", board.play(5, 6)),
                () -> assertEquals("Player 1 is on square 67", board.play(1, 2)),
                () -> assertEquals("Player 2 is on square 14", board.play(1, 2)),
                () -> assertEquals("Player 1 is on square 91", board.play(2, 2)),
                () -> assertEquals("Player 1 is on square 98", board.play(6, 5)));
    }

    @Test
    @DisplayName("Player 1 bounces back when roll is high, near the finish line, and gets a snake")
    void let_Player1_bounce_back_when_roll_is_too_high_near_the_finish_line_and_gets_a_snake() {
        Board board = new Board();

        assertAll(() -> assertEquals("Player 1 is on square 38", board.play(1, 1)),
                () -> assertEquals("Player 1 is on square 48", board.play(6, 4)),
                () -> assertEquals("Player 2 is on square 11", board.play(5, 6)),
                () -> assertEquals("Player 1 is on square 67", board.play(1, 2)),
                () -> assertEquals("Player 2 is on square 14", board.play(1, 2)),
                () -> assertEquals("Player 1 is on square 91", board.play(2, 2)),
                () -> assertEquals("Player 1 is on square 80", board.play(6, 4)));
    }

    @Test
    @DisplayName("Player 1 wins when exact number of required dice is scored")
    void let_Player1_win_when_exact_number_of_dice_is_scored() {
        Board board = new Board();

        assertAll(() -> assertEquals("Player 1 is on square 38", board.play(1, 1)),
                () -> assertEquals("Player 1 is on square 48", board.play(6, 4)),
                () -> assertEquals("Player 2 is on square 11", board.play(5, 6)),
                () -> assertEquals("Player 1 is on square 67", board.play(1, 2)),
                () -> assertEquals("Player 2 is on square 14", board.play(1, 2)),
                () -> assertEquals("Player 1 is on square 91", board.play(2, 2)),
                () -> assertEquals("Player 1 wins!", board.play(6, 3)));
    }
}
