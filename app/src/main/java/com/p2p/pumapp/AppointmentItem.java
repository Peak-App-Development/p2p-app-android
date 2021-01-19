package com.p2p.pumapp;

import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class AppointmentItem {
    private String counselor;
    private String date;
    private String[] timeSlots;
    private boolean expandable;

    public AppointmentItem(String counselor, String categoryTitle, String[] timeSlots){
        this.counselor = counselor;
        this.date = categoryTitle;
        this.timeSlots = timeSlots;
        expandable = false;
    }

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String[] getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(String[] timeSlots) {
        this.timeSlots = timeSlots;
    }

    public String getCounselor() {
        return counselor;
    }

    public void setCounselor(String counselor) {
        this.counselor = counselor;
    }
}
