package me.dfastje.tictactoe.utils;

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
