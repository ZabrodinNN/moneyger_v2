package com.moneyger_v2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

//This fragment is for handling all the fragments for all reminder functions (adding, editing, deleting).
public class RemindersFragment extends Fragment {
    View view;
    Button new_Reminder, edit_Reminder, delete_Reminder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_reminders, container, false);
        new_Reminder = (Button) view.findViewById(R.id.newReminder);
        edit_Reminder = (Button) view.findViewById(R.id.editReminder);
        delete_Reminder = (Button) view.findViewById(R.id.deleteReminder);

        new_Reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new newReminder());
            }
        });

        edit_Reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new editReminder());
            }
        });

        delete_Reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new deleteReminder());
            }
        });

        return view;
    }

    //Function used to access the three reminder fragments.
    private void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.reminderFrame, fragment);
        fragmentTransaction.commit();
    }
}