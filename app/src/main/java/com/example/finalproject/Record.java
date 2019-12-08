package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Record extends AppCompatActivity {
    private static double foodSummary = 0, transSummary = 0, drinkSummary = 0, elecSummary = 0,
            entertainSummary = 0, othersSummary = 0;
    private List<Expense> expenseList;
    private int monthInt, dayInt, categoryInt;
    private double amount;
    private String itemString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        expenseList = new ArrayList<>();
        Button addItem = findViewById(R.id.addItem);
        addItem.setOnClickListener(addNewInvitee -> {
            addItem();
        });
        updateUI();
        Button summary = findViewById(R.id.summary);
        summary.setOnClickListener(unused -> toSummary());
    }
    /**
     *
     */
    private void addItem() {
        Spinner month = findViewById(R.id.Month), day = findViewById(R.id.Day),
                category = findViewById(R.id.Category);
        String thisMonth = month.getSelectedItem().toString(),
                thisDay = day.getSelectedItem().toString(),
                thisCategory = category.getSelectedItem().toString();
        EditText newItem = findViewById(R.id.Item);
        itemString = newItem.getText().toString();
        EditText newAmount = findViewById(R.id.Amount);
        String amountString = newAmount.getText().toString();
        if (!thisMonth.equals("") && !thisDay.equals("") && !thisCategory.equals("")
                && !amountString.equals("") && !itemString.equals("")) {
            monthInt = Integer.parseInt(thisMonth);
            dayInt = Integer.parseInt(thisDay);
            categoryInt = Integer.parseInt(thisCategory);
            amount = Double.parseDouble(amountString);
            Expense expense = new Expense(monthInt, dayInt, categoryInt, itemString, amount);
            updateSummary(expense);
            expenseList.add(expense);
            updateUI();
            newItem.getText().clear();
            newAmount.getText().clear();
        }
    }

    private void updateUI() {
        //add chunk
        final LinearLayout itemLists = findViewById(R.id.items_list);
        itemLists.removeAllViews();
        for (final Expense expense : expenseList) {
            View newItem = getLayoutInflater().inflate(R.layout.chunk_items,
                    itemLists, false);
            TextView itemName = newItem.findViewById(R.id.nameOfExpense);
            TextView amount = newItem.findViewById(R.id.amount);
            itemName.setText(expense.getItem());
            amount.setText(Double.toString(expense.getAmount()));
            itemLists.addView(newItem);
            ((Spinner) newItem.findViewById(R.id.CategoryOfExpense)).setOnItemSelectedListener(new AdapterView
                    .OnItemSelectedListener() {
                @Override
                public void onItemSelected(final AdapterView<?> parent, final View view,
                                           final int position, final long id) {
                    // Called when the user selects a different item in the dropdown
                    // The position parameter is the selected index
                    // The other parameters can be ignored
                    expense.setCategory(position);
                }
                @Override
                public void onNothingSelected(final AdapterView<?> parent) {
                }
            });
            ((Spinner) newItem.findViewById(R.id.CategoryOfExpense)).setSelection(expense.getCategory());
            ((Spinner) newItem.findViewById(R.id.monthOfExpense)).setOnItemSelectedListener(new AdapterView
                    .OnItemSelectedListener() {
                @Override
                public void onItemSelected(final AdapterView<?> parent, final View view,
                                           final int position, final long id) {
                    // Called when the user selects a different item in the dropdown
                    // The position parameter is the selected index
                    // The other parameters can be ignored
                    expense.setMonth(position);
                }
                @Override
                public void onNothingSelected(final AdapterView<?> parent) {
                }
            });
            ((Spinner) newItem.findViewById(R.id.monthOfExpense)).setSelection(expense.getMonth());
            ((Spinner) newItem.findViewById(R.id.dayOfExpense)).setOnItemSelectedListener(new AdapterView
                    .OnItemSelectedListener() {
                @Override
                public void onItemSelected(final AdapterView<?> parent, final View view,
                                           final int position, final long id) {
                    // Called when the user selects a different item in the dropdown
                    // The position parameter is the selected index
                    // The other parameters can be ignored
                    expense.setDay(position);
                }
                @Override
                public void onNothingSelected(final AdapterView<?> parent) {
                }
            });
            ((Spinner) newItem.findViewById(R.id.dayOfExpense)).setSelection(expense.getDay());
            Button removeItem = newItem.findViewById(R.id.removeItem);
            removeItem.setOnClickListener(removedInvitee -> {
                expenseList.remove(expense);
                updateUI();
            });
        }
    }
    private void updateSummary(Expense expense) {
        int category = expense.getCategory();
        double amount = expense.getAmount();
        switch (category){
            case Constants.FOOD:
                foodSummary += amount;
            case Constants.TRANSPORTATION:
                transSummary += amount;
            case Constants.DRINK:
                drinkSummary += amount;
            case Constants.ELECTRONICS:
                elecSummary += amount;
            case Constants.ENTERTAINMENT:
                entertainSummary += amount;
            case Constants.OTHERS:
                othersSummary += amount;
            default:
                break;
        }
    }
    private void toSummary() {
        Intent intent = new Intent(this, Summary.class);
        SharedPreferences sharedPreferences = getApplicationContext().
                getSharedPreferences("Summary", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong("food", Double.doubleToRawLongBits(foodSummary));
        editor.putLong("transportation", Double.doubleToRawLongBits(transSummary));
        editor.putLong("drink", Double.doubleToRawLongBits(drinkSummary));
        editor.putLong("electronics", Double.doubleToRawLongBits(elecSummary));
        editor.putLong("entertainment", Double.doubleToRawLongBits(entertainSummary));
        editor.putLong("others", Double.doubleToRawLongBits(othersSummary));
    }
}
