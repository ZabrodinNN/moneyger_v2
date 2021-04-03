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

public class deleteReminder extends Fragment {
    View view;
    EditText nameReminder;
    Button fragmentButton;
    Button deleteButton;
    String name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_delete_reminder, container, false);
        fragmentButton = (Button)view.findViewById(R.id.deleteReminder);

        nameReminder = view.findViewById(R.id.nameReminder);
        deleteButton = (Button) view.findViewById(R.id.deleteReminder);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(nameReminder.getText().toString()) || nameReminder.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getActivity(), "Please input the reminder", Toast.LENGTH_SHORT).show();
                } else {
                    name = nameReminder.getText().toString();
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Reminders").child(name);
                    reference.removeValue();
                    showToast();
                }
            }
        });

        return view;
    }
    public void showToast() {
        Toast.makeText(getActivity(), "Your reminder has been deleted", Toast.LENGTH_SHORT).show();
    }
}