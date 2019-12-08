package com.example.finalproject;

public final class Expense {
    /** */
    private String item;
    private int month, day, category;
    private double amount;
    public Expense(final int setMonth, final int setDay, final int setCategory,
                   final String setItem, final double setAmount) {
        month = setMonth;
        day = setDay;
        category = setCategory;
        item = setItem;
        amount = setAmount;
    }

    public int getCategory() {
        return category;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }
    public String getItem() {
        return item;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(final double amount) {
        this.amount = amount;
    }
    public void setCategory(final int category) {
        this.category = category;
    }
    public void setDay(final int day) {
        this.day = day;
    }
    public void setItem(final String item) { this.item = item; }
    public void setMonth(final int month) {
        this.month = month;
    }
}
