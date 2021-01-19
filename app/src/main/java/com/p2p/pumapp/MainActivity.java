package com.p2p.pumapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

import com.google.android.material.navigation.NavigationView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    public static LinkedList<ViewItem> viewItemList = new LinkedList<>();
    public static LinkedList<ViewItem> calendarList = new LinkedList<>();
    public static LinkedList<AppointmentItem> appointmentList1 = new LinkedList<AppointmentItem>();
    public static LinkedList<AppointmentItem> appointmentList2 = new LinkedList<AppointmentItem>();
    public static LinkedList<AppointmentItem> appointmentList3 = new LinkedList<AppointmentItem>();
    public static LinkedList<AppointmentItem> appointmentList4 = new LinkedList<AppointmentItem>();
    public static boolean check1 = true;
    public static boolean check2 = true;
    public static boolean check3 = true;
    public static int counselorSelected = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Notifications Fragment data
        Log.d("MainActivity", "Before initialization");
        initData();
        Log.d("MainActivity", "After initialization");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.home);
        }
    }

    private void initData(){
        //replace with actual data later!!!
        viewItemList.add(new ViewItem("Category 1", "Teacher 1", "Bring your book to class today!", "January 4, 2021"));
        viewItemList.add(new ViewItem("Category 2", "Teacher 2", "Bring your book to class today!", "January 4, 2021"));
        viewItemList.add(new ViewItem("Category 3", "Teacher 3", "Bring your book to class today!", "January 4, 2021"));

        calendarList.add(new ViewItem("January 4", "English Office Hours", "School Lunch: Pasta", "STUCO event"));
        calendarList.add(new ViewItem("January 5", "English Office Hours", "School Lunch: Pasta", "STUCO event"));
        calendarList.add(new ViewItem("January 6", "English Office Hours", "School Lunch: Pasta", "STUCO event"));
        calendarList.add(new ViewItem("January 7", "English Office Hours", "School Lunch: Pasta", "STUCO event"));
        calendarList.add(new ViewItem("January 8", "English Office Hours", "School Lunch: Pasta", "STUCO event"));

        appointmentList4.add(new AppointmentItem("Campbell", "January 12", new String[] {"9:00", "9:30", "10:00", "10:30", "12:00", "1:00", "4:00", "5:00"}));
        appointmentList4.add(new AppointmentItem("Campbell", "January 13", new String[] {"12:00", "1:00", "4:00"}));
        appointmentList4.add(new AppointmentItem("Campbell", "January 14", new String[] {"12:00", "1:00", "4:00"}));
        appointmentList3.add(new AppointmentItem("Bostic", "January 13", new String[] {"1:00", "2:00", "3:00"}));
        appointmentList3.add(new AppointmentItem("Bostic", "January 13", new String[] {"1:00"}));
        appointmentList1.add(new AppointmentItem("Gannett", "January 14", new String[] {"10:00", "4:00", "5:00"}));
        appointmentList1.add(new AppointmentItem("Gannett", "January 14", new String[] {"10:00", "4:00", "4:30", "5:00"}));
        appointmentList2.add(new AppointmentItem("Creek", "January 15", new String[] {"10:00", "4:00", "5:00"}));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.notifications:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new NotificationsFragment()).commit();
                //add real information later
                break;
            case R.id.calendar:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CalendarFragment()).commit();
                break;
            case R.id.appointments:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AppointmentsFragment()).commit();
                break;
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void buttonClick(View v) {
        switch(v.getId()) {
            case R.id.settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SettingsFragment()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        Log.d("MainActivity", "onCheckboxClicked called");

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkbox_OH:
                if (checked) {
                    findViewById(R.id.info1).setVisibility(View.VISIBLE);
                    check1=true;
                }
                else {
                    findViewById(R.id.info1).setVisibility(View.GONE);
                    check1=false;
                }
                break;
            case R.id.checkbox_lunch:
                if (checked) {
                    findViewById(R.id.info2).setVisibility(View.VISIBLE);
                    check2=true;
                }
                else {
                    findViewById(R.id.info2).setVisibility(View.GONE);
                    check2=false;
                }
                break;
            case R.id.checkbox_events:
                if (checked) {
                    findViewById(R.id.info3).setVisibility(View.VISIBLE);
                    check3=true;
                }
                else {
                    findViewById(R.id.info3).setVisibility(View.GONE);
                    check3=false;
                }
                break;
        }
    }
}
