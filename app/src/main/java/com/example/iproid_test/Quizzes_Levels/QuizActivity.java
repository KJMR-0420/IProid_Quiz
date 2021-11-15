package com.example.iproid_test.Quizzes_Levels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Collections;
import java.util.List;
import java.util.Locale;


import com.example.iproid_test.R;

public class QuizActivity extends AppCompatActivity {
    Button btnA,btnB,btnC,btnD;
    TextView questionText,txtTotalQuesText,timeText,txtLevelIndicator;

    QuizHelper quizHelper;

    Question currentQuestion;

    List<Question> list;

    int qid = 1;

    AnimationDrawable anim;
    Animation correctanim;
    Animation wronganim;


    public static final long COUNTDOWN_IN_MILLIS = 30000;
    long backPressedtime = 0;
    private long timeleft;
    long savetime = 0;
    private CountDownTimer countDownTimer;

    private Timer timer;

    int correct=0;
    int wrong = 0;
    int coins = 0;

    int sizeofQuiz = 5; // total number of quiz that you want to execute

    int FLAG = -1;
    AudioPlayer audioPlayer;
    String categoryValue;
    int levelsId;

    int UNLOCK_LESSON1_L2 = 0,UNLOCK_LESSON1_L3 = 0,UNLOCK_LESSON1_L4 = 0,UNLOCK_LESSON1_L5 = 0,UNLOCK_LESSON1_L6 = 0;
    int UNLOCK_LESSON2_L2 = 0,UNLOCK_LESSON2_L3 = 0,UNLOCK_LESSON2_L4 = 0,UNLOCK_LESSON2_L5 = 0,UNLOCK_LESSON2_L6 = 0;
    int UNLOCK_LESSON3_L2 = 0,UNLOCK_LESSON3_L3 = 0,UNLOCK_LESSON3_L4 = 0,UNLOCK_LESSON3_L5 = 0,UNLOCK_LESSON3_L6 = 0;
    int UNLOCK_LESSON4_L2 = 0,UNLOCK_LESSON4_L3 = 0,UNLOCK_LESSON4_L4 = 0,UNLOCK_LESSON4_L5 = 0,UNLOCK_LESSON4_L6 = 0;
    int UNLOCK_LESSON5_L2 = 0,UNLOCK_LESSON5_L3 = 0,UNLOCK_LESSON5_L4 = 0,UNLOCK_LESSON5_L5 = 0,UNLOCK_LESSON5_L6 = 0;
    int UNLOCK_LESSON6_L2 = 0,UNLOCK_LESSON6_L3 = 0,UNLOCK_LESSON6_L4 = 0,UNLOCK_LESSON6_L5 = 0,UNLOCK_LESSON6_L6 = 0;


    private final Handler handler = new Handler();
    private final Handler handler2 = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionText = findViewById(R.id.txtQuestion);
        txtTotalQuesText = findViewById(R.id.txtTotalQuestion);
        btnA = findViewById(R.id.buttonA);
        btnB = findViewById(R.id.buttonB);
        btnC = findViewById(R.id.buttonC);
        btnD = findViewById(R.id.buttonD);
        timeText = findViewById(R.id.txtTimer);
        txtLevelIndicator = findViewById(R.id.txtLevel);
        //txtDifficulty = findViewById(R.id.txtDifficulty);

        Intent intentCategoryAndLevels = getIntent();
        categoryValue = intentCategoryAndLevels.getStringExtra("Category");
        levelsId = intentCategoryAndLevels.getIntExtra("Level",0);

        timer = new Timer(this);

        correctanim = AnimationUtils.loadAnimation(this,R.anim.correct);
        correctanim.setRepeatCount(3);

        wronganim = AnimationUtils.loadAnimation(this,R.anim.wrong);
        wronganim.setRepeatCount(3);

        audioPlayer = new AudioPlayer(this);

        quizHelper = new QuizHelper(this);
        quizHelper.getReadableDatabase();
        list = quizHelper.getQuestionByLevelsAndCategory(categoryValue,levelsId);


        Collections.shuffle(list);

        currentQuestion = list.get(qid);

        txtTotalQuesText.setText(qid + " / " + sizeofQuiz);

        txtLevelIndicator.setText("Level : " + levelsId);

