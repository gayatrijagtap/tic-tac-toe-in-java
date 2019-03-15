package tic_tac_toe;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class Game {
    private ArrayList<ArrayList<Integer>> winningCombinations;
    private Player currentPlayer;
    private Player player1;
    private Player player2;
    private ArrayList<Integer> remainingMoves;
    private char[] gameMoves;

    public Game(String player1, String player2) {
        this.winningCombinations = createWinningCombinations();

        this.player1 = new Player(player1, 'O');
        this.player2 = new Player(player2, 'X');
        this.currentPlayer = this.player1;

        this.remainingMoves = new ArrayList<>(new ArrayList<>(asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        this.gameMoves = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    }

    private ArrayList<ArrayList<Integer>> createWinningCombinations() {
        ArrayList<ArrayList<Integer>> winningCombinations = new ArrayList<>();
        winningCombinations.add(new ArrayList<>(asList(1, 2, 3)));
        winningCombinations.add(new ArrayList<>(asList(4, 5, 6)));
        winningCombinations.add(new ArrayList<>(asList(7, 8, 9)));
        winningCombinations.add(new ArrayList<>(asList(1, 4, 7)));
        winningCombinations.add(new ArrayList<>(asList(2, 5, 8)));
        winningCombinations.add(new ArrayList<>(asList(3, 6, 9)));
        winningCombinations.add(new ArrayList<>(asList(1, 5, 9)));
        winningCombinations.add(new ArrayList<>(asList(3, 5, 7)));
        return winningCombinations;
    }


    public void makeMove(int move) {
//        this.remainingMoves.remove(move);
        this.currentPlayer.makeMove(move);
        this.gameMoves[move - 1] = this.currentPlayer.getSymbol();
    }

    public void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public boolean hasWon() {
        for (ArrayList<Integer> combination : winningCombinations) {
            if (this.currentPlayer.hasWinningCombinations(combination)) {
                return true;
            }
        }
        return false;
    }

    public String getCurrentPlayer() {
        return this.currentPlayer.getName();
    }

    public String createGameBoard() {
        String s = "|";
        int count = 0;
        for (char gameMove: gameMoves) {
            if(count>=3) {
                s += "\n|";
                count = 0;
            }
            s += gameMove+"|";
            count++;

        }
        return s;
    }
}