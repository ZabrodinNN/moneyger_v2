package com.moneyger_v2;


//A java class used for creating budget and expense objects to be saved.
public class savedBudget {
    public String budgetName;
    public String value;

    public savedBudget(String budgetName, String value) {
        this.budgetName = budgetName;
        this.value = value;
    }

    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
