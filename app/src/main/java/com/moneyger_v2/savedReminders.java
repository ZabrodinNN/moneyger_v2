package com.moneyger_v2;

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
