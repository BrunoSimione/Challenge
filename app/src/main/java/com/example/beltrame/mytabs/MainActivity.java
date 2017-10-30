package com.example.beltrame.mytabs;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    private TextView mTextMessage;

    FragmentManager fm = getFragmentManager();



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {



        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if(fm != null) {
                        AreaFragment frag1 = new AreaFragment();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.fragment_place, frag1);
                        ft.addToBackStack(null);
                        ft.commit();
                    }
                    //mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    if(fm != null) {
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.fragment_place, new SchoolFragment());
                        ft.addToBackStack(null);
                        ft.commit();
                    }
                    //mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    SchoolFragment frag3 = new SchoolFragment();
                    if(fm != null) {
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.fragment_place, new MajorFragment());
                        ft.addToBackStack(null);
                        ft.commit();
                    }
                    //mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
