package org.example;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicTacToeTest {

    private TicTacToe game;
    private Field currentPlayerField;
    private Field boardField;

    @BeforeEach
    void setUp() throws Exception {
        game = new TicTacToe();
        currentPlayerField = TicTacToe.class.getDeclaredField("currentPlayer");
        currentPlayerField.setAccessible(true);
        boardField = TicTacToe.class.getDeclaredField("board");
        boardField.setAccessible(true);
    }

    // switchCurrentPlayer()
    @Test
    void testInitialCurrentPlayerIsX() throws Exception {
        Player current = (Player) currentPlayerField.get(game);
        assertEquals('X', current.getMarker());
    }

    @Test
    void testSwitchCurrentPlayerOnceChangesToO() throws Exception {
        Method switchMethod = TicTacToe.class.getDeclaredMethod("switchCurrentPlayer");
        switchMethod.setAccessible(true);
        switchMethod.invoke(game);
        Player after = (Player) currentPlayerField.get(game);
        assertEquals('O', after.getMarker());
    }

    @Test
    void testSwitchCurrentPlayerTwiceReturnsToX() throws Exception {
        Method switchMethod = TicTacToe.class.getDeclaredMethod("switchCurrentPlayer");
        switchMethod.setAccessible(true);
        switchMethod.invoke(game);
        switchMethod.invoke(game);
        Player after = (Player) currentPlayerField.get(game);
        assertEquals('X', after.getMarker());
    }

    @Test
    void testSwitchCurrentPlayer_MultipleCycles() throws Exception {
        Method switchMethod = TicTacToe.class.getDeclaredMethod("switchCurrentPlayer");
        switchMethod.setAccessible(true);
        // Fünf Mal schalten: X→O→X→O→X→O
        for (int i = 0; i < 5; i++) {
            switchMethod.invoke(game);
        }
        Player after = (Player) currentPlayerField.get(game);
        assertEquals('O', after.getMarker());
    }

    // hasWinner()
    @Test
    void testHasWinner_EmptyBoardReturnsFalse() throws Exception {
        Method hasWinner = TicTacToe.class.getDeclaredMethod("hasWinner");
        hasWinner.setAccessible(true);
        assertFalse((boolean) hasWinner.invoke(game));
    }

    @Test
    void testHasWinner_RowWinReturnsTrue() throws Exception {
        // Board holen und drei in Reihe setzen
        Board board = (Board) boardField.get(game);
        board.place(1, 0, 'X');
        board.place(1, 1, 'X');
        board.place(1, 2, 'X');
        Method hasWinner = TicTacToe.class.getDeclaredMethod("hasWinner");
        hasWinner.setAccessible(true);
        assertTrue((boolean) hasWinner.invoke(game));
    }

    @Test
    void testHasWinner_ColumnWinReturnsTrue() throws Exception {
        Board board = (Board) boardField.get(game);
        board.place(0, 2, 'X');
        board.place(1, 2, 'X');
        board.place(2, 2, 'X');
        Method hasWinner = TicTacToe.class.getDeclaredMethod("hasWinner");
        hasWinner.setAccessible(true);
        assertTrue((boolean) hasWinner.invoke(game));
    }

    @Test
    void testHasWinner_DiagonalWinReturnsTrue() throws Exception {
        Board board = (Board) boardField.get(game);
        board.place(0, 0, 'X');
        board.place(1, 1, 'X');
        board.place(2, 2, 'X');
        Method hasWinner = TicTacToe.class.getDeclaredMethod("hasWinner");
        hasWinner.setAccessible(true);
        assertTrue((boolean) hasWinner.invoke(game));
    }

    @Test
    void testHasWinner_PartialLineReturnsFalse() throws Exception {
        Board board = (Board) boardField.get(game);
        board.place(2, 0, 'X');
        board.place(2, 1, 'X');
        // drittes Feld frei lassen
        Method hasWinner = TicTacToe.class.getDeclaredMethod("hasWinner");
        hasWinner.setAccessible(true);
        assertFalse((boolean) hasWinner.invoke(game));
    }
}
