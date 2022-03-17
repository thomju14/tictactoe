// This project took reference from https://www.youtube.com/watch?v=CCQTD7ptYqY

package com.thomasf10.assignment_1;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class PlayTictac extends AppCompatActivity implements View.OnClickListener {


    //Buttons definitions
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
    TextView displaystext;

    //variable for player definition.
    int PLAYER_O = 0;
    int PLAYER_X = 1;

    int activePlayer = PLAYER_O;

    //position for tic tac toe
    int[] position = {-1, -1, -1, -1, -1, -1, -1, -1, -1};

    boolean activeGame = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_tictac);

        //Background animation
        ConstraintLayout constraintLayout = findViewById(R.id.backlayout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        //
        displaystext = findViewById(R.id.textView_winner);
        btn0 = findViewById(R.id.btn_0);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);





    }


    @Override
    public void onClick(View view) {
        // buttons configurations
        if(!activeGame)
            return;

        Button clickedBtn = findViewById(view.getId());
        int clickedTag = Integer.parseInt(view.getTag().toString());

        if(position[clickedTag]!= -1){
            return;
        }

        position[clickedTag] = activePlayer;

        if(activePlayer == PLAYER_O){
            clickedBtn.setText("O");
            clickedBtn.setTextColor(Color.parseColor("#1C29A1"));
            displaystext.setText("X turn");
            activePlayer = PLAYER_X;


        }else{
            clickedBtn.setText("X");
            clickedBtn.setTextColor(Color.parseColor("#F33541"));
            activePlayer = PLAYER_O;
            displaystext.setText("O turn");
        }

        checkWin();



    }
    //check who is the winner.
    private void checkWin(){
        int[][] winPos = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
        for(int i = 0; i<8; i++){
            int value0 = winPos [i][0];
            int value1 = winPos [i][1];
            int value2 = winPos [i][2];

            if(position[value0] == position[value1] && position[value1] == position[value2]){
                if(position[value0] != -1){

                    activeGame = false;

                    if(position[value0] == PLAYER_O)
                        displaystext.setText("O is the winner");
                    else
                    displaystext.setText("X is the winner");
                }
            }
        }

    }
    //reset the game.
    public void restartGame(View view) {
        activePlayer = PLAYER_O;
        displaystext.setText("Lets play again");
        position = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1};
        btn0.setText("");
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");


        activeGame = true;




    }
}
