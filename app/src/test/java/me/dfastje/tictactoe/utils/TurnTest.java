package me.dfastje.tictactoe.utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TurnTest {

    @Before
    public void setup(){
        Turn.resetTurn();
    }

    @Test
    public void endTurn_whoseTurn_Test(){
        assertTrue( Turn.whoseTurn() );
        Turn.endTurn();
        assertFalse( Turn.whoseTurn() );
    }


}