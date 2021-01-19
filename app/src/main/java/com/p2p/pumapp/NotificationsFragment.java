package com.p2p.pumapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NotificationsFragment extends Fragment {

    private RecyclerView recyclerView;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Notifications");
        View rootView = inflater.inflate(R.layout.fragment_notifications, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        setRecyclerView();
        return rootView;
    }

    private void setRecyclerView() {
        Log.d("NotificationsFragment", "SetRecyclerView called");
        ExpandableRecyclerViewAdapter expandableRecyclerViewAdapter = new ExpandableRecyclerViewAdapter(MainActivity.viewItemList, getContext());
        recyclerView.setAdapter(expandableRecyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }


}
