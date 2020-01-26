package com.blueroofstudio.plantcareapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blueroofstudio.plantcareapp.R;
import com.google.android.material.textfield.TextInputEditText;

public class NewPlantActivity extends AppCompatActivity {

    private TextInputEditText etName;
    private TextInputEditText etDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_plant);
        init();
    }

    private void init() {

        etName = findViewById(R.id.plant_name);
        etDays = findViewById(R.id.plant_days_between_watering);

        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("NAME", etName.getText().toString());
                String days = etDays.getText().toString();
                intent.putExtra("DAYS", (int) Integer.valueOf((days.isEmpty() ? "0" : days)));
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
