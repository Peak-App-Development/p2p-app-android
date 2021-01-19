package com.p2p.pumapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CalendarFragment extends Fragment {
    private RecyclerView recyclerView;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Calendar");
        View rootView = inflater.inflate(R.layout.fragment_calendar, container, false);
        recyclerView = rootView.findViewById(R.id.calendarView);
        setRecyclerView();
        return rootView;
    }

    private void setRecyclerView() {
        Log.d("CalendarFragment", "SetRecyclerView called");
        ExpandableRecyclerViewAdapter expandableRecyclerViewAdapter = new ExpandableRecyclerViewAdapter(MainActivity.calendarList, getContext());
        recyclerView.setAdapter(expandableRecyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}
