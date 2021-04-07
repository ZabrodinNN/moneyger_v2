package com.moneyger_v2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.NotNull;

//This activity handles the functions for the Main Activity
//This is also called when the application is launched
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Moneyger - Money Manager App");
    }

    //Function to load Content Activity when Button is clicked
    public void loadContent (View view) {
        Intent intent = new Intent(this, ContentActivity.class);
        startActivity(intent);
    }
}