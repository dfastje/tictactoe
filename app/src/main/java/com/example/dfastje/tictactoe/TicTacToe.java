package com.example.dfastje.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.dfastje.tictactoe.utils.Turn;

public class TicTacToe extends AppCompatActivity {

    Turn gameTurn = new Turn();

    private CheckBox team1Box;
    private CheckBox team2Box;

    private Button r1c1Btn;
    private Button r2c1Btn;
    private Button r3c1Btn;

    private Button r1c2Btn;
    private Button r2c2Btn;
    private Button r3c2Btn;

    private Button r1c3Btn;
    private Button r2c3Btn;
    private Button r3c3Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);

        team1Box = findViewById(R.id.checkBox1);
        team2Box = findViewById(R.id.checkBox2);
        updateCheckBoxes();

        r1c1Btn = findViewById(R.id.buttonR1C1);
        r2c1Btn = findViewById(R.id.buttonR2C1);
        r3c1Btn = findViewById(R.id.buttonR3C1);
        r1c1Btn.setOnClickListener(new BoardButtonListener());
        r2c1Btn.setOnClickListener(new BoardButtonListener());
        r3c1Btn.setOnClickListener(new BoardButtonListener());

        r1c2Btn = findViewById(R.id.buttonR1C2);
        r2c2Btn = findViewById(R.id.buttonR2C2);
        r3c2Btn = findViewById(R.id.buttonR3C2);
        r1c2Btn.setOnClickListener(new BoardButtonListener());
        r2c2Btn.setOnClickListener(new BoardButtonListener());
        r3c2Btn.setOnClickListener(new BoardButtonListener());

        r1c3Btn = findViewById(R.id.buttonR1C3);
        r2c3Btn = findViewById(R.id.buttonR2C3);
        r3c3Btn = findViewById(R.id.buttonR3C3);
        r1c3Btn.setOnClickListener(new BoardButtonListener());
        r2c3Btn.setOnClickListener(new BoardButtonListener());
        r3c3Btn.setOnClickListener(new BoardButtonListener());

        Button resetBtn = findViewById( R.id.buttonReset );
        resetBtn.setOnClickListener( new ResetButtonListener() );

    }

    public synchronized void updateCheckBoxes(){

        team1Box.setChecked(  gameTurn.whoseTurn() );
        team2Box.setChecked( !gameTurn.whoseTurn() );
    }

    private class BoardButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Button tempButton = findViewById( v.getId() );

            if( gameTurn.whoseTurn() ) {
                tempButton.setText( R.string.team_1_indicator );
            } else {
                tempButton.setText( R.string.team_2_indicator );
            }
            gameTurn.endTurn();
            updateCheckBoxes();
        }
    }

    private class ResetButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            gameTurn.resetTurn();

            updateCheckBoxes();

            r1c1Btn.setText( R.string.open_box );
            r2c1Btn.setText( R.string.open_box );
            r3c1Btn.setText( R.string.open_box );
            r1c2Btn.setText( R.string.open_box );
            r2c2Btn.setText( R.string.open_box );
            r3c2Btn.setText( R.string.open_box );
            r1c3Btn.setText( R.string.open_box );
            r2c3Btn.setText( R.string.open_box );
            r3c3Btn.setText( R.string.open_box );

        }
    }

}
