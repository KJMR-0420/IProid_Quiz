package com.example.iproid_test.Quizzes_Levels;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.VideoView;

import com.example.iproid_test.Lecture.Lecture;
import com.example.iproid_test.Lecture.test_pythonCompiler;
import com.example.iproid_test.R;
import com.example.iproid_test.SplashScreen.SplashScreen;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Lessons extends AppCompatActivity implements View.OnClickListener{
    public static final String EXTRA_DIFFICULTY = "xtraDifficulty";
    Spinner spinnerdifficulty;
    Button btn_lesson1,btn_lesson2,btn_lesson3,btn_lesson4,btn_lesson5,btn_lesson6;
    BottomNavigationView bottomNavigationView;
    VideoView lecturebg;
    private Spinner spinnerDifficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);

        btn_lesson1 = findViewById(R.id.btn_Lesson1);
        btn_lesson2 = findViewById(R.id.btn_Lesson2);
        btn_lesson3 = findViewById(R.id.btn_Lesson3);
        btn_lesson4 = findViewById(R.id.btn_Lesson4);
        btn_lesson5 = findViewById(R.id.btn_Lesson5);
        btn_lesson6 = findViewById(R.id.btn_Lesson6);

        lecturebg = findViewById(R.id.lecturebg);

        Uri video =Uri.parse("android.resource://"+getPackageName() + "/" + R.raw.splashcreen1);

        lecturebg.setVideoURI(video);

        lecturebg.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });lecturebg.start();

        bottomNavigationView = findViewById(R.id.bottomNav);

        bottomNavigationView.setSelectedItemId(R.id.Quizzes);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.Quizzes:
                        return true;
                    case R.id.Lecture:
                        Intent intent = new Intent(Lessons.this, Lecture.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Compiler:
                        Intent intent2 = new Intent(Lessons.this, test_pythonCompiler.class);
                        startActivity(intent2);
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        //spinnerdifficulty = findViewById(R.id.spinner_difficulty);

        btn_lesson1.setOnClickListener(this);
        btn_lesson2.setOnClickListener(this);
        btn_lesson3.setOnClickListener(this);
        btn_lesson4.setOnClickListener(this);
        btn_lesson5.setOnClickListener(this);
        btn_lesson6.setOnClickListener(this);
        //LoadDifficultyLevel();



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){


            case R.id.btn_Lesson1:

                createLevelsForLesson1();
                Intent intentLesson1 = new Intent(Lessons.this,Lesson1_levels.class);
                intentLesson1.putExtra("Category",Question.CATEGORY_LESSON1);
                startActivity(intentLesson1);
                finish();
                break;

            case R.id.btn_Lesson2:
                createLevelsForLesson2();
                Intent intentLesson2 = new Intent(Lessons.this,Lesson2_levels.class);
                intentLesson2.putExtra("Category",Question.CATEGORY_LESSON2);
                startActivity(intentLesson2);
                finish();
                break;


            case R.id.btn_Lesson3:
                createLevelsForLesson3();
                Intent intentLesson3 = new Intent(Lessons.this,Lesson3_levels.class);
                intentLesson3.putExtra("Category",Question.CATEGORY_LESSON3);
                startActivity(intentLesson3);
                finish();
                break;


            case R.id.btn_Lesson4:
                createLevelsForLesson4();
                Intent intentLesson4 = new Intent(Lessons.this,Lesson4_levels.class);
                intentLesson4.putExtra("Category",Question.CATEGORY_LESSON4);
                startActivity(intentLesson4);
                finish();
                break;


            case R.id.btn_Lesson5:
                createLevelsForLesson5();
                Intent intentLesson5 = new Intent(Lessons.this,Lesson5_levels.class);
                intentLesson5.putExtra("Category",Question.CATEGORY_LESSON5);
                startActivity(intentLesson5);
                finish();
                break;


            case R.id.btn_Lesson6:
                createLevelsForLesson6();
                Intent intentLesson6 = new Intent(Lessons.this,Lesson6_levels.class);
                intentLesson6.putExtra("Category",Question.CATEGORY_LESSON6);
                startActivity(intentLesson6);
                finish();
                break;
        }

    }

    public void createLevelsForLesson1(){

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constants.KEY_LESSON1_LEVEL_1,1);
        editor.putString(Constants.KEY_CAT_LESSON1_LEVEL_1,"Unlock");
        editor.apply();

        if (sharedPreferences.getString(Constants.KEY_CAT_LESSON1_LEVEL_1,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON1_LEVEL_1,1);   ///  Unlock Level 1
            editor.putInt(Constants.KEY_LESSON1_LEVEL_2,0);
            editor.putInt(Constants.KEY_LESSON1_LEVEL_3,0);
            editor.putInt(Constants.KEY_LESSON1_LEVEL_4,0);
            editor.putInt(Constants.KEY_LESSON1_LEVEL_5,0);
            editor.putInt(Constants.KEY_LESSON1_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON1_LEVEL_2,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON1_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON1_LEVEL_2,1);   ///  Unlock Level 2
            editor.putInt(Constants.KEY_LESSON1_LEVEL_3,0);
            editor.putInt(Constants.KEY_LESSON1_LEVEL_4,0);
            editor.putInt(Constants.KEY_LESSON1_LEVEL_5,0);
            editor.putInt(Constants.KEY_LESSON1_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON1_LEVEL_3,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON1_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON1_LEVEL_2,1);
            editor.putInt(Constants.KEY_LESSON1_LEVEL_3,1);   ///  Unlock Level 3
            editor.putInt(Constants.KEY_LESSON1_LEVEL_4,0);
            editor.putInt(Constants.KEY_LESSON1_LEVEL_5,0);
            editor.putInt(Constants.KEY_LESSON1_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON1_LEVEL_4,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON1_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON1_LEVEL_2,1);
            editor.putInt(Constants.KEY_LESSON1_LEVEL_3,1);
            editor.putInt(Constants.KEY_LESSON1_LEVEL_4,1);  ///  Unlock Level 4
            editor.putInt(Constants.KEY_LESSON1_LEVEL_5,0);
            editor.putInt(Constants.KEY_LESSON1_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON1_LEVEL_5,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON1_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON1_LEVEL_2,1);
            editor.putInt(Constants.KEY_LESSON1_LEVEL_3,1);
            editor.putInt(Constants.KEY_LESSON1_LEVEL_4,1);
            editor.putInt(Constants.KEY_LESSON1_LEVEL_5,1);    ///  Unlock Level 5
            editor.putInt(Constants.KEY_LESSON1_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON1_LEVEL_6,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON1_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON1_LEVEL_2,1);
            editor.putInt(Constants.KEY_LESSON1_LEVEL_3,1);
            editor.putInt(Constants.KEY_LESSON1_LEVEL_4,1);
            editor.putInt(Constants.KEY_LESSON1_LEVEL_5,1);
            editor.putInt(Constants.KEY_LESSON1_LEVEL_6,1);  ///  Unlock Level 6

        }
    }
    public void createLevelsForLesson2(){

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constants.KEY_LESSON2_LEVEL_1,1);
        editor.putString(Constants.KEY_CAT_LESSON2_LEVEL_1,"Unlock");
        editor.apply();

        if (sharedPreferences.getString(Constants.KEY_CAT_LESSON2_LEVEL_1,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON2_LEVEL_1,1);   ///  Unlock Level 1
            editor.putInt(Constants.KEY_LESSON2_LEVEL_2,0);
            editor.putInt(Constants.KEY_LESSON2_LEVEL_3,0);
            editor.putInt(Constants.KEY_LESSON2_LEVEL_4,0);
            editor.putInt(Constants.KEY_LESSON2_LEVEL_5,0);
            editor.putInt(Constants.KEY_LESSON2_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON2_LEVEL_2,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON2_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON2_LEVEL_2,1);   ///  Unlock Level 2
            editor.putInt(Constants.KEY_LESSON2_LEVEL_3,0);
            editor.putInt(Constants.KEY_LESSON2_LEVEL_4,0);
            editor.putInt(Constants.KEY_LESSON2_LEVEL_5,0);
            editor.putInt(Constants.KEY_LESSON2_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON2_LEVEL_3,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON2_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON2_LEVEL_2,1);
            editor.putInt(Constants.KEY_LESSON2_LEVEL_3,1);   ///  Unlock Level 3
            editor.putInt(Constants.KEY_LESSON2_LEVEL_4,0);
            editor.putInt(Constants.KEY_LESSON2_LEVEL_5,0);
            editor.putInt(Constants.KEY_LESSON2_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON2_LEVEL_4,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON2_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON2_LEVEL_2,1);
            editor.putInt(Constants.KEY_LESSON2_LEVEL_3,1);
            editor.putInt(Constants.KEY_LESSON2_LEVEL_4,1);  ///  Unlock Level 4
            editor.putInt(Constants.KEY_LESSON2_LEVEL_5,0);
            editor.putInt(Constants.KEY_LESSON2_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON2_LEVEL_5,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON2_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON2_LEVEL_2,1);
            editor.putInt(Constants.KEY_LESSON2_LEVEL_3,1);
            editor.putInt(Constants.KEY_LESSON2_LEVEL_4,1);
            editor.putInt(Constants.KEY_LESSON2_LEVEL_5,1);    ///  Unlock Level 5
            editor.putInt(Constants.KEY_LESSON2_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON2_LEVEL_6,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON2_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON2_LEVEL_2,1);
            editor.putInt(Constants.KEY_LESSON2_LEVEL_3,1);
            editor.putInt(Constants.KEY_LESSON2_LEVEL_4,1);
            editor.putInt(Constants.KEY_LESSON2_LEVEL_5,1);
            editor.putInt(Constants.KEY_LESSON2_LEVEL_6,1);  ///  Unlock Level 6

        }
    }
    public void createLevelsForLesson3(){

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constants.KEY_LESSON3_LEVEL_1,1);
        editor.putString(Constants.KEY_CAT_LESSON3_LEVEL_1,"Unlock");
        editor.apply();

        if (sharedPreferences.getString(Constants.KEY_CAT_LESSON3_LEVEL_1,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON3_LEVEL_1,1);   ///  Unlock Level 1
            editor.putInt(Constants.KEY_LESSON3_LEVEL_2,0);
            editor.putInt(Constants.KEY_LESSON3_LEVEL_3,0);
            editor.putInt(Constants.KEY_LESSON3_LEVEL_4,0);
            editor.putInt(Constants.KEY_LESSON3_LEVEL_5,0);
            editor.putInt(Constants.KEY_LESSON3_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON3_LEVEL_2,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON3_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON3_LEVEL_2,1);   ///  Unlock Level 2
            editor.putInt(Constants.KEY_LESSON3_LEVEL_3,0);
            editor.putInt(Constants.KEY_LESSON3_LEVEL_4,0);
            editor.putInt(Constants.KEY_LESSON3_LEVEL_5,0);
            editor.putInt(Constants.KEY_LESSON3_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON3_LEVEL_3,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON3_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON3_LEVEL_2,1);
            editor.putInt(Constants.KEY_LESSON3_LEVEL_3,1);   ///  Unlock Level 3
            editor.putInt(Constants.KEY_LESSON3_LEVEL_4,0);
            editor.putInt(Constants.KEY_LESSON3_LEVEL_5,0);
            editor.putInt(Constants.KEY_LESSON3_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON3_LEVEL_4,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON3_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON3_LEVEL_2,1);
            editor.putInt(Constants.KEY_LESSON3_LEVEL_3,1);
            editor.putInt(Constants.KEY_LESSON3_LEVEL_4,1);  ///  Unlock Level 4
            editor.putInt(Constants.KEY_LESSON3_LEVEL_5,0);
            editor.putInt(Constants.KEY_LESSON3_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON3_LEVEL_5,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON3_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON3_LEVEL_2,1);
            editor.putInt(Constants.KEY_LESSON3_LEVEL_3,1);
            editor.putInt(Constants.KEY_LESSON3_LEVEL_4,1);
            editor.putInt(Constants.KEY_LESSON3_LEVEL_5,1);    ///  Unlock Level 5
            editor.putInt(Constants.KEY_LESSON3_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON3_LEVEL_6,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON3_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON3_LEVEL_2,1);
            editor.putInt(Constants.KEY_LESSON3_LEVEL_3,1);
            editor.putInt(Constants.KEY_LESSON3_LEVEL_4,1);
            editor.putInt(Constants.KEY_LESSON3_LEVEL_5,1);
            editor.putInt(Constants.KEY_LESSON3_LEVEL_6,1);  ///  Unlock Level 6

        }
    }
    public void createLevelsForLesson4(){

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constants.KEY_LESSON4_LEVEL_1,1);
        editor.putString(Constants.KEY_CAT_LESSON4_LEVEL_1,"Unlock");
        editor.apply();

        if (sharedPreferences.getString(Constants.KEY_CAT_LESSON4_LEVEL_1,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON4_LEVEL_1,1);   ///  Unlock Level 1
            editor.putInt(Constants.KEY_LESSON4_LEVEL_2,0);
            editor.putInt(Constants.KEY_LESSON4_LEVEL_3,0);
            editor.putInt(Constants.KEY_LESSON4_LEVEL_4,0);
            editor.putInt(Constants.KEY_LESSON4_LEVEL_5,0);
            editor.putInt(Constants.KEY_LESSON4_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON4_LEVEL_2,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON4_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON4_LEVEL_2,1);   ///  Unlock Level 2
            editor.putInt(Constants.KEY_LESSON4_LEVEL_3,0);
            editor.putInt(Constants.KEY_LESSON4_LEVEL_4,0);
            editor.putInt(Constants.KEY_LESSON4_LEVEL_5,0);
            editor.putInt(Constants.KEY_LESSON4_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON4_LEVEL_3,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON4_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON4_LEVEL_3,1);   ///  Unlock Level 3
            editor.putInt(Constants.KEY_LESSON4_LEVEL_4,0);
            editor.putInt(Constants.KEY_LESSON4_LEVEL_5,0);
            editor.putInt(Constants.KEY_LESSON4_LEVEL_6,0);
            editor.putInt(Constants.KEY_LESSON4_LEVEL_2,1);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON4_LEVEL_4,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON4_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON4_LEVEL_2,1);
            editor.putInt(Constants.KEY_LESSON4_LEVEL_3,1);
            editor.putInt(Constants.KEY_LESSON4_LEVEL_4,1);  ///  Unlock Level 4
            editor.putInt(Constants.KEY_LESSON4_LEVEL_5,0);
            editor.putInt(Constants.KEY_LESSON4_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON4_LEVEL_5,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON4_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON4_LEVEL_2,1);
            editor.putInt(Constants.KEY_LESSON4_LEVEL_3,1);
            editor.putInt(Constants.KEY_LESSON4_LEVEL_4,1);
            editor.putInt(Constants.KEY_LESSON4_LEVEL_5,1);    ///  Unlock Level 5
            editor.putInt(Constants.KEY_LESSON4_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON4_LEVEL_6,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON4_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON4_LEVEL_2,1);
            editor.putInt(Constants.KEY_LESSON4_LEVEL_3,1);
            editor.putInt(Constants.KEY_LESSON4_LEVEL_4,1);
            editor.putInt(Constants.KEY_LESSON4_LEVEL_5,1);
            editor.putInt(Constants.KEY_LESSON4_LEVEL_6,1);  ///  Unlock Level 6

        }
    }
    public void createLevelsForLesson5(){

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constants.KEY_LESSON5_LEVEL_1,1);
        editor.putString(Constants.KEY_CAT_LESSON5_LEVEL_1,"Unlock");
        editor.apply();

        if (sharedPreferences.getString(Constants.KEY_CAT_LESSON5_LEVEL_1,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON5_LEVEL_1,1);   ///  Unlock Level 1
            editor.putInt(Constants.KEY_LESSON5_LEVEL_2,0);
            editor.putInt(Constants.KEY_LESSON5_LEVEL_3,0);
            editor.putInt(Constants.KEY_LESSON5_LEVEL_4,0);
            editor.putInt(Constants.KEY_LESSON5_LEVEL_5,0);
            editor.putInt(Constants.KEY_LESSON5_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON5_LEVEL_2,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON5_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON5_LEVEL_2,1);   ///  Unlock Level 2
            editor.putInt(Constants.KEY_LESSON5_LEVEL_3,0);
            editor.putInt(Constants.KEY_LESSON5_LEVEL_4,0);
            editor.putInt(Constants.KEY_LESSON5_LEVEL_5,0);
            editor.putInt(Constants.KEY_LESSON5_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON5_LEVEL_3,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON5_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON5_LEVEL_3,1);   ///  Unlock Level 3
            editor.putInt(Constants.KEY_LESSON5_LEVEL_4,0);
            editor.putInt(Constants.KEY_LESSON5_LEVEL_5,0);
            editor.putInt(Constants.KEY_LESSON5_LEVEL_6,0);
            editor.putInt(Constants.KEY_LESSON5_LEVEL_2,1);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON5_LEVEL_4,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON5_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON5_LEVEL_2,1);
            editor.putInt(Constants.KEY_LESSON5_LEVEL_3,1);
            editor.putInt(Constants.KEY_LESSON5_LEVEL_4,1);  ///  Unlock Level 4
            editor.putInt(Constants.KEY_LESSON5_LEVEL_5,0);
            editor.putInt(Constants.KEY_LESSON5_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON5_LEVEL_5,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON5_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON5_LEVEL_2,1);
            editor.putInt(Constants.KEY_LESSON5_LEVEL_3,1);
            editor.putInt(Constants.KEY_LESSON5_LEVEL_4,1);
            editor.putInt(Constants.KEY_LESSON5_LEVEL_5,1);    ///  Unlock Level 5
            editor.putInt(Constants.KEY_LESSON5_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON5_LEVEL_6,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON5_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON5_LEVEL_2,1);
            editor.putInt(Constants.KEY_LESSON5_LEVEL_3,1);
            editor.putInt(Constants.KEY_LESSON5_LEVEL_4,1);
            editor.putInt(Constants.KEY_LESSON5_LEVEL_5,1);
            editor.putInt(Constants.KEY_LESSON5_LEVEL_6,1);  ///  Unlock Level 6

        }
    }
    public void createLevelsForLesson6(){

        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constants.KEY_LESSON6_LEVEL_1,1);
        editor.putString(Constants.KEY_CAT_LESSON6_LEVEL_1,"Unlock");
        editor.apply();

        if (sharedPreferences.getString(Constants.KEY_CAT_LESSON6_LEVEL_1,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON6_LEVEL_1,1);   ///  Unlock Level 1
            editor.putInt(Constants.KEY_LESSON6_LEVEL_2,0);
            editor.putInt(Constants.KEY_LESSON6_LEVEL_3,0);
            editor.putInt(Constants.KEY_LESSON6_LEVEL_4,0);
            editor.putInt(Constants.KEY_LESSON6_LEVEL_5,0);
            editor.putInt(Constants.KEY_LESSON6_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON6_LEVEL_2,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON6_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON6_LEVEL_2,1);   ///  Unlock Level 2
            editor.putInt(Constants.KEY_LESSON6_LEVEL_3,0);
            editor.putInt(Constants.KEY_LESSON6_LEVEL_4,0);
            editor.putInt(Constants.KEY_LESSON6_LEVEL_5,0);
            editor.putInt(Constants.KEY_LESSON6_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON6_LEVEL_3,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON6_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON6_LEVEL_3,1);   ///  Unlock Level 3
            editor.putInt(Constants.KEY_LESSON6_LEVEL_4,0);
            editor.putInt(Constants.KEY_LESSON6_LEVEL_5,0);
            editor.putInt(Constants.KEY_LESSON6_LEVEL_6,0);
            editor.putInt(Constants.KEY_LESSON6_LEVEL_2,1);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON6_LEVEL_4,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON6_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON6_LEVEL_2,1);
            editor.putInt(Constants.KEY_LESSON6_LEVEL_3,1);
            editor.putInt(Constants.KEY_LESSON6_LEVEL_4,1);  ///  Unlock Level 4
            editor.putInt(Constants.KEY_LESSON6_LEVEL_5,0);
            editor.putInt(Constants.KEY_LESSON6_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON6_LEVEL_5,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON6_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON6_LEVEL_2,1);
            editor.putInt(Constants.KEY_LESSON6_LEVEL_3,1);
            editor.putInt(Constants.KEY_LESSON6_LEVEL_4,1);
            editor.putInt(Constants.KEY_LESSON6_LEVEL_5,1);    ///  Unlock Level 5
            editor.putInt(Constants.KEY_LESSON6_LEVEL_6,0);

        }else  if (sharedPreferences.getString(Constants.KEY_CAT_LESSON6_LEVEL_6,"N/A").equals("Unlock")){

            editor.putInt(Constants.KEY_LESSON6_LEVEL_1,1);
            editor.putInt(Constants.KEY_LESSON6_LEVEL_2,1);
            editor.putInt(Constants.KEY_LESSON6_LEVEL_3,1);
            editor.putInt(Constants.KEY_LESSON6_LEVEL_4,1);
            editor.putInt(Constants.KEY_LESSON6_LEVEL_5,1);
            editor.putInt(Constants.KEY_LESSON6_LEVEL_6,1);  ///  Unlock Level 6

        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Lessons.this, SplashScreen.class);
        startActivity(intent);
        finish();
    }

//    private void LoadDifficultyLevel(){
//        String [] difficultyLevels = Question.getAllDifficultyLevels();
//
//        ArrayAdapter<String> adapterDifficulty = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item,difficultyLevels);
//        adapterDifficulty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerdifficulty.setAdapter(adapterDifficulty);
//    }
}