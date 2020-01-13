package com.blueroofstudio.plantcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.blueroofstudio.plantcareapp.models.Plant;
import com.blueroofstudio.plantcareapp.models.PlantBuilder;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Plant plant = new PlantBuilder(1, "Cactus")
                .addWatering(new Date(2020, 1, 1), 10)
                .addTransplanting(new Date(2020, 1, 1), 12)
                .build();
    }
}
