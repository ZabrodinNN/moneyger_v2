package com.moneyger_v2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

//This fragment is for handling all the fragments for all budget functions (adding, editing, deleting).
public class BudgetFragment extends Fragment {
    View view;
    Button new_Budget, edit_Budget, delete_Budget;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_budget, container, false);
        new_Budget = (Button) view.findViewById(R.id.newBudget);
        edit_Budget = (Button) view.findViewById(R.id.editBudget);
        delete_Budget = (Button) view.findViewById(R.id.deleteBudget);

        new_Budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new newBudget());
            }
        });

        edit_Budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new editBudget());
            }
        });

        delete_Budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new deleteBudget());
            }
        });

        return view;
    }

    //Function used to access the three budget fragments.
    private void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.budgetFrame, fragment);
        fragmentTransaction.commit();
    }
}