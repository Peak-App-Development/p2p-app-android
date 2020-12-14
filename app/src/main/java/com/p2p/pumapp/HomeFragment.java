package com.p2p.pumapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<String> titles = new ArrayList<>();
    private ArrayList<String> items = new ArrayList<>();
    private ArrayList<String> items2 = new ArrayList<>();
    private ArrayList<String> items3 = new ArrayList<>();
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Home");
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = rootView.findViewById(R.id.recycler_view);
        initTitles();
        return rootView;
    }
    private void initTitles(){
        titles.add("Notifications");
        //replace items.add with the actual notification later
        items.add("Newest notification");
        items2.add("Second newest notification");
        items3.add("Third newest notification");
        titles.add("Calendar");
        //replace items.add with the actual events later
        items.add("Upcoming calendar event");
        items2.add("Upcoming calendar event");
        items3.add("Upcoming calendar event");
        titles.add("Appointments");
        //replace items.add with the actual appointments later
        items.add("Upcoming appointments");
        items2.add("Upcoming appointment");
        items3.add("Upcoming appointment");
        titles.add("Quick Links");
        //replace items.add with the actual links later
        items.add("http://peaktopeak.org/");
        items2.add("http://peaktopeak.org/");
        items3.add("http://peaktopeak.org/");
        initRecyclerView();
    }
    private void initRecyclerView(){
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(titles, items, items2, items3, getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
