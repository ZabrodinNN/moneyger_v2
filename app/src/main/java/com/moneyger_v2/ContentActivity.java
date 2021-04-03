package com.moneyger_v2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.annotations.NotNull;

public class ContentActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    // Fragments
    private BudgetFragment budgetFragment;
    private ExpenseFragment expenseFragment;
    private StatusFragment statusFragment;
    private RemindersFragment remindersFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        setTitle("Moneyger - Money Manager App");

        bottomNavigationView = findViewById(R.id.menuBar);
        frameLayout = findViewById(R.id.main_frame);

        budgetFragment = new BudgetFragment();
        expenseFragment = new ExpenseFragment();
        statusFragment = new StatusFragment();
        remindersFragment = new RemindersFragment();

        setFragment(budgetFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.budgetButton:
                        setFragment(budgetFragment);
                        return true;

                    case R.id.expenseButton:
                        setFragment(expenseFragment);
                        return true;

                    case R.id.statusButton:
                        setFragment(statusFragment);
                        return true;

                    case R.id.reminderButton:
                        setFragment(remindersFragment);
                        return true;

                    default:
                        return false;
                }
            }
        });

    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();

    }
}