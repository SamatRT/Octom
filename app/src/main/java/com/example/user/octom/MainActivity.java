package com.example.user.octom;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private Fragment fragment;
    private RecyclerView.Adapter mAdapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_search:
                    fragment = new SearchFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fr_place, fragment).commit();
                    return true;
                case R.id.navigation_tools:
                    fragment = new ToolsFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fr_place, fragment).commit();
                    return true;
                case R.id.navigation_settings:
                    fragment = new SettingsFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fr_place, fragment).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = new SearchFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fr_place, fragment).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation_bar);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