        QuestionUpdate();
    }

    private void QuestionUpdate(){

        btnA.setBackgroundResource(R.drawable.default_btn_color);
        btnB.setBackgroundResource(R.drawable.default_btn_color);
        btnC.setBackgroundResource(R.drawable.default_btn_color);
        btnD.setBackgroundResource(R.drawable.default_btn_color);

        questionText.setText(currentQuestion.getQuestion());
        btnA.setText(currentQuestion.getOption1());
        btnB.setText(currentQuestion.getOption2());
        btnC.setText(currentQuestion.getOption3());
        btnD.setText(currentQuestion.getOption4());

        timeleft = COUNTDOWN_IN_MILLIS;

        startCountDown();
    }

    private void SetNewQuestion(){

        qid++;

        txtTotalQuesText.setText(qid + " / " + sizeofQuiz);

        currentQuestion = list.get(qid);

        enableOption();

        QuestionUpdate();
    }

    public void buttonA(View view) {

        countDownTimer.cancel();

        disableOption();

        btnA.setBackgroundResource(R.drawable.btn_animation);
        anim = (AnimationDrawable) btnA.getBackground();
        anim.start();

        handler.postDelayed(() -> {

            if (currentQuestion.getOption1().equals(currentQuestion.getfinal_answer())){

                btnA.setBackgroundResource(R.drawable.correctanswer_color);
                btnA.startAnimation(correctanim);
                correct++;
                //correctTextUpdate(correct);

                FLAG = 1;
                audioPlayer.setAudioforEvent(FLAG);

                coins = coins + 10;
                //coinsUpdateText(coins);

                Log.i("QuizInfo","Correct");

                handler2.postDelayed(() -> {

                    if (qid != sizeofQuiz){

                        SetNewQuestion();

                    }else {

                        finalResult();
                    }


                },2000);
            }else {

                btnA.setBackgroundResource(R.drawable.wronganswer_color);
                btnA.startAnimation(wronganim);
                wrong++;
                //wrongTextUpdate(wrong);
                FLAG = 2;
                audioPlayer.setAudioforEvent(FLAG);
                Handler handler3 = new Handler();
                handler3.postDelayed(() -> {

                    if(currentQuestion.getOption2().equals(currentQuestion.getfinal_answer())){
                        btnB.setBackgroundResource(R.drawable.correctanswer_color);
                    }else if (currentQuestion.getOption3().equals(currentQuestion.getfinal_answer())){
                        btnC.setBackgroundResource(R.drawable.correctanswer_color);
                    }else {
                        btnD.setBackgroundResource(R.drawable.correctanswer_color);
                    }
                },2000);

                Handler handler4 = new Handler();
                handler4.postDelayed(() -> {

                    if (qid != sizeofQuiz){

                        SetNewQuestion();

                    }else {
                        finalResult();
                    }
                },3000);


            }


        },5000);
    }

    public void buttonB(View view) {
        countDownTimer.cancel();

        disableOption();

        btnB.setBackgroundResource(R.drawable.btn_animation);
        anim = (AnimationDrawable) btnB.getBackground();
        anim.start();

        handler.postDelayed(() -> {

            if (currentQuestion.getOption2().equals(currentQuestion.getfinal_answer())){

                btnB.setBackgroundResource(R.drawable.correctanswer_color);
                btnB.startAnimation(correctanim);
                correct++;
                //correctTextUpdate(correct);

                FLAG = 1;
                audioPlayer.setAudioforEvent(FLAG);

                coins = coins + 10;
                //coinsUpdateText(coins);

                Log.i("QuizInfo","Correct");

                handler2.postDelayed(() -> {

                    if (qid != sizeofQuiz){

                        SetNewQuestion();

                    }else {

                        finalResult();
                    }


                },2000);
            }else {

                btnB.setBackgroundResource(R.drawable.wronganswer_color);
                btnB.startAnimation(wronganim);
                wrong++;
                //wrongTextUpdate(wrong);
                FLAG = 2;
                audioPlayer.setAudioforEvent(FLAG);
                Handler handler3 = new Handler();
                handler3.postDelayed(() -> {

                    if(currentQuestion.getOption1().equals(currentQuestion.getfinal_answer())){
                        btnA.setBackgroundResource(R.drawable.correctanswer_color);
                    }else if (currentQuestion.getOption3().equals(currentQuestion.getfinal_answer())){
                        btnC.setBackgroundResource(R.drawable.correctanswer_color);
                    }else {
                        btnD.setBackgroundResource(R.drawable.correctanswer_color);
                    }
                },2000);

                Handler handler4 = new Handler();
                handler4.postDelayed(() -> {

                    if (qid != sizeofQuiz){

                        SetNewQuestion();

                    }else {
                         finalResult();
                    }
                },3000);


            }


        },5000);


    }

    public void buttonC(View view) {
        countDownTimer.cancel();

        disableOption();

        btnC.setBackgroundResource(R.drawable.btn_animation);
        anim = (AnimationDrawable) btnC.getBackground();
        anim.start();

        handler.postDelayed(() -> {

            if (currentQuestion.getOption3().equals(currentQuestion.getfinal_answer())){

                btnC.setBackgroundResource(R.drawable.correctanswer_color);
                btnC.startAnimation(correctanim);
                correct++;
                //correctTextUpdate(correct);

                FLAG = 1;
                audioPlayer.setAudioforEvent(FLAG);

                coins = coins + 10;
                //coinsUpdateText(coins);

                Log.i("QuizInfo","Correct");

                handler2.postDelayed(() -> {

                    if (qid != sizeofQuiz){

                        SetNewQuestion();

                    }else {

                       finalResult();
                    }


                },2000);
            }else {

                btnC.setBackgroundResource(R.drawable.wronganswer_color);
                btnC.startAnimation(wronganim);
                wrong++;
                //wrongTextUpdate(wrong);
                FLAG = 2;
                audioPlayer.setAudioforEvent(FLAG);
                Handler handler3 = new Handler();
                handler3.postDelayed(() -> {

                    if(currentQuestion.getOption2().equals(currentQuestion.getfinal_answer())){
                        btnB.setBackgroundResource(R.drawable.correctanswer_color);
                    }else if (currentQuestion.getOption1().equals(currentQuestion.getfinal_answer())){
                        btnC.setBackgroundResource(R.drawable.correctanswer_color);
                    }else {
                        btnD.setBackgroundResource(R.drawable.correctanswer_color);
                    }
                },2000);

                Handler handler4 = new Handler();
                handler4.postDelayed(() -> {

                    if (qid != sizeofQuiz){

                        SetNewQuestion();

                    }else {
                        finalResult();
                    }
                },3000);


            }


        },5000);

    }

    public void buttonD(View view) {
        countDownTimer.cancel();
        disableOption();

        btnD.setBackgroundResource(R.drawable.btn_animation);
        anim = (AnimationDrawable) btnD.getBackground();
        anim.start();

        handler.postDelayed(() -> {

            if (currentQuestion.getOption4().equals(currentQuestion.getfinal_answer())){

                btnD.setBackgroundResource(R.drawable.correctanswer_color);
                btnD.startAnimation(correctanim);
                wrong++;
                //correctTextUpdate(correct);

                FLAG = 1;
                audioPlayer.setAudioforEvent(FLAG);
                correct++;
                coins = coins + 10;
                //coinsUpdateText(coins);

                Log.i("QuizInfo","Correct");

                handler2.postDelayed(() -> {

                    if (qid != sizeofQuiz){

                        SetNewQuestion();

                    }else {

                        finalResult();
                    }


                },2000);
            }else {

                btnD.setBackgroundResource(R.drawable.wronganswer_color);
                btnD.startAnimation(wronganim);
                //wrongTextUpdate(wrong);
                FLAG = 2;
                audioPlayer.setAudioforEvent(FLAG);
                Handler handler3 = new Handler();
                handler3.postDelayed(() -> {

                    if(currentQuestion.getOption2().equals(currentQuestion.getfinal_answer())){
                        btnB.setBackgroundResource(R.drawable.correctanswer_color);
                    }else if (currentQuestion.getOption3().equals(currentQuestion.getfinal_answer())){
                        btnC.setBackgroundResource(R.drawable.correctanswer_color);
                    }else {
                        btnA.setBackgroundResource(R.drawable.correctanswer_color);
                    }
                },2000);

                Handler handler4 = new Handler();
                handler4.postDelayed(() -> {

                    if (qid != sizeofQuiz){

                        SetNewQuestion();

                    }else {
                        finalResult();
                    }
                },3000);


            }


        },5000);


    }

    private void startCountDown(){

        countDownTimer = new CountDownTimer(timeleft,1000) {
            @Override
            public void onTick(long millsUnilFinished) {
                timeleft = millsUnilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {

                timeleft = 0;
                updateCountDownText();

            }
        }.start();


    }

    private void updateCountDownText(){


        int seconds = (int) (timeleft/1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(),"%02d",seconds);
        savetime = Long.parseLong(timeFormatted);
        timeText.setText(timeFormatted);

        if (timeleft < 10000){

            timeText.setTextColor(ContextCompat.getColor(this,R.color.red));

        }else {

            timeText.setTextColor(ContextCompat.getColor(this,R.color.green));

        }

        if (timeleft == 0){

            Toast.makeText(this, "Times Up!", Toast.LENGTH_SHORT).show();

            handler.postDelayed(() -> timer.Timer(),2000);

        }

    }

    private void disableOption(){
        btnA.setEnabled(false);
        btnB.setEnabled(false);
        btnC.setEnabled(false);
        btnD.setEnabled(false);

    }

    private void enableOption(){
        btnA.setEnabled(true);
        btnB.setEnabled(true);
        btnC.setEnabled(true);
        btnD.setEnabled(true);

    }
    private void finalResult(){

        unLockLessonLevels();

        Intent resultIntent = new Intent(QuizActivity.this,Result.class);
        resultIntent.putExtra(Constants.TOTAL_QUESTIONS,sizeofQuiz);
        resultIntent.putExtra(Constants.COINS,coins);
        resultIntent.putExtra(Constants.WRONG,wrong);
        resultIntent.putExtra(Constants.CORRECT,correct);
        resultIntent.putExtra("Category",categoryValue);
        resultIntent.putExtra("Level",levelsId);
        startActivity(resultIntent);
        finish();


    }
    private void unLockLessonLevels(){

        unLockLesson1Levels();
        unLockLesson2Levels();
        unLockLesson3Levels();
        unLockLesson4Levels();
        unLockLesson5Levels();
        unLockLesson6Levels();

    }
    private void unLockLesson1Levels(){
        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);


        if (levelsId == 1 && categoryValue.equals("LESSON1")){
            // The active level is 1, So we need to unlock the Level 2
            UNLOCK_LESSON1_L2 = correct;
            if (UNLOCK_LESSON1_L2 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON1_LEVEL_2,1);    /// Unlock the level 2
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON1_LEVEL_2,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 2 && categoryValue.equals("LESSON1")){
            // The active level is 2, So we need to unlock the Level 3
            UNLOCK_LESSON1_L3 = correct;
            if (UNLOCK_LESSON1_L3 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON1_LEVEL_3,1);    /// Unlock the level 3
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON1_LEVEL_3,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 3 && categoryValue.equals("LESSON1")){
            // The active level is 3, So we need to unlock the Level 4
            UNLOCK_LESSON1_L4 = correct;
            if (UNLOCK_LESSON1_L4 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON1_LEVEL_4,1);    /// Unlock the level 4
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON1_LEVEL_4,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 4 && categoryValue.equals("LESSON1")){
            // The active level is 4, So we need to unlock the Level 5
            UNLOCK_LESSON1_L5 = correct;
            if (UNLOCK_LESSON1_L5 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON1_LEVEL_5,1);    /// Unlock the level 5
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON1_LEVEL_5,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 5 && categoryValue.equals("LESSON1")){
            // The active level is 5, So we need to unlock the Level 6
            UNLOCK_LESSON1_L6 = correct;
            if (UNLOCK_LESSON1_L6 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON1_LEVEL_6,1);    /// Unlock the level 6
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON1_LEVEL_6,"Unlock");
                editor1.apply();
            }
        }
    }
    private void unLockLesson2Levels(){
        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);


        if (levelsId == 1 && categoryValue.equals("LESSON2")){
            // The active level is 1, So we need to unlock the Level 2
            UNLOCK_LESSON2_L2 = correct;
            if (UNLOCK_LESSON2_L2 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON2_LEVEL_2,1);    /// Unlock the level 2
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON2_LEVEL_2,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 2 && categoryValue.equals("LESSON2")){
            // The active level is 2, So we need to unlock the Level 3
            UNLOCK_LESSON2_L3 = correct;
            if (UNLOCK_LESSON2_L3 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON2_LEVEL_3,1);    /// Unlock the level 3
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON2_LEVEL_3,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 3 && categoryValue.equals("LESSON2")){
            // The active level is 3, So we need to unlock the Level 4
            UNLOCK_LESSON2_L4 = correct;
            if (UNLOCK_LESSON2_L4 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON2_LEVEL_4,1);    /// Unlock the level 4
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON2_LEVEL_4,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 4 && categoryValue.equals("LESSON2")){
            // The active level is 4, So we need to unlock the Level 5
            UNLOCK_LESSON2_L5 = correct;
            if (UNLOCK_LESSON2_L5 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON2_LEVEL_5,1);    /// Unlock the level 5
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON2_LEVEL_5,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 5 && categoryValue.equals("LESSON2")){
            // The active level is 5, So we need to unlock the Level 6
            UNLOCK_LESSON2_L6 = correct;
            if (UNLOCK_LESSON2_L6 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON2_LEVEL_6,1);    /// Unlock the level 6
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON2_LEVEL_6,"Unlock");
                editor1.apply();
            }
        }
    }
    private void unLockLesson3Levels(){
        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);


        if (levelsId == 1 && categoryValue.equals("LESSON3")){
            // The active level is 1, So we need to unlock the Level 2
            UNLOCK_LESSON3_L2 = correct;
            if (UNLOCK_LESSON3_L2 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON3_LEVEL_2,1);    /// Unlock the level 2
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON3_LEVEL_2,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 2 && categoryValue.equals("LESSON3")){
            // The active level is 2, So we need to unlock the Level 3
            UNLOCK_LESSON3_L3 = correct;
            if (UNLOCK_LESSON3_L3 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON3_LEVEL_3,1);    /// Unlock the level 3
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON3_LEVEL_3,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 3 && categoryValue.equals("LESSON3")){
            // The active level is 3, So we need to unlock the Level 4
            UNLOCK_LESSON3_L4 = correct;
            if (UNLOCK_LESSON3_L4 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON3_LEVEL_4,1);    /// Unlock the level 4
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON3_LEVEL_4,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 4 && categoryValue.equals("LESSON3")){
            // The active level is 4, So we need to unlock the Level 5
            UNLOCK_LESSON3_L5 = correct;
            if (UNLOCK_LESSON3_L5 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON3_LEVEL_5,1);    /// Unlock the level 5
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON3_LEVEL_5,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 5 && categoryValue.equals("LESSON3")){
            // The active level is 5, So we need to unlock the Level 6
            UNLOCK_LESSON3_L6 = correct;
            if (UNLOCK_LESSON3_L6 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON3_LEVEL_6,1);    /// Unlock the level 6
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON3_LEVEL_6,"Unlock");
                editor1.apply();
            }
        }

    }
    private void unLockLesson4Levels(){
        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);


        if (levelsId == 1 && categoryValue.equals("LESSON4")){
            // The active level is 1, So we need to unlock the Level 2
            UNLOCK_LESSON4_L2 = correct;
            if (UNLOCK_LESSON4_L2 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON4_LEVEL_2,1);    /// Unlock the level 2
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON4_LEVEL_2,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 2 && categoryValue.equals("LESSON4")){
            // The active level is 2, So we need to unlock the Level 3
            UNLOCK_LESSON4_L3 = correct;
            if (UNLOCK_LESSON4_L3 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON4_LEVEL_3,1);    /// Unlock the level 3
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON4_LEVEL_3,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 3 && categoryValue.equals("LESSON4")){
            // The active level is 3, So we need to unlock the Level 4
            UNLOCK_LESSON4_L4 = correct;
            if (UNLOCK_LESSON4_L4 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON4_LEVEL_4,1);    /// Unlock the level 4
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON4_LEVEL_4,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 4 && categoryValue.equals("LESSON4")){
            // The active level is 4, So we need to unlock the Level 5
            UNLOCK_LESSON4_L5 = correct;
            if (UNLOCK_LESSON4_L5 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON4_LEVEL_5,1);    /// Unlock the level 5
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON4_LEVEL_5,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 5 && categoryValue.equals("LESSON4")){
            // The active level is 5, So we need to unlock the Level 6
            UNLOCK_LESSON4_L6 = correct;
            if (UNLOCK_LESSON4_L6 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON4_LEVEL_6,1);    /// Unlock the level 6
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON4_LEVEL_6,"Unlock");
                editor1.apply();
            }
        }

    }
    private void unLockLesson5Levels(){
        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);


        if (levelsId == 1 && categoryValue.equals("LESSON5")){
            // The active level is 1, So we need to unlock the Level 2
            UNLOCK_LESSON5_L2 = correct;
            if (UNLOCK_LESSON5_L2 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON5_LEVEL_2,1);    /// Unlock the level 2
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON5_LEVEL_2,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 2 && categoryValue.equals("LESSON5")){
            // The active level is 2, So we need to unlock the Level 3
            UNLOCK_LESSON5_L3 = correct;
            if (UNLOCK_LESSON5_L3 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON5_LEVEL_3,1);    /// Unlock the level 3
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON5_LEVEL_3,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 3 && categoryValue.equals("LESSON5")){
            // The active level is 3, So we need to unlock the Level 4
            UNLOCK_LESSON5_L4 = correct;
            if (UNLOCK_LESSON5_L4 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON5_LEVEL_4,1);    /// Unlock the level 4
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON5_LEVEL_4,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 4 && categoryValue.equals("LESSON5")){
            // The active level is 4, So we need to unlock the Level 5
            UNLOCK_LESSON5_L5 = correct;
            if (UNLOCK_LESSON5_L5 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON5_LEVEL_5,1);    /// Unlock the level 5
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON5_LEVEL_5,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 5 && categoryValue.equals("LESSON5")){
            // The active level is 5, So we need to unlock the Level 6
            UNLOCK_LESSON5_L6 = correct;
            if (UNLOCK_LESSON5_L6 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON5_LEVEL_6,1);    /// Unlock the level 6
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON5_LEVEL_6,"Unlock");
                editor1.apply();
            }
        }
    }
    private void unLockLesson6Levels(){
        SharedPreferences sharedPreferences =
                getSharedPreferences(getPackageName() + Constants.MY_LEVEL_PREFFILE,
                        Context.MODE_PRIVATE);


        if (levelsId == 1 && categoryValue.equals("LESSON6")){
            // The active level is 1, So we need to unlock the Level 2
            UNLOCK_LESSON6_L2 = correct;
            if (UNLOCK_LESSON6_L2 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON6_LEVEL_2,1);    /// Unlock the level 2
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON6_LEVEL_2,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 2 && categoryValue.equals("LESSON6")){
            // The active level is 2, So we need to unlock the Level 3
            UNLOCK_LESSON6_L3 = correct;
            if (UNLOCK_LESSON6_L3 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON6_LEVEL_3,1);    /// Unlock the level 3
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON6_LEVEL_3,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 3 && categoryValue.equals("LESSON6")){
            // The active level is 3, So we need to unlock the Level 4
            UNLOCK_LESSON6_L4 = correct;
            if (UNLOCK_LESSON6_L4 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON6_LEVEL_4,1);    /// Unlock the level 4
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON6_LEVEL_4,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 4 && categoryValue.equals("LESSON6")){
            // The active level is 4, So we need to unlock the Level 5
            UNLOCK_LESSON6_L5 = correct;
            if (UNLOCK_LESSON6_L5 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON6_LEVEL_5,1);    /// Unlock the level 5
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON6_LEVEL_5,"Unlock");
                editor1.apply();
            }
        }else if (levelsId == 5 && categoryValue.equals("LESSON6")){
            // The active level is 5, So we need to unlock the Level 6
            UNLOCK_LESSON6_L6 = correct;
            if (UNLOCK_LESSON6_L6 >=3){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Constants.KEY_LESSON6_LEVEL_6,1);    /// Unlock the level 6
                editor.apply();
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString(Constants.KEY_CAT_LESSON3_LEVEL_6,"Unlock");
                editor1.apply();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        countDownTimer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        countDownTimer.cancel();
    }

    @Override
    protected void onStop() {
        super.onStop();
        countDownTimer.cancel();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countDownTimer.cancel();
        finish();
    }

    @Override
    public void onBackPressed() {
        countDownTimer.cancel();

        if (backPressedtime+ 2000 > System.currentTimeMillis()){
            Intent intent = new Intent(QuizActivity.this,Lessons.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, "Press Again to Exit", Toast.LENGTH_SHORT).show();
        }

        backPressedtime = System.currentTimeMillis();


    }
}