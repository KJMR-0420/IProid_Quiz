package com.example.iproid_test.Quizzes_Levels;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;

import com.example.iproid_test.R;
import com.example.iproid_test.SplashScreen.SplashScreen;

public class Timer {

    private Context mContext;
    private Dialog TimerDialog;

    public Timer(android.content.Context mContext) {
        this.mContext = mContext;
    }

    public void Timer(){

        TimerDialog = new Dialog(mContext);
        TimerDialog.setContentView(R.layout.timer);

        final Button btTimer = (Button) TimerDialog.findViewById(R.id.bt_timer);

        btTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimerDialog.dismiss();
                Intent intent = new Intent(mContext, Lessons.class);
                mContext.startActivity(intent);
            }
        });

        TimerDialog.show();
        TimerDialog.setCancelable(false);
        TimerDialog.setCanceledOnTouchOutside(false);
        TimerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }
}
