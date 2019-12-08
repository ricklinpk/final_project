package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class Summary extends AppCompatActivity {
    private PieChartView pieChartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        pieChartView = findViewById(R.id.chart);
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        double food = sharedPreferences.getLong("food", 0);
        double transportation = sharedPreferences.getLong("transportation", 0);
        double drink = sharedPreferences.getLong("drink", 0);
        double electronics = sharedPreferences.getLong("electronics", 0);
        double entertainment = sharedPreferences.getLong("entertainment", 0);
        double others = sharedPreferences.getLong("others", 0);
        List pieData = new ArrayList<>();

        pieData.add(("food: " + food));
        pieData.add(("transportation: " + transportation));
        pieData.add(("drink: " + drink));
        pieData.add(("electronics: " + electronics));
        pieData.add(("entertainment: " + entertainment));
        pieData.add(("others: " + others));

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1("Expense Summary")
                .setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
        pieChartView.setPieChartData(pieChartData);
    }
}
