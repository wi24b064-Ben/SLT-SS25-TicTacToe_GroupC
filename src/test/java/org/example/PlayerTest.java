package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void testGetMarker_TypicalX() {
        Player p = new Player('X');
        assertEquals('X', p.getMarker());
    }

    @Test
    void testGetMarker_TypicalO() {
        Player p = new Player('O');
        assertEquals('O', p.getMarker());
    }

    @Test
    void testGetMarker_EdgeNumeric() {
        Player p = new Player('1');
        assertEquals('1', p.getMarker());
    }

    @Test
    void testGetMarker_EdgeSpecialChar() {
        Player p = new Player('#');
        assertEquals('#', p.getMarker());
    }
}
