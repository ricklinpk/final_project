package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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
    public static List<Expense> expenseList;
    private Spinner month, day, category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        expenseList = new ArrayList<>();
        month = findViewById(R.id.Month);
        day = findViewById(R.id.Day);
        category = findViewById(R.id.Category);
        month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> parent, final View view,
                                       final int position, final long id) {
                // Called when the user selects a different item in the dropdown
                // The position parameter is the selected index
                // The other parameters can be ignored
            }
            @Override
            public void onNothingSelected(final AdapterView<?> parent) {
            }
        });
        day.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> parent, final View view,
                                       final int position, final long id) {
                // Called when the user selects a different item in the dropdown
                // The position parameter is the selected index
                // The other parameters can be ignored
            }
            @Override
            public void onNothingSelected(final AdapterView<?> parent) {
            }
        });
        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> parent, final View view,
                                       final int position, final long id) {
                // Called when the user selects a different item in the dropdown
                // The position parameter is the selected index
                // The other parameters can be ignored
            }
            @Override
            public void onNothingSelected(final AdapterView<?> parent) {
            }
        });
        Button addItem = findViewById(R.id.addItem);
        addItem.setOnClickListener(addNewItem -> {
            addItem();
        });
        updateUI();
        Button summary = findViewById(R.id.summary);
        summary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toSummary();
            }
        });
    }
    /**
     *
     */
    private void addItem() {
        EditText newAmount = findViewById(R.id.Amount), newItem = findViewById(R.id.Item);
        String thisMonth = month.getSelectedItem().toString(),
                thisDay = day.getSelectedItem().toString(),
                amountString = newAmount.getText().toString(),
                item = newItem.getText().toString();
        if (!amountString.equals("") && !item.equals("")) {
            int monthInt = Integer.parseInt(thisMonth), dayInt = Integer.parseInt(thisDay),
                    categoryInt = category.getSelectedItemPosition();
            double amount = Double.parseDouble(amountString);
            Expense expense = new Expense(monthInt, dayInt, categoryInt, item, amount);
            expenseList.add(expense);
            updateUI();
            newItem.getText().clear();
            newAmount.getText().clear();
        }
    }

    private void updateUI() {
        //add chunk
        LinearLayout itemLists = findViewById(R.id.items_list);
        itemLists.removeAllViews();
        for (Expense e : expenseList) {
            System.out.println(e.toString());
            View newItem = getLayoutInflater().inflate(R.layout.chunk_items, itemLists,
                    false);
            TextView itemName = newItem.findViewById(R.id.nameOfExpense),
                    amount = newItem.findViewById(R.id.amount),
                    month = newItem.findViewById(R.id.monthOfExpense),
                    day = newItem.findViewById(R.id.dayOfExpense),
                    category = newItem.findViewById(R.id.CategoryOfExpense);
            itemName.setText(e.getItem());
            amount.setText(Double.toString(e.getAmount()));
            month.setText(Integer.toString(e.getMonth()));
            day.setText(Integer.toString(e.getDay()));
            category.setText(e.getCategory());
            newItem.setVisibility(View.VISIBLE);
            itemLists.addView(newItem);
            Button removeItem = newItem.findViewById(R.id.removeItem);
            removeItem.setOnClickListener(removedInvitee -> {
                expenseList.remove(e);
                updateUI();
            });
        }
    }

    private void toSummary() {
        Intent summary = new Intent(this, Summary.class);
        startActivity(summary);
    }
}
