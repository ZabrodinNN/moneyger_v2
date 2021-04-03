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

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Moneyger -  Money Manager App");

        bottomNavigationView = findViewById(R.id.menuBar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.budgetButton:
                        loadBudget(view);
                        return true;

                    case R.id.expenseButton:
                        loadExpense(view);
                        return true;

                    case R.id.statusButton:
                        loadStatus(view);
                        return true;

                    case R.id.reminderButton:
                        loadReminders(view);
                        return true;

                    default:
                        return false;

                }
            }
        });
    }

    public void loadBudget (View view) {
        Intent intent = new Intent(this, BudgetActivity.class);
        startActivity(intent);
    }

    public void loadExpense (View view) {
        Intent intent = new Intent(this, ExpenseActivity.class);
        startActivity(intent);
    }

    public void loadStatus (View view) {
        Intent intent = new Intent(this, StatusActivity.class);
        startActivity(intent);
    }

    public void loadReminders (View view) {
        Intent intent = new Intent(this, RemindersActivity.class);
        startActivity(intent);
    }
}