package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class Summary extends AppCompatActivity {
    private PieChartView pieChartView;
    private static double foodSummary = 0, transSummary = 0, drinkSummary = 0, elecSummary = 0,
            entertainSummary = 0, othersSummary = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        pieChartView = findViewById(R.id.chart);
        Record record = new Record();
        List<Expense> expenses = record.expenseList;
        for (Expense e : expenses) {
            updateSummary(e);
        }
        float food = (float) foodSummary, transportation = (float) transSummary,
                drink = (float) drinkSummary, electronics = (float) elecSummary,
                entertainment = (float) entertainSummary, others = (float) othersSummary;
        List<SliceValue> pieData = new ArrayList<>();

        pieData.add(new SliceValue(food, Color.BLUE).setLabel("food: $" + food));
        pieData.add(new SliceValue(transportation, Color.GRAY).setLabel("transportation: $ " + transportation));
        pieData.add(new SliceValue(drink, Color.RED).setLabel("drink: $" + drink));
        pieData.add(new SliceValue(electronics, Color.MAGENTA).setLabel("electronics: $" + electronics));
        pieData.add(new SliceValue(entertainment, Color.GREEN).setLabel("entertainment: $" + entertainment));
        pieData.add(new SliceValue(others, Color.YELLOW).setLabel("others: $" + others));

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1("Expense Summary")
                .setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
        pieChartView.setPieChartData(pieChartData);
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });
    }
    private void back() {
        finish();
    }
    private void updateSummary(Expense expense) {
        String category = expense.getCategory();
        double amount = expense.getAmount();
        switch (category){
            case "FOOD":
                foodSummary += amount;
                break;
            case "TRANSPORTATION":
                transSummary += amount;
                break;
            case "DRINK":
                drinkSummary += amount;
                break;
            case "ELECTRONICS":
                elecSummary += amount;
                break;
            case "ENTERTAINMENT":
                entertainSummary += amount;
                break;
            case "OTHERS":
                othersSummary += amount;
                break;
            default:
                break;
        }
    }
}
