package com.example.iproid_test.Lecture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.example.iproid_test.Quizzes_Levels.Lessons;
import com.example.iproid_test.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class test_pythonCompiler extends AppCompatActivity {
TextView Result;
Button Run;
EditText CodeArea;
BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_python_compiler);
        Result = findViewById(R.id.txtResult);
        Run = findViewById(R.id.btnRun);
        CodeArea = findViewById(R.id.CodeArea);
        bottomNavigationView = findViewById(R.id.bottomNav);

        bottomNavigationView.setSelectedItemId(R.id.Compiler);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Quizzes:
                        Intent intent = new Intent(test_pythonCompiler.this, Lessons.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Lecture:
                        Intent intent2 = new Intent(test_pythonCompiler.this, Lecture.class);
                        startActivity(intent2);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Compiler:
                        return true;
                }
                return false;
            }
        });
        //start the python
        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));

        }
// Run Button

        Run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //python instance
                Python python = Python.getInstance();
                // creating python obj
                PyObject pyobj = python.getModule("pythonscript");// give python script name
                // calling  this function
                PyObject obj = pyobj.callAttr("main", CodeArea.getText().toString());
                // setting the return to txt view
                Result.setText(obj.toString());
            }
        });
    }
}