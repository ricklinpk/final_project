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

    public String getCategory() {
        String categoryStr = "";
        switch (category){
            case Constants.FOOD:
                categoryStr = "FOOD";
                break;
            case Constants.TRANSPORTATION:
                categoryStr = "TRANSPORTATION";
                break;
            case Constants.DRINK:
                categoryStr = "DRINK";
                break;
            case Constants.ELECTRONICS:
                categoryStr = "ELECTRONICS";
                break;
            case Constants.ENTERTAINMENT:
                categoryStr = "ENTERTAINMENT";
                break;
            case Constants.OTHERS:
                categoryStr = "OTHERS";
                break;
            default:
                break;
        }
        return categoryStr;
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
    public String toString() {
        String categoryStr = "";
        switch (category){
            case Constants.FOOD:
                categoryStr = "FOOD";
                break;
            case Constants.TRANSPORTATION:
                categoryStr = "TRANSPORTATION";
                break;
            case Constants.DRINK:
                categoryStr = "DRINK";
                break;
            case Constants.ELECTRONICS:
                categoryStr = "ELECTRONICS";
                break;
            case Constants.ENTERTAINMENT:
                categoryStr = "ENTERTAINMENT";
                break;
            case Constants.OTHERS:
                categoryStr = "OTHERS";
                break;
            default:
                break;
        }
        return Integer.toString(month) + " " + Integer.toString(day) + " " + categoryStr
                + " " + item + " " + Double.toString(amount);
    }
}
