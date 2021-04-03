package com.moneyger_v2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ExpenseFragment extends Fragment {
    View view;
    Button new_Expense, edit_Expense, delete_Expense;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_expense, container, false);
        new_Expense = (Button) view.findViewById(R.id.addExpense);
        edit_Expense = (Button) view.findViewById(R.id.editExpense);
        delete_Expense = (Button) view.findViewById(R.id.deleteExpense);

        new_Expense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new newExpense());
            }
        });

        edit_Expense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new editExpense());
            }
        });

        delete_Expense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new deleteExpense());
            }
        });

        return view;
    }

    private void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.expenseFrame, fragment);
        fragmentTransaction.commit();
    }
}