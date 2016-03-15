package com.tirthcshahgmail.tictactoe;

/**
 * Created by Tirth Shah on 10-05-2015.
 */
public class UnbeatableComputer extends Computer {

    public UnbeatableComputer(TicTacToeBoard ticTacToeBoard) {
        super(ticTacToeBoard);
    }

    public boolean computerPlay() {
        minimmax(board, false, 0);
        boolean win =ticTacToeBoard.setBoard(board);
        return win;
    }

    private int minimmax(char[][] board, boolean userTurn, int depth) {
        depth++;
        int row = 0, column = 0;
        int utility;
        int temp;
        if (userTurn) {
            utility = -10;
            if (TicTacToeBoard.checkWin(board, ticTacToeBoard.getComputer()))
                return -10 ;
            else if (TicTacToeBoard.checkDraw(board))
                return 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == '-') {
                        char[][] clone = TicTacToeBoard.arrayClone(board);
                        clone[i][j] = ticTacToeBoard.getUser();
                        temp = minimmax(clone, false, depth);
                        if (utility <= temp) {
                            utility=temp;
                            row = i;
                            column = j;

                        }
                    }
                }
            }
            board[row][column] = ticTacToeBoard.getUser();
        } else {
            utility = 10;
            if (TicTacToeBoard.checkWin(board, ticTacToeBoard.getUser()))
                return 10;
            else if (TicTacToeBoard.checkDraw(board))
                return 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == '-') {
                        char[][] clone = TicTacToeBoard.arrayClone(board);
                        clone[i][j] = ticTacToeBoard.getComputer();
                        temp = minimmax(clone, true, depth);
                        if (board[1][1] == '-') {
                            row = 1;
                            column = 1;
                        } else if (utility >= temp) {
                            utility=temp;
                            row = i;
                            column = j;
                        }
                    }
                }
            }
            if (depth == 1)
                System.out.println("computer plays " + row + "   " + column);
            board[row][column] = ticTacToeBoard.getComputer();
            this.row=row;
            this.column=column;

        }
        return utility;
    }
}
