package com.rodrigo.damazod.platzigram.view;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.rodrigo.damazod.platzigram.R;
import com.rodrigo.damazod.platzigram.view.fragment.HomeFragment;
import com.rodrigo.damazod.platzigram.view.fragment.ProfileFragment;
import com.rodrigo.damazod.platzigram.view.fragment.SearchFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.btn_nav_view);
        bottomNavigationView.setSelectedItemId(R.id.menu_home);
            changeFragment(R.id.container,new HomeFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch(item.getItemId()){
                case R.id.menu_search:
                    changeFragment(R.id.container,new SearchFragment());
                    break;
                case R.id.menu_home:
                    changeFragment(R.id.container,new HomeFragment());
                    break;
                case R.id.menu_profile:
                    changeFragment(R.id.container,new ProfileFragment());
                    break;
            }
            return false;
        });
    }

    public void changeFragment(int container,Fragment toFragment){
        getSupportFragmentManager().beginTransaction()
                .replace(container,toFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null)
                .commit();
    }
}
