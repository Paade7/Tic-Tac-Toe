package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class TicTacToe extends AppCompatActivity {

    int i = 1;
    String symbol = "";
    int[][] matrix = {{0,0,0},
            {0,0,0},
            {0,0,0}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
    }

    public void click(View v){
        TextView text = findViewById(R.id.play);
        Button b = (Button) v;
        String ButtonId = b.getResources().getResourceEntryName(b.getId());
        int id = Integer.parseInt(ButtonId.substring(ButtonId.length()-1));
        id--;
        int row,col;
        row = id / 3;
        col = id % 3;

        if(i==1){
            b.setText("X");
            symbol = "X";
            text.setText(R.string.o_turn_text);
            b.setEnabled(false);
            matrix[row][col] = 1;
            i++;
        } else if (i == 2) {
            b.setText("O");
            symbol = "O";
            text.setText(R.string.x_turn_text);
            b.setEnabled(false);
            matrix[row][col] = 2;
            i--;
        }
        check();

    }

    public void check() {

        String winB1="", winB2="", winB3="";
        int a,b,c,x,y,z;
        Button b1, b2, b3;
        int buttonId1, buttonId2, buttonId3;


        for (int i = 0; i < 3; i++) {
            a = matrix[i][0];
            b = matrix[i][1];
            c = matrix[i][2];

            x = matrix[0][i];
            y = matrix[1][i];
            z = matrix[2][i];

            if ((a == 1 && b == 1 && c == 1) || (a == 2 && b == 2 && c == 2)) {
                winB1 = "button" + (3 * i + 1);
                winB2 = "button" + (3 * i + 2);
                winB3 = "button" + (3 * i + 3);

                buttonId1 = getResources().getIdentifier(winB1, "id", getPackageName());
                buttonId2 = getResources().getIdentifier(winB2, "id", getPackageName());
                buttonId3 = getResources().getIdentifier(winB3, "id", getPackageName());

                b1 = findViewById(buttonId1);
                b2 = findViewById(buttonId2);
                b3 = findViewById(buttonId3);

                b1.setTextColor(Color.GREEN);
                b2.setTextColor(Color.GREEN);
                b3.setTextColor(Color.GREEN);

                win();
            }

            if ((x == 1 && y == 1 && z == 1) || (x == 2 && y == 2 && z == 2)) {
                winB1 = "button" + (i+1);
                winB2 = "button" + (i+4);
                winB3 = "button" + (i+7);


                buttonId1 = getResources().getIdentifier(winB1, "id", getPackageName());
                buttonId2 = getResources().getIdentifier(winB2, "id", getPackageName());
                buttonId3 = getResources().getIdentifier(winB3, "id", getPackageName());

                b1 = findViewById(buttonId1);
                b2 = findViewById(buttonId2);
                b3 = findViewById(buttonId3);

                b1.setTextColor(Color.GREEN);
                b2.setTextColor(Color.GREEN);
                b3.setTextColor(Color.GREEN);

                win();
            }
        }



        if ((matrix[0][0] == 1 && matrix[1][1] == 1 && matrix[2][2] == 1) ||
                (matrix[0][0] == 2 && matrix[1][1] == 2 && matrix[2][2] == 2)) {

            winB1 = "button" + (1);
            winB2 = "button" + (5);
            winB3 = "button" + (9);

            buttonId1 = getResources().getIdentifier(winB1, "id", getPackageName());
            buttonId2 = getResources().getIdentifier(winB2, "id", getPackageName());
            buttonId3 = getResources().getIdentifier(winB3, "id", getPackageName());

            b1 = findViewById(buttonId1);
            b2 = findViewById(buttonId2);
            b3 = findViewById(buttonId3);

            b1.setTextColor(Color.GREEN);
            b2.setTextColor(Color.GREEN);
            b3.setTextColor(Color.GREEN);

            win();
        }

        if ((matrix[0][2] == 1 && matrix[1][1] == 1 && matrix[2][0] == 1) ||
                (matrix[0][2] == 2 && matrix[1][1] == 2 && matrix[2][0] == 2)) {

            winB1 = "button" + (3);
            winB2 = "button" + (5);
            winB3 = "button" + (7);

            buttonId1 = getResources().getIdentifier(winB1, "id", getPackageName());
            buttonId2 = getResources().getIdentifier(winB2, "id", getPackageName());
            buttonId3 = getResources().getIdentifier(winB3, "id", getPackageName());

            b1 = findViewById(buttonId1);
            b2 = findViewById(buttonId2);
            b3 = findViewById(buttonId3);

            b1.setTextColor(Color.GREEN);
            b2.setTextColor(Color.GREEN);
            b3.setTextColor(Color.GREEN);

            win();
        }
    }



    public void win(){
        TextView t = findViewById(R.id.play);
        t.setText(symbol + " won 🥇");
//        t.setText(R.string.who_won_text);

        for (int i = 1; i <= 9; i++) {
            Button button = findViewById(getResources().getIdentifier("button" + (i), "id", getPackageName()));
            button.setEnabled(false);
        }

    }


    public void reset (View v){
        TextView text = findViewById(R.id.play);
        text.setText("Play");
        ViewGroup layout = findViewById(R.id.main);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            if (child instanceof Button && "gameButton".equals(child.getTag())) {
                ((Button) child).setText("");
                ((Button) child).setTextColor(Color.BLACK); 
                ((Button) child).setEnabled(true);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = 0;
            }
        }
    }
}




