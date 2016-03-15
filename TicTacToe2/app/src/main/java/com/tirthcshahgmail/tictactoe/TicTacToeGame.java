package com.tirthcshahgmail.tictactoe;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class TicTacToeGame extends Activity {
    boolean unbeatable=true;
    Computer comp;
    boolean ended;
    TicTacToeBoard ticTacToeBoard=new TicTacToeBoard('o');
    public boolean userTurn=true;
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,bmain,brestart;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe_game);
        b0=(Button)findViewById(R.id.b0);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);
        b7=(Button)findViewById(R.id.b7);
        b8=(Button)findViewById(R.id.b8);
        bmain=(Button)findViewById(R.id.bmain);
        brestart=(Button)findViewById(R.id.brestart);
        result=(TextView)findViewById(R.id.textView);
        if(unbeatable){
            initializeUnbeatable();
        }else{
            initializeBeatable();
        }
        ended=false;
    }
    public void restart(View view){
        b0.setText("");
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        userTurn=true;
        if(unbeatable){
            initializeUnbeatable();
        }else{
            initializeBeatable();
        }

    }
    public void initializeUnbeatable(){
        ticTacToeBoard=new TicTacToeBoard('x');
        comp=new UnbeatableComputer(ticTacToeBoard);
        ticTacToeBoard.setComp(comp);
    }
    public void initializeBeatable(){
        ticTacToeBoard=new TicTacToeBoard('x');
        comp=new BeatableComputer(ticTacToeBoard);
        ticTacToeBoard.setComp(comp);
    }

    public void computerPlay(){
        ended=comp.computerPlay();
        int position=comp.row*3+comp.column;
        switch(position){
            case 0:
                b0.setText(ticTacToeBoard.getComputer()+"");
                break;
            case 1:
                b1.setText(ticTacToeBoard.getComputer()+"");
                break;
            case 2:
                b2.setText(ticTacToeBoard.getComputer()+"");
                break;
            case 3:
                b3.setText(ticTacToeBoard.getComputer()+"");
                break;
            case 4:
                b4.setText(ticTacToeBoard.getComputer()+"");
                break;
            case 5:
                b5.setText(ticTacToeBoard.getComputer()+"");
                break;
            case 6:
                b6.setText(ticTacToeBoard.getComputer()+"");
                break;
            case 7:
                b7.setText(ticTacToeBoard.getComputer()+"");
                break;
            case 8:
                b8.setText(ticTacToeBoard.getComputer()+"");
                break;
            default:
                break;
        }

        if(ended){
            result.setText("Computer Wins");
        }else if(ticTacToeBoard.checkDraw(ticTacToeBoard.getBoard())){
            result.setText("Game Draw");
        }else {
            result.setText("Player Turn");
            userTurn=true;
        }

    }
    public void play0(View view){
        Button b=(Button)view;
        String a=b.getText().toString();
        if(a.equals("")&&userTurn){
            b.setText("X");
            ended=ticTacToeBoard.setTile(0,0);
            userTurn=false;
            computerPlay();
        }
    }
    public void play1(View view){
        Button b=(Button)view;
        String a=b.getText().toString();
        if(a.equals("")&&userTurn){
            ended=ticTacToeBoard.setTile(0,1);
            b.setText("X");
            if(ended){
                result.setText("Player Wins");
            }
            else if(ticTacToeBoard.checkDraw(ticTacToeBoard.getBoard()))
                result.setText("Game Draw");
            else {
                result.setText("Computer Play");
                userTurn = false;
                computerPlay();
            }
        }
    }
    public void play2(View view){
        Button b=(Button)view;
        String a=b.getText().toString();
        if(a.equals("")&&userTurn){
            ticTacToeBoard.setTile(0,2);
            b.setText("X");
            userTurn=false;
            computerPlay();
        }
    }
    public void play3(View view){
        Button b=(Button)view;
        String a=b.getText().toString();
        if(a.equals("")&&userTurn){
            ended=ticTacToeBoard.setTile(1,0);
            b.setText("X");
            userTurn=false;
            computerPlay();
        }
    }
    public void play4(View view){
        Button b=(Button)view;
        String a=b.getText().toString();
        if(a.equals("")&&userTurn){
            ended=ticTacToeBoard.setTile(1,1);
            b.setText("X");
            userTurn=false;
            computerPlay();
        }
    }
    public void play5(View view){
        Button b=(Button)view;
        String a=b.getText().toString();
        if(a.equals("")&&userTurn){
            ended=ticTacToeBoard.setTile(1,2);
            b.setText("X");
            userTurn=false;
            computerPlay();
        }
    }
    public void play6(View view){
        Button b=(Button)view;
        String a=b.getText().toString();
        if(a.equals("")&&userTurn){
            ended=ticTacToeBoard.setTile(2,0);
            b.setText("X");
            userTurn=false;
            computerPlay();
        }
    }
    public void play7(View view){
        Button b=(Button)view;
        String a=b.getText().toString();
        if(a.equals("")&&userTurn){
            ticTacToeBoard.setTile(2,1);
            b.setText("X");
            userTurn=false;
            computerPlay();
        }
    }
    public void play8(View view){
        Button b=(Button)view;
        String a=b.getText().toString();
        if(a.equals("")&&userTurn){
            ended=ticTacToeBoard.setTile(2,2);
            b.setText("X");
            userTurn=false;
            computerPlay();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tic_tac_toe_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
