package com.example.iproid_test.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.VideoView;

import com.example.iproid_test.Lecture.Lecture;
import com.example.iproid_test.R;

public class second_splashscreen extends AppCompatActivity {
    private static int SPLASH_SCREEN = 5000;
VideoView splashscreen2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_splashscreen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        splashscreen2 = findViewById(R.id.splashscreen2);

//        if (restorePrefData()) {
////            Intent mainActivity = new Intent(getApplicationContext(), Lecture.class);
////            startActivity(mainActivity);
////            finish();
//        }

        Uri video =Uri.parse("android.resource://"+getPackageName() + "/" + R.raw.splashcreen1);

        splashscreen2.setVideoURI(video);
        splashscreen2.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(second_splashscreen.this, Lecture.class);
                startActivity(intent);
//                savePrefsData();
                finish();
            }
        },SPLASH_SCREEN);
    }
//    private void savePrefsData() {
//        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
//        SharedPreferences.Editor editor = pref.edit();
//        editor.putBoolean("isSplashscreenOpen", true);
//        editor.commit();
//    }



//    private boolean restorePrefData() {
//        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
//        Boolean isIntroActivityOpenBefore = pref.getBoolean("isSplashscreenOpen", false);
//        return isIntroActivityOpenBefore;
//    }
@Override
public void onResume() {
    super.onResume();
    if (splashscreen2 != null) {
        splashscreen2.start();
    }
}
}