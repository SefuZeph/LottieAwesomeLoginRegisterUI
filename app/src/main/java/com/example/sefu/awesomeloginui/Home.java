package com.example.sefu.awesomeloginui;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.sefu.awesomeloginui.fragment.GroupFragment;
import com.example.sefu.awesomeloginui.fragment.HomeFragment;
import com.example.sefu.awesomeloginui.fragment.ProfileFragment;
import com.example.sefu.awesomeloginui.fragment.SettingsFragment;
import com.example.sefu.awesomeloginui.menu.DrawerAdapter;
import com.example.sefu.awesomeloginui.menu.DrawerItem;
import com.example.sefu.awesomeloginui.menu.SimpleItem;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.Arrays;

public class Home extends AppCompatActivity implements DrawerAdapter.OnItemSelectedListener {
    private static final int POS_HOME = 0;
    private static final int POS_CALENDER = 1;
    private static final int POS_OVERVIEW = 2;
    private static final int POS_GROUPS = 3;
    private static final int POS_LISTS = 4;
    private static final int POS_PROFILE = 5;
    private static final int POS_TIMELINE = 6;
    private static final int POS_SETTINGS = 7;
    private static final int POS_LOGOUT = 8;

    private String[] screenTitles;
    private Drawable[] screenIcons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(true)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.menu_left_drawer)
                .inject();

        screenIcons = loadScreenIcons();
        screenTitles = loadScreenTitles();

        DrawerAdapter adapter = new DrawerAdapter(Arrays.asList(
                createItemFor(POS_HOME).setChecked(true),
                createItemFor(POS_CALENDER),
                createItemFor(POS_OVERVIEW),
                createItemFor(POS_GROUPS),
                createItemFor(POS_LISTS),
                createItemFor(POS_PROFILE),
                createItemFor(POS_TIMELINE),
                createItemFor(POS_SETTINGS),
                //new SpaceItem(48),
                createItemFor(POS_LOGOUT)));
        adapter.setListener(this);

        RecyclerView list = (RecyclerView) findViewById(R.id.list);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);

        adapter.setSelected(POS_HOME);


    }

    @Override
    public void onItemSelected(int position) {
        if (position == POS_LOGOUT) {

            //Creating an alert dialog to confirm logout
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Are you sure you want to logout?");
            alertDialogBuilder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {

                            //Starting login activity
                            Intent intent = new Intent(getApplicationContext(), Login.class);
                            startActivity(intent);
                        }
                    });

            alertDialogBuilder.setNegativeButton("No",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {

                        }
                    });

            //Showing the alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();


        } else if (position == POS_CALENDER) {

        } else if (position == POS_OVERVIEW) {

        } else if (position == POS_SETTINGS) {

            SettingsFragment settingsFragment = new SettingsFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, settingsFragment).commit();

        } else if (position == POS_HOME) {

            HomeFragment homeFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();


        } else if (position == POS_GROUPS) {

            GroupFragment groupFragment = new GroupFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, groupFragment).commit();

        } else if (position == POS_LISTS) {

        } else if (position == POS_PROFILE) {

            ProfileFragment profileFragment = new ProfileFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment).commit();

        } else if (position == POS_TIMELINE) {

        }
//        Fragment selectedScreen = CenteredTextFragment.createFor(screenTitles[position]);
//        showFragment(selectedScreen);
    }

//    private void showFragment(Fragment fragment) {
//        getFragmentManager().beginTransaction()
//                .replace(R.id.container, fragment)
//                .commit();
//    }

    private DrawerItem createItemFor(int position) {
        return new SimpleItem(screenIcons[position], screenTitles[position])
                .withIconTint(color(R.color.textColorSecondary))
                .withTextTint(color(R.color.textColorPrimary))
                .withSelectedIconTint(color(R.color.colorAccent))
                .withSelectedTextTint(color(R.color.colorAccent));
    }

    private String[] loadScreenTitles() {
        return getResources().getStringArray(R.array.ld_activityScreenTitles);
    }

    private Drawable[] loadScreenIcons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.ld_activityScreenIcons);
        Drawable[] icons = new Drawable[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if (id != 0) {
                icons[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();
        return icons;
    }

    @ColorInt
    private int color(@ColorRes int res) {
        return ContextCompat.getColor(this, res);
    }
}
