package com.p2p.pumapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Settings");
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        Spinner dropdown1 = rootView.findViewById(R.id.quick_links1);
        Spinner dropdown2 = rootView.findViewById(R.id.quick_links2);
        Spinner dropdown3 = rootView.findViewById(R.id.quick_links3);
        String[] items = new String[]{"Choose a quick Link", "Infinite Campus", "Peak to Peak Website", "Naviance", "Google Classroom", "BVSD Single Sign On", "AP Classroom", "Gmail", "Google Calendar"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.spinner_item2, items);
        dropdown1.setAdapter(adapter);
        dropdown2.setAdapter(adapter);
        dropdown3.setAdapter(adapter);
        return rootView;
    }
}
