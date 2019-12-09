package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button recordButton = findViewById(R.id.record);
        recordButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                // Change the label's tex
                openNewAct();
            }
        });
    }
    public void openNewAct() {
        // Change the label's text
        Intent createGameClicked = new Intent(this, Record.class);
        startActivity(createGameClicked);
    }
}
