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

public class editBudget extends Fragment {
    View view;
    Button fragmentButton, editBudget;
    EditText editBudgetName, editBudgetValue;
    String name;
    int value;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_edit_budget, container, false);
        fragmentButton = (Button)view.findViewById(R.id.editBudget);

        editBudgetName = view.findViewById(R.id.editBudgetName);
        editBudgetValue = view.findViewById(R.id.editBudgetValue);
        editBudget = (Button) view.findViewById(R.id.editBudget);
        editBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editBudgetName.getText().toString()) || editBudgetName.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getActivity(), "Please input the budget name", Toast.LENGTH_SHORT).show();
                } else {
                    name = editBudgetName.getText().toString();
                    if (TextUtils.isEmpty(editBudgetValue.getText().toString())) {
                        Toast.makeText(getActivity(), "Please input the new budget value", Toast.LENGTH_SHORT).show();
                    } else {
                        value = Integer.parseInt(editBudgetValue.getText().toString());
                        DatabaseReference rootDatabaseRef = FirebaseDatabase.getInstance().getReference("Budget").child(name);
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
            Toast.makeText(getActivity(), "Your budget has been edited", Toast.LENGTH_SHORT).show();
        }
}