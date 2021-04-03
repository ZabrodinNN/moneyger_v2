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

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class editExpense extends Fragment {
    View view;
    Button fragmentButton, editExpense;
    EditText editExpenseName, editExpenseValue;
    String name;
    int value;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_edit_expense, container, false);
        fragmentButton = (Button)view.findViewById(R.id.editExpense);

        editExpenseName = view.findViewById(R.id.editExpenseName);
        editExpenseValue = view.findViewById(R.id.editExpenseValue);
        editExpense = (Button) view.findViewById(R.id.editExpense);
        editExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editExpenseName.getText().toString()) || editExpenseName.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getActivity(), "Please input the expense name", Toast.LENGTH_SHORT).show();
                } else {
                    name = editExpenseName.getText().toString();
                    if (TextUtils.isEmpty(editExpenseValue.getText().toString())) {
                        Toast.makeText(getActivity(), "Please input the new expense value", Toast.LENGTH_SHORT).show();
                    } else {
                        value = Integer.parseInt(editExpenseValue.getText().toString());
                        DatabaseReference rootDatabaseRef = FirebaseDatabase.getInstance().getReference("Expenses").child(name);
                        HashMap hashmap = new HashMap();
                        hashmap.put("budgetName", name);
                        hashmap.put("value", Integer.toString(value));

                        rootDatabaseRef.updateChildren(hashmap).addOnSuccessListener(new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {
                                showToast();
                            }
                        });
                    }
                }
            }
        });


        return view;
    }
    public void showToast() {
        Toast.makeText(getActivity(), "Your expense has been edited", Toast.LENGTH_SHORT).show();
    }
}