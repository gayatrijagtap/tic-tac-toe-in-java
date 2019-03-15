package tic_tac_toe;

import java.util.Scanner;

public class GameMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter player1 name:");
        String player1Name = scanner.next();

        System.out.println("Enter player2 name:");
        String player2Name = scanner.next();

        Game game = new Game(player1Name, player2Name);

        System.out.println(game.createGameBoard());

        int count = 9;
        while (count > 0) {
            System.out.println(game.getCurrentPlayer() + "'s turn");
            System.out.println("Play move:");
            int move = scanner.nextInt();
            game.makeMove(move);
            System.out.println(game.createGameBoard());
            System.out.println("game status:" + game.hasWon());
            if (game.hasWon()) {
                System.out.println(game.getCurrentPlayer() + " has won!!");
                break;
            }
            game.switchPlayer();
            count--;
        }
    }
}