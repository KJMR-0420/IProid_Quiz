package com.example.iproid_test.Lecture.Intro.Variables;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.iproid_test.MainActivity;
import com.example.iproid_test.R;


public class Firstview extends Fragment {
    private TextView firstText;
    private Button btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_firstview,container,false);


        btn = (Button)view.findViewById(R.id.IntroVariable_viewOneBtn);

        btn.setOnClickListener(new ButtonEvent());
        return view;
    }
    private class ButtonEvent implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            new Secondview();
            ((variable)getActivity()).setCurrentItem (1, true);

        }

    }
}