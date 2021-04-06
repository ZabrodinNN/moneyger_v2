package com.moneyger_v2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//A fragment used for creating new expense
public class newExpense extends Fragment {
    View view;
    String name;
    int cost;
    EditText expenseName;
    EditText expenseValue;
    Button saveExpense;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_new_expense, container, false);

        expenseName = view.findViewById(R.id.expenseName);
        expenseValue = view.findViewById(R.id.expenseValue);

        saveExpense = (Button) view.findViewById(R.id.saveExpense);
        saveExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(expenseName.getText().toString()) || expenseName.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getActivity(), "Please input the expense name", Toast.LENGTH_SHORT).show();
                } else {
                    name = expenseName.getText().toString();
                    if (TextUtils.isEmpty(expenseValue.getText().toString())) {
                        Toast.makeText(getActivity(), "Please input the expense cost", Toast.LENGTH_SHORT).show();
                    } else {
                        //Creates an expense object then calls the Firebase function to create a new expense.
                        cost = Integer.parseInt( expenseValue.getText().toString());
                        savedBudget expense = new savedBudget(name, Integer.toString(cost));
                        showToast();
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference myRef = database.getReference("Expenses").child(name);
                        myRef.setValue(expense);
                    }
                }
            }
        });

        return view;
    }

    //Notifies the user that the expense has been successfully created.
    public void showToast() {
        Toast.makeText(getActivity(), "Your expense has been saved", Toast.LENGTH_SHORT).show();
    }
}