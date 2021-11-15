package com.example.iproid_test.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.VideoView;

import com.example.iproid_test.Lecture.Lecture;
import com.example.iproid_test.Quizzes_Levels.Lessons;
import com.example.iproid_test.R;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_SCREEN = 7000;
    ProgressBar progressBar;
    Animation pythonlogoanim;
    ImageView androidlogo,pythonlogo;
    VideoView splashscreen1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        pythonlogoanim = AnimationUtils.loadAnimation(this,R.anim.splash_anim_bounce);

        splashscreen1 = findViewById(R.id.splashscreen1);
        Uri video =Uri.parse("android.resource://"+getPackageName() + "/" + R.raw.splashscreen2);
        splashscreen1.setVideoURI(video);
        splashscreen1.start();

        androidlogo = findViewById(R.id.android_logo);
        pythonlogo = findViewById(R.id.python_logo);

        pythonlogo.setAnimation(pythonlogoanim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, second_splashscreen.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);


    }
    @Override
    public void onResume() {
        super.onResume();
        if (splashscreen1 != null) {
            splashscreen1.start();
        }
    }
}