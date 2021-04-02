package com.moneyger_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ExpenseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        setTitle("Moneyger -  Money Manager App");
    }
}