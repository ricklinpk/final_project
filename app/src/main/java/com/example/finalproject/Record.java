package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Record extends AppCompatActivity {
    private List<JSONObject> itemList;
    /** */
    private List<String> invitees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record2);
        itemList = new ArrayList<>();
        Button addItem = findViewById(R.id.addItem);
        addItem.setOnClickListener(addNewItem -> {
            addItem();
        });
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
        String itemString = newItem.getText().toString();
        EditText newAmount = findViewById(R.id.Amount);
        String amountString = newAmount.getText().toString();

    }

    private void updateItem() {
        //add chunk
    }
}
