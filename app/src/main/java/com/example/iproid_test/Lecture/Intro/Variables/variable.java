package com.example.iproid_test.Lecture.Intro.Variables;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.example.iproid_test.R;
public class variable extends AppCompatActivity {

    ViewPager viewPager;
    MyAdapter pageAdapter;
    private static final int ITEMS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variable);
        viewPager = (ViewPager)findViewById(R.id.pager);
        pageAdapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);



    }
    public void setCurrentItem (int item, boolean smoothScroll) {
        viewPager.setCurrentItem(item, smoothScroll);

    }

    public static class MyAdapter extends FragmentPagerAdapter {


        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);

        }

        @Override
        public int getCount() {
            return ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new Firstview();

            } else {
                return new Secondview();

            }
        }
    }
}