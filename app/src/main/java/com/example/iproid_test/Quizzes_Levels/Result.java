package com.example.iproid_test.Quizzes_Levels;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.iproid_test.R;
import com.example.iproid_test.SplashScreen.SplashScreen;

public class Result extends AppCompatActivity {
    Button btnPlayAgain,btnPlayStart,btnPlayNextLvl;
    TextView txtTotalQuestion,txtCoins,txtWrongQues,txtCorrectQues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btnPlayAgain = findViewById(R.id.bt_PlayAgainR);
        btnPlayStart = findViewById(R.id.bt_PlayScreenR);
        btnPlayNextLvl = findViewById(R.id.bt_PlayNextLevelR);

        txtCoins = findViewById(R.id.txtCoinsR);
        txtCorrectQues = findViewById(R.id.txtCorrectR);
        txtWrongQues = findViewById(R.id.txtWrongR);
        txtTotalQuestion = findViewById(R.id.txtTotalQuestionsR);

        Intent intent = getIntent();

        int totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0);
        int coins = intent.getIntExtra(Constants.COINS,0);
        int correct = intent.getIntExtra(Constants.CORRECT,0);
        int wrong = intent.getIntExtra(Constants.WRONG,0);
        final String categoryValue = intent.getStringExtra("Category");
        final int levelsId = intent.getIntExtra("Level",0);

        txtTotalQuestion.setText(String.valueOf(totalQuestions));
        txtCoins.setText(String.valueOf(coins));
        txtCorrectQues.setText(String.valueOf(correct));
        txtWrongQues.setText(String.valueOf(wrong));

        btnPlayStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Result.this, SplashScreen.class);
                startActivity(intent);
                finish();
            }
        });


        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Result.this,QuizActivity.class);
                intent.putExtra("Category",categoryValue);
                intent.putExtra("Level",levelsId);
                startActivity(intent);
                finish();


            }
        });


        btnPlayNextLvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (categoryValue.equals("LESSON1")){
                    Intent intent = new Intent(Result.this,Lesson1_levels.class);
                    intent.putExtra("Category",categoryValue);
                    startActivity(intent);
                    finish();
                }else if (categoryValue.equals("LESSON2")){
                    Intent intent = new Intent(Result.this,Lesson2_levels.class);
                    intent.putExtra("Category",categoryValue);
                    startActivity(intent);
                    finish();
                }else if (categoryValue.equals("LESSON3")){
                    Intent intent = new Intent(Result.this,Lesson3_levels.class);
                    intent.putExtra("Category",categoryValue);
                    startActivity(intent);
                    finish();
                }else if (categoryValue.equals("LESSON4")){
                    Intent intent = new Intent(Result.this,Lesson4_levels.class);
                    intent.putExtra("Category",categoryValue);
                    startActivity(intent);
                    finish();
                }else if (categoryValue.equals("LESSON5")){
                    Intent intent = new Intent(Result.this,Lesson5_levels.class);
                    intent.putExtra("Category",categoryValue);
                    startActivity(intent);
                    finish();
                }else if (categoryValue.equals("LESSON6")){
                    Intent intent = new Intent(Result.this,Lesson6_levels.class);
                    intent.putExtra("Category",categoryValue);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Result.this,SplashScreen.class);
        startActivity(intent);
        finish();
    }
}