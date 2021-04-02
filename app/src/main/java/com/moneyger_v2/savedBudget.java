package com.moneyger_v2;

public class savedBudget {
    public String budgetName;
    public int value;

    public savedBudget(String budgetName, int value) {
        this.budgetName = budgetName;
        this.value = value;
    }

    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
