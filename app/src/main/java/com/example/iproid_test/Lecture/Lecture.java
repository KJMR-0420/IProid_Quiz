package com.example.iproid_test.Lecture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;
import com.example.iproid_test.Lecture.Intro.*;
import com.example.iproid_test.Quizzes_Levels.Lessons;
import com.example.iproid_test.R;
import com.example.iproid_test.SplashScreen.SplashScreen;
import com.example.iproid_test.SplashScreen.second_splashscreen;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Lecture extends AppCompatActivity implements View.OnClickListener {
    Button Lecture_IntroPython,Lecture_OOPinPython,Lecture_NumpyandPandas;
    BottomNavigationView bottomNavigationView;
    VideoView lecturebg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture);

        // Lecture Button
        Lecture_IntroPython = findViewById(R.id.btn_Lecture_IntroPython);
        Lecture_OOPinPython = findViewById(R.id.btn_Lecture_OOPInPython);
        Lecture_NumpyandPandas = findViewById(R.id.btn_Lecture_NumpyandPandas);

        Lecture_IntroPython.setOnClickListener(this);
        Lecture_OOPinPython.setOnClickListener(this);
        Lecture_NumpyandPandas.setOnClickListener(this);

        //Button Nav and background Video
        bottomNavigationView = findViewById(R.id.bottomNav);
        lecturebg = findViewById(R.id.lecturebg);
        bottomNavigationView.setSelectedItemId(R.id.Lecture);

        lecturebg = findViewById(R.id.lecturebg);

        Uri video =Uri.parse("android.resource://"+getPackageName() + "/" + R.raw.splashcreen1);

        lecturebg.setVideoURI(video);

        lecturebg.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });lecturebg.start();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
                switch (item.getItemId()){

                    case R.id.Quizzes:
                        Intent intent = new Intent(Lecture.this, Lessons.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Lecture:
                        return true;
                    case R.id.Compiler:
                        Intent intent2 = new Intent(Lecture.this, test_pythonCompiler.class);
                        startActivity(intent2);
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        if (lecturebg != null) {
            lecturebg.start();
        }
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Lecture.this, SplashScreen.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_Lecture_IntroPython:
                startActivity(new Intent(Lecture.this, Introduction.class));
                finish();
            case R.id.btn_Lecture_OOPInPython:
                startActivity(new Intent(Lecture.this, Introduction.class));
                finish();
            case R.id.btn_Lecture_NumpyandPandas:
                startActivity(new Intent(Lecture.this, Introduction.class));
                finish();
        }

    }


    private boolean restorePrefData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        Boolean isIntroActivityOpenBefore = pref.getBoolean("isSplashscreenOpen", false);
        return isIntroActivityOpenBefore;
    }
}