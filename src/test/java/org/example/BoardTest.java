package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BoardTest {

    @Test
        // positive + edge case
    void isCellEmpty() {
        Board board = new Board();
        assertTrue(board.isCellEmpty(2, 2)); // size = 3;
    }

    @Test
    void isCellNotEmpty() { // negative case
        Board board = new Board();
        board.place(1, 1, 'X');
        assertFalse(board.isCellEmpty(1, 1));
    }


    @Test
    void isFull() { // positive case
        Board board = new Board();
        for (int i = 0; i < 3; i++) { // Brett befüllen
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    void isNotFull() { // negative case
        Board board = new Board();
        for (int i = 0; i < 3; i++) { // Brett befüllen, außer bei (2,2)
            for (int j = 0; j < 3; j++) {
                if (!(i == 2 && j == 2)) board.place(i, j, 'X');
            }
        }
        assertFalse(board.isFull());
    }

    @Test
    void isClear() { // positive case, clear ist parameterlose void Methode, also kein negative case zum Testen
        Board board = new Board();
        for (int i = 0; i < 3; i++) { // Brett befüllen
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        board.clear(); // Brett leeren
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(board.isCellEmpty(i, j)); // assert, dass alle Zellen leer sind
            }
        }
    }


    @Test
    void testGetCell() {
        Board board = new Board();
        assertEquals(' ', board.getCell(0, 0)); // Nach dem initialisieren leer
        board.place(1, 1, 'X');
        assertEquals('X', board.getCell(1, 1)); // Nach board.place
    }
}