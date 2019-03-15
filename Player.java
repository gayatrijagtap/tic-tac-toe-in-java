package tic_tac_toe;

import java.util.ArrayList;

public class Player {
    private String name;
    private char symbol;
    private ArrayList<Integer> moves;

    public Player(String name,char symbol) {
        this.name = name;
        this.symbol = symbol;
        this.moves = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getMoves() {
        return moves;
    }

    public void makeMove(int move) {
        this.moves.add(move);
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean hasWinningCombinations(ArrayList<Integer> combination) {
        return this.getMoves().containsAll(combination);
    }
}