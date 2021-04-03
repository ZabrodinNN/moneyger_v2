package com.moneyger_v2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatusActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        setTitle("Moneyger -  Money Manager App");

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Budget");
        tv = findViewById(R.id.textView);
        getData();
    }

    private void getData() {

        databaseReference.addValueEventListener(new ValueEventListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Map<String, Object> td = (HashMap<String, Object>) snapshot.getValue();

                //String string = snapshot.getValue(String.class); //crashing due to hash-map to string conversion
                //savedBudget sB = snapshot.getValue(savedBudget.class);  //crashing due to hash-map to string conversion

                tv.setText(td.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(StatusActivity.this, "Failed to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }

}