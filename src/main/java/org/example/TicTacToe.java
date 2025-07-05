package org.example;

import java.util.Scanner;

public class TicTacToe {
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final Board board;

    public TicTacToe() {
        // Spieler und Brett initialisieren, Startspieler festlegen
        board = new Board();
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;


        while (playAgain) {
            board.clear(); // Etwaiges vorheriges Board clearen
            System.out.println("Starting a new game of Tic-Tac-Toe!");
            board.print();

            // Spielschleife
            while (true) {
                // Spieler auffordern, einen Zug einzugeben
                System.out.println("Player " + currentPlayer.getMarker() + ", it's your turn.");
                int x, y;
                // Eingabe wiederholen, bis ein gültiger Zug erfolgt
                while (true) {
                    System.out.print("Enter row (0-2): ");
                    x = scanner.nextInt();
                    System.out.print("Enter column (0-2): ");
                    y = scanner.nextInt();
                    if (x < 0 || x > 2 || y < 0 || y > 2) {
                        System.out.println("Invalid coordinates! Please enter values between 0 and 2.");
                    } else if (!board.isCellEmpty(x, y)) {
                        System.out.println("That cell is already occupied. Try a different move.");
                    } else {
                        break;
                    }
                }
                // Zug ausführen und Brett anzeigen
                board.place(x, y, currentPlayer.getMarker());
                board.print();
                // Gewinnbedingung prüfen
                if (hasWinner()) {
                    System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                    break;
                }
                // Unentschieden prüfen (volles Board)
                if (board.isFull()) {
                    System.out.println("It's a draw!");
                    break;
                }
                // Spieler wechseln und nächste Runde
                switchCurrentPlayer();
            }
            System.out.print("Do you want to play again? (yes/no): ");
            String answer = scanner.next().trim().toLowerCase();
            playAgain = answer.equals("yes") || answer.equals("y"); // False returnen wenn nein
        }
        scanner.close();
    }

    private void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }
    private boolean hasWinner() {
        char m = currentPlayer.getMarker();
        // Reihen prüfen
        for (int i = 0; i < 3; i++) {
            if (board.getCell(i, 0) == m && board.getCell(i, 1) == m && board.getCell(i, 2) == m) {
                return true; // Wenn alle der selbe Spieler sind true returnen
            }
        }
        // Spalten prüfen
        for (int j = 0; j < 3; j++) {
            if (board.getCell(0, j) == m && board.getCell(1, j) == m && board.getCell(2, j) == m) {
                return true;
            }
        }
        // Diagonalen prüfen
        if (board.getCell(0, 0) == m && board.getCell(1, 1) == m && board.getCell(2, 2) == m) {
            return true;
        }
        if (board.getCell(0, 2) == m && board.getCell(1, 1) == m && board.getCell(2, 0) == m) {
            return true;
        }
        return false;
    }
}