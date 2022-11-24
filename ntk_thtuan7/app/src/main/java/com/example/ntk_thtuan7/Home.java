package com.example.ntk_thtuan7;

import  androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Home extends AppCompatActivity {
    private BottomNavigationView mNavigationView;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //tắt thanh trên
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mNavigationView = findViewById(R.id.bottom_nav);
        mViewPager = findViewById(R.id.view_pager);
        setUpViewPager();

        mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        mViewPager.setCurrentItem(0);

                        break;
                    case R.id.action_list:
                        mViewPager.setCurrentItem(1);

                        break;
                    case R.id.action_profile:
                        mViewPager.setCurrentItem(2);

                        break;
                }

                return true;
            }
        });

    }

    private void setUpViewPager() {
        View_Pager_Adapter viewPagerAdapter = new View_Pager_Adapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(viewPagerAdapter);


    }
}