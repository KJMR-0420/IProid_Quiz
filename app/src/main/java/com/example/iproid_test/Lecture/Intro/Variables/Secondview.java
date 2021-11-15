package com.example.iproid_test.Lecture.Intro.Variables;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.opengl.Visibility;
import android.os.Bundle;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iproid_test.R;
import com.google.android.material.snackbar.Snackbar;

public class Secondview extends Fragment implements View.OnClickListener{
     CoordinatorLayout coordinatorLayout;
     TextView Answer,FinalAnswer;
     Button secondViewBtn, Opt1,Opt2,Opt3;
     boolean clicked = false ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_secondview,container,false);

        coordinatorLayout = view.findViewById(R.id.IntroVariable_CoordinatorLayout);
        Answer =view.findViewById(R.id.txt_Intro_Variable_answer);
        FinalAnswer =view.findViewById(R.id.Intro_Variable_FinalAnswer);

        secondViewBtn =view.findViewById(R.id.IntroVariable_viewTwoBtn);
        Opt1 = view.findViewById(R.id.Intro_CEOpt1);
        Opt2 = view.findViewById(R.id.Intro_CEOpt2);
        Opt3 = view.findViewById(R.id.Intro_CEOpt3);

        FinalAnswer.setVisibility(View.INVISIBLE);
//        RotateAnimation rotateAnimation1 = new RotateAnimation(0, 100, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//        rotateAnimation1.setDuration(1500);
//        rotateAnimation1.setInterpolator(new LinearInterpolator());
//        quoteOneShareButton.startAnimation(rotateAnimation1)

        secondViewBtn.setOnClickListener(this);
        Opt1.setOnClickListener(this);
        Opt2.setOnClickListener(this);
        Opt3.setOnClickListener(this);
        return view;

    }
    public void NoAnswerSnackbar(){
        Snackbar snackbar = Snackbar.make(coordinatorLayout, "Please Answer the Following Exercise",Snackbar.LENGTH_INDEFINITE)
                .setTextColor(Color.GRAY);
        snackbar.show();
    }
    public void CorrectSnackbar(){
        Snackbar snackbar = Snackbar.make(coordinatorLayout, "Correct Answer ",Snackbar.LENGTH_INDEFINITE)
                .setAction("Next", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondViewBtn.setVisibility(View.VISIBLE);
                secondViewBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(),"Text!",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        })
                .setTextColor(Color.GREEN);
        snackbar.show();
    }
    public void WrongSnackbar(){
        Snackbar snackbar = Snackbar.make(coordinatorLayout, "Wrong Answer ",Snackbar.LENGTH_INDEFINITE)
                .setAction("Try Again", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Opt1.setEnabled(true);
                        Opt2.setEnabled(true);
                        Opt3.setEnabled(true);
                        secondViewBtn.setVisibility(View.VISIBLE);
                        Answer.setTextColor(Color.GRAY);

                    }
                }).setActionTextColor(Color.RED);

        snackbar.show();
    }
public void Option1(){
    FinalAnswer.setVisibility(View.VISIBLE);
    FinalAnswer.setTextColor(Color.GREEN);
    Answer.setText("Score = 10");
    Answer.setTextColor(Color.GREEN);
    secondViewBtn.setVisibility(View.INVISIBLE);
    Opt2.setEnabled(false);
    Opt3.setEnabled(false);
}
public void Option2(){
    if(Opt2.isPressed()){
        secondViewBtn.setVisibility(View.INVISIBLE);
    }
    else{
        secondViewBtn.setVisibility(View.VISIBLE);
    }
    FinalAnswer.setVisibility(View.INVISIBLE);
    Answer.setText("SCORES = 10");
    Answer.setTextColor(Color.RED);
    Opt1.setEnabled(false);
    Opt3.setEnabled(false);
}
public void Option3(){
        if(Opt3.isPressed()){
            secondViewBtn.setVisibility(View.INVISIBLE);
        }
        else{
            secondViewBtn.setVisibility(View.VISIBLE);
        }
    FinalAnswer.setVisibility(View.INVISIBLE);
    Answer.setTextColor(Color.RED);
    Answer.setText("SCORE = 10");
    Opt1.setEnabled(false);
    Opt2.setEnabled(false);
}

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.Intro_CEOpt1:
                Option1();
                CorrectSnackbar();
                clicked = true;
//                if(clicked){
//
//                }
//                else {
//                    NoAnswerSnackbar();
//                }
                break;
            case R.id.Intro_CEOpt2:
                Option2();
                WrongSnackbar();
                break;
            case R.id.Intro_CEOpt3:
                Option3();
                WrongSnackbar();
                break;
            case R.id.IntroVariable_viewTwoBtn:
                if(!Opt1.isPressed() && !Opt2.isPressed() && !Opt3.isPressed()){
                    NoAnswerSnackbar();
                }
//                if(Opt1.isSelected() && FinalAnswer.getVisibility() == View.VISIBLE){
//                    Snackbar snackbar = Snackbar.make(coordinatorLayout, "Congrats", Snackbar.LENGTH_INDEFINITE);
//                    snackbar.setAction("dismiss", new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            snackbar.dismiss();
//                        }
//                    });
//                    snackbar.show();
//                }

            default:
                return;
                //Toast.makeText();
        }
    }

}