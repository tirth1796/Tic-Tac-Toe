package com.tirthcshahgmail.tictactoe;

/**
 * Created by Tirth Shah on 10-05-2015.
 */
public class Computer {
    int row ,column;
    TicTacToeBoard ticTacToeBoard;
    protected char[][] board;

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public Computer(TicTacToeBoard ticTacToeBoard) {
        this.ticTacToeBoard = ticTacToeBoard;
        board = this.ticTacToeBoard.getBoard();
    }

    public boolean computerPlay() {
        return true;
    }
}
