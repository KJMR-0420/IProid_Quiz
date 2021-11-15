package com.example.iproid_test.Quizzes_Levels;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.iproid_test.R;

public class Lesson6_levels extends AppCompatActivity implements View.OnClickListener {
    LinearLayout LVL1,LVL2,LVL3,LVL4,LVL5,LVL6,LVL7,LVL8,LVL9,LVL10;
    ImageView imgLVL1,imgLVL2,imgLVL3,imgLVL4,imgLVL5,imgLVL6,imgLVL7,imgLVL8,imgLVL9,imgLVL10;

    String CategoryValue = "";
    int Lesson6Lvl1,Lesson6Lvl2,Lesson6Lvl3,Lesson6Lvl4,Lesson6Lvl5,
            Lesson6Lvl6,Lesson6Lvl7,Lesson6Lvl8,Lesson6Lvl9,Lesson6Lvl10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson6_levels);
        LVL1 = findViewById(R.id.Level1);
        LVL2 = findViewById(R.id.Level2);
        LVL3 = findViewById(R.id.Level3);
        LVL4 = findViewById(R.id.Level4);
        LVL5 = findViewById(R.id.Level5);
        LVL6 = findViewById(R.id.Level6);
        LVL7 = findViewById(R.id.Level7);
        LVL8 = findViewById(R.id.Level8);
        LVL9 = findViewById(R.id.Level9);
        LVL10 = findViewById(R.id.Level10);

        imgLVL1 = findViewById(R.id.imgLevel1);
        imgLVL2 = findViewById(R.id.imgLevel2);
        imgLVL3 = findViewById(R.id.imgLevel3);
        imgLVL4 = findViewById(R.id.imgLevel4);
        imgLVL5 = findViewById(R.id.imgLevel5);
        imgLVL6 = findViewById(R.id.imgLevel6);
        imgLVL7 = findViewById(R.id.imgLevel7);
        imgLVL8 = findViewById(R.id.imgLevel8);
        imgLVL9 = findViewById(R.id.imgLevel9);
        imgLVL10 = findViewById(R.id.imgLevel10);

        lockAndUnlockLevel();

        Intent intentVar = getIntent();

        CategoryValue= intentVar.getStringExtra("Category");
    }

    @Override
    public void onClick(View v) {
        if (CategoryValue.equals("LESSON6")){


            switch (v.getId()){


                case R.id.Level1:

                    Intent intentLesson6Level1 = new Intent(Lesson6_levels.this,QuizActivity.class);
                    intentLesson6Level1.putExtra("Category",Question.CATEGORY_LESSON3);
                    intentLesson6Level1.putExtra("Level",1);
                    startActivity(intentLesson6Level1);
                    finish();
                    break;

                case R.id.Level2:

                    Intent intentLesson6Level2 = new Intent(Lesson6_levels.this,QuizActivity.class);
                    intentLesson6Level2.putExtra("Category",Question.CATEGORY_LESSON3);
                    intentLesson6Level2.putExtra("Level",2);
                    startActivity(intentLesson6Level2);
                    finish();
                    break;

                case R.id.Level3:

                    Intent intentLesson6Level3 = new Intent(Lesson6_levels.this,QuizActivity.class);
                    intentLesson6Level3.putExtra("Category",Question.CATEGORY_LESSON3);
                    intentLesson6Level3.putExtra("Level",3);
                    startActivity(intentLesson6Level3);
                    finish();
                    break;


                case R.id.Level4:

                    Intent intentLesson6Level4 = new Intent(Lesson6_levels.this,QuizActivity.class);
                    intentLesson6Level4.putExtra("Category",Question.CATEGORY_LESSON3);
                    intentLesson6Level4.putExtra("Level",4);
                    startActivity(intentLesson6Level4);
                    finish();
                    break;


                case R.id.Level5:

                    Intent intentLesson6Level5 = new Intent(Lesson6_levels.this,QuizActivity.class);
                    intentLesson6Level5.putExtra("Category",Question.CATEGORY_LESSON3);
                    intentLesson6Level5.putExtra("Level",5);
                    startActivity(intentLesson6Level5);
                    finish();
                    break;


                case R.id.Level6:

                    Intent intentLesson6Level6 = new Intent(Lesson6_levels.this,QuizActivity.class);
                    intentLesson6Level6.putExtra("Category",Question.CATEGORY_LESSON3);
                    intentLesson6Level6.putExtra("Level",6);
                    startActivity(intentLesson6Level6);
                    finish();
                    break;
                case R.id.Level7:

                    Intent intentLesson6Level7 = new Intent(Lesson6_levels.this,QuizActivity.class);
                    intentLesson6Level7.putExtra("Category",Question.CATEGORY_LESSON3);
                    intentLesson6Level7.putExtra("Level",7);
                    startActivity(intentLesson6Level7);
                    finish();
                    break;

                case R.id.Level8:

                    Intent intentLesson6Level8 = new Intent(Lesson6_levels.this,QuizActivity.class);
                    intentLesson6Level8.putExtra("Category",Question.CATEGORY_LESSON3);
                    intentLesson6Level8.putExtra("Level",8);
                    startActivity(intentLesson6Level8);
                    finish();
                    break;

                case R.id.Level9:

                    Intent intentLesson6Level9 = new Intent(Lesson6_levels.this,QuizActivity.class);
                    intentLesson6Level9.putExtra("Category",Question.CATEGORY_LESSON3);
                    intentLesson6Level9.putExtra("Level",9);
                    startActivity(intentLesson6Level9);
                    finish();
                    break;
                case R.id.Level10:

                    Intent intentLesson6Level10 = new Intent(Lesson6_levels.this,QuizActivity.class);
                    intentLesson6Level10.putExtra("Category",Question.CATEGORY_LESSON3);
                    intentLesson6Level10.putExtra("Level",10);
                    startActivity(intentLesson6Level10);
                    finish();
                    break;
            }

        }
    }
    private void lockAndUnlockLevel(){
        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);

        Lesson6Lvl1 = sharedPreferences.getInt(Constants.KEY_LESSON6_LEVEL_1,0);
        Lesson6Lvl2  = sharedPreferences.getInt(Constants.KEY_LESSON6_LEVEL_2,0);
        Lesson6Lvl3  = sharedPreferences.getInt(Constants.KEY_LESSON6_LEVEL_3,0);
        Lesson6Lvl4  = sharedPreferences.getInt(Constants.KEY_LESSON6_LEVEL_4,0);
        Lesson6Lvl5  = sharedPreferences.getInt(Constants.KEY_LESSON6_LEVEL_5,0);
        Lesson6Lvl6  = sharedPreferences.getInt(Constants.KEY_LESSON6_LEVEL_6,0);
        Lesson6Lvl8  = sharedPreferences.getInt(Constants.KEY_LESSON6_LEVEL_8,0);
        Lesson6Lvl7  = sharedPreferences.getInt(Constants.KEY_LESSON6_LEVEL_7,0);
        Lesson6Lvl9  = sharedPreferences.getInt(Constants.KEY_LESSON6_LEVEL_9,0);
        Lesson6Lvl10  = sharedPreferences.getInt(Constants.KEY_LESSON6_LEVEL_10,0);

        // Level 1
        if (Lesson6Lvl1 == 1){
            LVL1.setClickable(true);
            LVL1.setOnClickListener(this);
            LVL1.setBackgroundResource(R.drawable.level_unlock_bg);
            imgLVL1.setImageResource(R.drawable.unlock);

        }else {
            LVL1.setClickable(false);
            LVL1.setBackgroundResource(R.drawable.level_lock_bg);
            imgLVL1.setImageResource(R.drawable.lock);
        }


        // Level 2
        if (Lesson6Lvl2 == 1){
            LVL2.setClickable(true);
            LVL2.setOnClickListener(this);
            LVL2.setBackgroundResource(R.drawable.level_unlock_bg);
            imgLVL2.setImageResource(R.drawable.unlock);

        }else {
            LVL2.setClickable(false);
            LVL2.setBackgroundResource(R.drawable.level_lock_bg);
            imgLVL2.setImageResource(R.drawable.lock);
        }

        // Level 3
        if (Lesson6Lvl3 == 1){
            LVL3.setClickable(true);
            LVL3.setOnClickListener(this);
            LVL3.setBackgroundResource(R.drawable.level_unlock_bg);
            imgLVL3.setImageResource(R.drawable.level_unlock_bg);

        }else {
            LVL3.setClickable(false);
            LVL3.setBackgroundResource(R.drawable.level_lock_bg);
            imgLVL3.setImageResource(R.drawable.lock);
        }

        // Level 4
        if (Lesson6Lvl4 == 1){
            LVL4.setClickable(true);
            LVL4.setOnClickListener(this);
            LVL4.setBackgroundResource(R.drawable.level_unlock_bg);
            imgLVL4.setImageResource(R.drawable.unlock);

        }else {
            LVL4.setClickable(false);
            LVL4.setBackgroundResource(R.drawable.level_lock_bg);
            imgLVL4.setImageResource(R.drawable.lock);
        }

        // Level 5
        if (Lesson6Lvl5 == 1){
            LVL5.setClickable(true);
            LVL5.setOnClickListener(this);
            LVL5.setBackgroundResource(R.drawable.level_unlock_bg);
            imgLVL5.setImageResource(R.drawable.unlock);

        }else {
            LVL5.setClickable(false);
            LVL5.setBackgroundResource(R.drawable.level_lock_bg);
            imgLVL5.setImageResource(R.drawable.lock);
        }


        // Level 6
        if (Lesson6Lvl6 == 1){
            LVL6.setClickable(true);
            LVL6.setOnClickListener(this);
            LVL6.setBackgroundResource(R.drawable.level_unlock_bg);
            imgLVL6.setImageResource(R.drawable.unlock);

        }else {
            LVL6.setClickable(false);
            LVL6.setBackgroundResource(R.drawable.level_lock_bg);
            imgLVL6.setImageResource(R.drawable.lock);
        }

        // Level 7
        if (Lesson6Lvl7== 1){
            LVL7.setClickable(true);
            LVL7.setOnClickListener(this);
            LVL7.setBackgroundResource(R.drawable.level_unlock_bg);
            imgLVL7.setImageResource(R.drawable.unlock);

        }else {
            LVL7.setClickable(false);
            LVL7.setBackgroundResource(R.drawable.level_lock_bg);
            imgLVL7.setImageResource(R.drawable.lock);
        }
        // Level 8
        if (Lesson6Lvl8 == 1){
            LVL8.setClickable(true);
            LVL8.setOnClickListener(this);
            LVL8.setBackgroundResource(R.drawable.level_unlock_bg);
            imgLVL8.setImageResource(R.drawable.unlock);

        }else {
            LVL8.setClickable(false);
            LVL8.setBackgroundResource(R.drawable.level_lock_bg);
            imgLVL8.setImageResource(R.drawable.lock);
        }

        // Level 9
        if (Lesson6Lvl9 == 1){
            LVL9.setClickable(true);
            LVL9.setOnClickListener(this);
            LVL9.setBackgroundResource(R.drawable.level_unlock_bg);
            imgLVL9.setImageResource(R.drawable.unlock);

        }else {
            LVL9.setClickable(false);
            LVL9.setBackgroundResource(R.drawable.level_lock_bg);
            imgLVL9.setImageResource(R.drawable.lock);
        }
        // Level 10
        if (Lesson6Lvl10 == 1){
            LVL10.setClickable(true);
            LVL10.setOnClickListener(this);
            LVL10.setBackgroundResource(R.drawable.level_unlock_bg);
            imgLVL10.setImageResource(R.drawable.unlock);

        }else {
            LVL10.setClickable(false);
            LVL10.setBackgroundResource(R.drawable.level_lock_bg);
            imgLVL10.setImageResource(R.drawable.lock);
        }
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Lesson6_levels.this,Lessons.class);
        startActivity(intent);
        finish();

    }
}