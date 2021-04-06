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

//A fragment used for creating new reminder
public class newReminder extends Fragment {
    View view;
    String reminder;
    EditText reminderText;
    Button saveReminder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_new_reminder, container, false);
        reminderText = view.findViewById(R.id.reminderText);

        saveReminder = (Button) view.findViewById(R.id.saveReminder);
        saveReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(reminderText.getText().toString()) || reminderText.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getActivity(), "Please input a reminder", Toast.LENGTH_SHORT).show();
                } else {
                    //Creates a reminder object then calls the Firebase function to create a new reminder.
                    reminder = reminderText.getText().toString();
                    savedReminders reminders = new savedReminders(reminder);
                    showToast();
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("Reminders").child(reminder);
                    myRef.setValue(reminders);
                }
            }
        });

        return view;
    }

    //Notifies the user that the reminder has been successfully created.
    public void showToast() {
        Toast.makeText(getActivity(), "Your reminder has been saved", Toast.LENGTH_SHORT).show();
    }
}