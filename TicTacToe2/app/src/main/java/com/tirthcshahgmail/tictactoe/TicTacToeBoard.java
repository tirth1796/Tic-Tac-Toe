package com.tirthcshahgmail.tictactoe;

/**
 * Created by Tirth Shah on 10-05-2015.
 */
public class TicTacToeBoard {
    private char[][] board;
    private char user;
    private char computer;
    private Computer comp;
    public void printBoard(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public void setComp(Computer comp) {
        this.comp = comp;
    }
    public TicTacToeBoard(char user) {
        this.user = user;
        if (user == 'x') {
            this.computer = 'o';
        } else if (user == 'o') {
            this.computer = 'x';
        }
        initializeBoard();
    }
    public boolean setTile(int row,int column){
        board[row][column]=user;
        printBoard();
        comp.setBoard(board);
        if(checkWin(board, user)){
            System.out.println("user wins");
            return true;
        }
        return false;
    }
    public boolean setBoard(char[][] board) {
        this.board = board;
        printBoard();
        if(checkWin(board, computer)){
            System.out.println("computer wins");
            return true;
        }
        return false;
    }

    public char[][] getBoard() {
        return board;
    }

    public char getUser() {
        return user;
    }

    public char getComputer() {
        return computer;
    }

    private void initializeBoard() {
        board=new char[3][3] ;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = '-';
            }
        }
    }
    public static boolean checkWin(char[][] board,char check){
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == check)
                || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == check)) {
            // System.out.println("X Diagonal Win");
            return true;
        }
        for (int i = 0; i < 3; ++i) {
            if (((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == check) || (board[0][i] == board[1][i]
                    && board[0][i] == board[2][i] && board[0][i] == check))) {
                // System.out.println("X Row or Column win");
                return true;
            }
        }
        return false;

    }
    public static boolean checkDraw(char[][] board){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j]=='-')
                    return false;
            }
        }
        return true;
    }
    public static char[][] arrayClone(char[][] board){
        char[][] boardCopy=new char[3][3];
        for (int i = 0; i < boardCopy.length; i++) {
            for (int j = 0; j < boardCopy.length; j++) {
                boardCopy[i][j]=board[i][j];
            }
        }
        return boardCopy;
    }
}

