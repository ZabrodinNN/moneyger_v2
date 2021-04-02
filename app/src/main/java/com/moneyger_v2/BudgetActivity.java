package com.moneyger_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BudgetActivity extends AppCompatActivity {
    Button new_Budget, edit_Budget, delete_Budget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        new_Budget = findViewById(R.id.newBudget);
        edit_Budget = findViewById(R.id.editBudget);
        delete_Budget = findViewById(R.id.deleteBudget);

        new_Budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new newBudget());
            }
        });

        edit_Budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new editBudget());
            }
        });

        delete_Budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new deleteBudget());
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.budgetFrame, fragment);
        fragmentTransaction.commit();
    }
}