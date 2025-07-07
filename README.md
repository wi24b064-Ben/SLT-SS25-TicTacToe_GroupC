# Tic-Tac-Toe Game

A simple Tic-Tac-Toe written in Java using Maven. This project served as a means to learn the stages of a full software cycle.

## User Stories

- **1:** As a player, I want to be able to make a move by choosing an empty square, so that I can place my symbol on the board.
- **2:** As a player, I want to be able to see the current state of the game, so that I can keep track of the moves made by both myself and my opponent.
- **3:** As a player, I want to be notified when the game has ended in a win, loss or draw, so that I can see the result of the game.
- **4:** As a player, I want to be able to start a new game after the current game has ended, so that I can play again.

The user stories are more detailed in the Kanban board.

## CI/CD

Every pull request triggers automated unit tests. Merging to `main` uses Maven to create a downloadable .jar artifact.

## Setup

### Requirements
- Java 21 or higher
- Maven 3.8 or higher
- Git (latest recommended)

### Build & Run

```bash
git clone https://github.com/your-username/tic-tac-toe.git
cd tic-tac-toe
mvn clean install
java -jar target/tic-tac-toe-1.0.jar
