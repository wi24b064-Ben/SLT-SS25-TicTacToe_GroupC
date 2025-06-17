package org.example;


import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        // Spieler und Brett initialisieren, Startspieler festlegen
        board = new Board();
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
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


            }


    }

    private void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }}
