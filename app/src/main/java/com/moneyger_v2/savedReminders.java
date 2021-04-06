package com.moneyger_v2;


//A java class used to create reminder objects to be saved.
public class savedReminders {
    private String reminderText;

    public savedReminders(String reminderText) {
        this.reminderText = reminderText;
    }

    public String getReminderText() {
        return reminderText;
    }

    public void setReminderText(String reminderText) {
        this.reminderText = reminderText;
    }
}
