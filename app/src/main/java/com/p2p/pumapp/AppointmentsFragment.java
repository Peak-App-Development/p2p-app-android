package com.p2p.pumapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class AppointmentsFragment extends Fragment {
    private RecyclerView recyclerView;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Appointments");
        final View rootView = inflater.inflate(R.layout.fragment_appointments, container, false);
        recyclerView = rootView.findViewById(R.id.appointmentView);
        setRecyclerView(0);
        Spinner dropdown = rootView.findViewById(R.id.counselor_menu);
        View itemView = inflater.inflate(R.layout.appointment_item, container, false);
        RelativeLayout buttonContainer = (RelativeLayout) itemView.findViewById(R.id.button_layout);
        Log.d("AppointmentFragment", "buttonContainer" + buttonContainer);
        String[] items = new String[]{"Choose your counselor", "Gannett", "Creek", "Bostic", "Campbell"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.spinner_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                MainActivity.counselorSelected = position;
                TextView text = rootView.findViewById(R.id.nothing_selected);
                if(position==0){
                    text.setVisibility(View.VISIBLE);
                }
                else{
                    text.setVisibility(View.GONE);
                }
                setRecyclerView(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return rootView;
    }

    private void setRecyclerView(int position) {
        Log.d("AppointmentFragment", "SetRecyclerView called");
        AppointmentsAdapter recyclerViewAdapter;
        if(position==0){
            recyclerViewAdapter = new AppointmentsAdapter(null, getContext());
        }
        else if(position==1) {
             recyclerViewAdapter = new AppointmentsAdapter(MainActivity.appointmentList1, getContext());
        }
        else if(position==2){
            recyclerViewAdapter = new AppointmentsAdapter(MainActivity.appointmentList2, getContext());
        }
        else if (position==3){
            recyclerViewAdapter = new AppointmentsAdapter(MainActivity.appointmentList3, getContext());
        }
        else {
            recyclerViewAdapter = new AppointmentsAdapter(MainActivity.appointmentList4, getContext());
        }
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
