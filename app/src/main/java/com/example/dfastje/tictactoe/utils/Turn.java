package com.example.dfastje.tictactoe.utils;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.widget.CheckBox;

import com.example.dfastje.tictactoe.R;

public class Turn {

    /**
     * true  = player 1's turn.
     * false = player 2's turn.
     */
    private volatile boolean turn = true;


    public void endTurn(){
        updateTurn( !whoseTurn() );
    }

    public synchronized boolean whoseTurn(){
        return turn;
    }

    public synchronized void resetTurn(){
        updateTurn(true);
    }

    private synchronized void updateTurn(boolean newTurn){
        turn  = newTurn;
    }


}
