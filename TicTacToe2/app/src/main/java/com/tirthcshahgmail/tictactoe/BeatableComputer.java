package com.tirthcshahgmail.tictactoe;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Tirth Shah on 10-05-2015.
 */
public class BeatableComputer extends Computer {
    Random r=new Random();
    ArrayList<Integer> al;
    public BeatableComputer(TicTacToeBoard ticTacToeBoard) {
        super(ticTacToeBoard);
    }

    public boolean computerPlay() {
        if(!ticTacToeBoard.checkDraw(ticTacToeBoard.getBoard())){
            al=new ArrayList<Integer>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(board[i][j]=='-'){
                        al.add(i*3+j);
                    }
                }
            }
            int mark=r.nextInt(al.size());
            row=al.get(mark)/3;
            column=al.get(mark%3);

            boolean win =ticTacToeBoard.setBoard(board);
            return win;
        }
        return false;
    }

}
