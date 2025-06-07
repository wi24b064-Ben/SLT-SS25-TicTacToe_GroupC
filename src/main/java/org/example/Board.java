package org.example;

public class Board {
    private char[][] cells;
    private final int SIZE = 3;

    public Board() {
        cells = new char[SIZE][SIZE];
        // Alle Felder als leer (Leerzeichen) initialisieren
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == ' ';
    }

    public void place(int x, int y, char marker) {
        // Marker setzen, falls Feld frei ist
        if (cells[x][y] == ' ') {
            cells[x][y] = marker;
        }
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (cells[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void clear() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    public void print() {
        // Spaltennummern ausgeben
        System.out.println("     0   1   2  ");
        // Oberste Linie
        System.out.println("   |---|---|---|");
        for (int i = 0; i < SIZE; i++) {
            // Zeilennummer und linke Begrenzung ausgeben
            System.out.print(" " + i + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print("| " + cells[i][j] + " ");
            }
            System.out.println("|");
            // Trennlinie unter der Zeile
            System.out.println("   |---|---|---|");
        }
    }

    // Liefert den Inhalt eines Feldes (Symbol oder Leerzeichen)
    public char getCell(int x, int y) {
        return cells[x][y];
    }
}
