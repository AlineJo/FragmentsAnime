package com.yousuf.fragmentsanime.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.yousuf.fragmentsanime.R;
import com.yousuf.fragmentsanime.fragments.FirstFragment;
import com.yousuf.fragmentsanime.interfaces.MediatorInterface;

public class SimpleAnimationActivity extends AppCompatActivity implements MediatorInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeFragmentTo(new FirstFragment(), FirstFragment.class.getSimpleName());
    }

    @Override
    public void changeFragmentTo(Fragment fragmentToDisplay, String tag) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right);
        ft.replace(R.id.fl_host, fragmentToDisplay, tag);
        if (fm.findFragmentByTag(tag) == null) {
            ft.addToBackStack(tag);
        }
        ft.commit();
    }

    /**
     * @return BackStackEntryCount
     */
    private int getStackCount() {
        return getSupportFragmentManager().getBackStackEntryCount();
    }

    @Override
    public void onBackPressed() {
        if (getStackCount() <= 1) {
            finish();
        } else {
            super.onBackPressed();
        }

    }


}
