package com.example.jigjag;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GameOneFragment extends AppCompatActivity {
    public TextView one;
    public TextView two;
    public TextView three;
    public ImageView appleone;
    public ImageView appletwo;
    public ImageView orangeone;
    public ImageView orangetwo;
    public ImageView finalorange;
    public ImageView finalapple;
    public EditText inputone;
    public EditText inputtwo;
    public Button enter;
    public TextView message;



    public static int RandomiseNumber(int min, int max){
        int number = (int)(Math.random()*((max-min) + 1)) + min;
        return number;
    }
    int numberone = RandomiseNumber(2,12);
    int numbertwo = RandomiseNumber(0,12);
    int numberthree = RandomiseNumber(0,12);

    int answerone = numberone * numbertwo - numberthree;
    int answertwo = numberthree + numbertwo;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameone);
        final TextView one = findViewById(R.id.NumberOne);
        final TextView two = findViewById(R.id.AnswerOne);
        final TextView three = findViewById(R.id.AnswerTwo);
        one.setText(String.valueOf(numberone));
        two.setText(String.valueOf(answerone));
        three.setText(String.valueOf(answertwo));
        ImageView appleone = findViewById(R.id.imageView);
        appleone.setImageResource(R.drawable.apple);
        ImageView appletwo = findViewById(R.id.imageView3);
        appletwo.setImageResource(R.drawable.apple);
        ImageView orangeone = findViewById(R.id.imageView2);
        orangeone.setImageResource(R.drawable.orange);
        ImageView orangetwo = findViewById(R.id.imageView4);
        orangetwo.setImageResource(R.drawable.orange);
        ImageView finalorange = findViewById(R.id.imageView7);
        finalorange.setImageResource(R.drawable.orange);
        ImageView finalapple = findViewById(R.id.imageView6);
        finalapple.setImageResource(R.drawable.apple);
        final EditText inputone = findViewById(R.id.InputOne);
        final EditText inputtwo = findViewById(R.id.InputTwo);
        final TextView message = findViewById(R.id.Message);
        Button enter = findViewById(R.id.EnterAnswer);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int useranswerone = Integer.valueOf(inputone.getText().toString());
                int useranswertwo = Integer.valueOf(inputtwo.getText().toString());

                if (useranswerone == numberthree && useranswertwo == numbertwo){
                    message.setText("Correct!");
                    numberone = RandomiseNumber(2,12);
                    numbertwo = RandomiseNumber(0,12);
                    numberthree = RandomiseNumber(0,12);
                    answerone = numberone * numbertwo - numberthree;
                    answertwo = numberthree + numbertwo;
                    one.setText(String.valueOf(numberone));
                    two.setText(String.valueOf(answerone));
                    three.setText(String.valueOf(answertwo));

                }
                else {
                    message.setText("Incorrect! Please try again!");
                }
            }
        });


    }

}
