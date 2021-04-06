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

//A fragment for deleting budget.
public class deleteBudget extends Fragment {
    View view;
    EditText nameBudget;
    Button fragmentButton;
    Button deleteButton;
    String name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_delete_budget, container, false);
        fragmentButton = (Button)view.findViewById(R.id.deleteBudget);

        nameBudget = view.findViewById(R.id.nameBudget);
        deleteButton = (Button) view.findViewById(R.id.deleteBudget);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(nameBudget.getText().toString()) || nameBudget.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getActivity(), "Please input the budget name", Toast.LENGTH_SHORT).show();
                } else {
                    //Calls the Firebase function to delete the specific budget.
                    name = nameBudget.getText().toString();
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Budget").child(name);
                    reference.removeValue();
                    showToast();
                }
            }
        });

        return view;
    }
    //Notifies the user that the budget has been successfully deleted.
    public void showToast() {
        Toast.makeText(getActivity(), "Your budget has been deleted", Toast.LENGTH_SHORT).show();
    }
}