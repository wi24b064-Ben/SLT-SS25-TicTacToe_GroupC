package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    private TicTacToe game;

    @BeforeEach
    void setUp() {
        game = new TicTacToe();
    }

    @Test
    void testInitialCurrentPlayer() throws Exception {
        Field currentPlayerField = TicTacToe.class.getDeclaredField("currentPlayer");
        currentPlayerField.setAccessible(true);
        Player current = (Player) currentPlayerField.get(game);
        assertEquals('X', current.getMarker());
    }

    @Test
    void testSwitchCurrentPlayer() throws Exception {
        Field currentPlayerField = TicTacToe.class.getDeclaredField("currentPlayer");
        currentPlayerField.setAccessible(true);
        Method switchMethod = TicTacToe.class.getDeclaredMethod("switchCurrentPlayer");
        switchMethod.setAccessible(true);

        Player before = (Player) currentPlayerField.get(game);
        switchMethod.invoke(game);
        Player after = (Player) currentPlayerField.get(game);

        assertNotEquals(before.getMarker(), after.getMarker());
    }
}
