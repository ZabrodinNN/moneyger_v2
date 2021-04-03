package com.moneyger_v2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class deleteExpense extends Fragment {
    View view;
    EditText nameExpense;
    Button fragmentButton;
    Button deleteButton;
    String name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_delete_expense, container, false);
        fragmentButton = (Button)view.findViewById(R.id.deleteExpense);

        nameExpense = view.findViewById(R.id.nameExpense);
        deleteButton = (Button) view.findViewById(R.id.deleteExpense);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(nameExpense.getText().toString()) || nameExpense.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getActivity(), "Please input the expense name", Toast.LENGTH_SHORT).show();
                } else {
                    name = nameExpense.getText().toString();
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Expenses").child(name);
                    reference.removeValue();
                    showToast();
                }
            }
        });

        return view;
    }
    public void showToast() {
        Toast.makeText(getActivity(), "Your expense has been deleted", Toast.LENGTH_SHORT).show();
    }
}