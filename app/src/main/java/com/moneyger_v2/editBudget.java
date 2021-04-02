package com.moneyger_v2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class editBudget extends Fragment {
    View view;
    Button fragmentButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_edit_budget, container, false);
        fragmentButton = (Button)view.findViewById(R.id.editBudget);
        return view;
    }
}