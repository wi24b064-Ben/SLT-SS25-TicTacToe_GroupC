package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testGetMarkerX() {
        Player player = new Player('X');
        assertEquals('X', player.getMarker());
    }

    @Test
    void testGetMarkerO() {
        Player player = new Player('O');
        assertEquals('O', player.getMarker());
    }

}
