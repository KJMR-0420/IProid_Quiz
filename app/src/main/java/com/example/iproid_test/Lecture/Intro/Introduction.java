package com.example.iproid_test.Lecture.Intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.iproid_test.Lecture.Intro.AOP.ArithmeticOP;
import com.example.iproid_test.Lecture.Intro.Expression.Expression;
import com.example.iproid_test.Lecture.Intro.Statement.Statement;
import com.example.iproid_test.Lecture.Intro.Variables.variable;
import com.example.iproid_test.Lecture.Lecture;
import com.example.iproid_test.R;

public class Introduction extends AppCompatActivity {
CardView Intro_var,Intro_arithmetic,Intro_expression,Intro_statement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        Intro_var = findViewById(R.id.Intro_Variable);
        Intro_arithmetic = findViewById(R.id.Intro_ArithmeticOp);
        Intro_expression = findViewById(R.id.Intro_Expression);
        Intro_statement = findViewById(R.id.Intro_Statement);


        Intro_var.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Introduction.this, variable.class));
                finish();
            }
        });
        Intro_arithmetic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Introduction.this, ArithmeticOP.class));
                finish();
            }
        });
        Intro_expression.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Introduction.this, Expression.class));
                finish();
            }
        });
        Intro_statement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Introduction.this, Statement.class));
                finish();
            }
        });
    }
    public void onBackPressed() {
        startActivity(new Intent(Introduction.this, Lecture.class));
        finish();



    }
}