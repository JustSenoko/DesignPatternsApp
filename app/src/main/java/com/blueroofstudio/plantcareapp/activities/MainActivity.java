package com.blueroofstudio.plantcareapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blueroofstudio.plantcareapp.R;
import com.blueroofstudio.plantcareapp.conditions.TemperatureSensor;
import com.blueroofstudio.plantcareapp.plant.Plant;
import com.blueroofstudio.plantcareapp.plant.PlantBuilder;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAddPlant = findViewById(R.id.btn_add_plant);
        btnAddPlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewPlantActivity.class);
                startActivity(intent);
            }
        });

        /*Plant cactus1 = new PlantBuilder(1, "Cactus 1")
                .addWatering(new Date(2020, 1, 1), 10)
                .build();

        Plant cactus2 = new PlantBuilder(1, "Cactus 2")
                .addWatering(new Date(2020, 1, 1), 15)
                .build();

        Plant grass = new PlantBuilder(1, "Grass")
                .addWatering(new Date(2020, 1, 1), 3)
                .addFertilizing(new Date(2020, 1, 1), 90)
                .addTransplanting(new Date(2020, 1, 1), 6)
                .build();

        final TemperatureSensor sensor = new TemperatureSensor();
        sensor.addObserver(cactus1);
        sensor.addObserver(cactus2);
        sensor.addObserver(grass);

        Button btnMeasure = findViewById(R.id.btn_measure_temp);
        btnMeasure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sensor.measure();
            }
        });*/

        /*PlantCare waterCactus1 = new CareOperation(cactus1, CareType.WATER);
        PlantCare waterCactus2 = new CareOperation(cactus2, CareType.WATER);
        PlantCare waterGrass = new CareOperation(grass, CareType.WATER);
        PlantCare fertilizeGrass = new CareOperation(grass, CareType.FERTILIZE);
        PlantCare transplantGrass = new CareOperation(grass, CareType.TRANSPLANT);
        PlantCare careGrass = new CompositeCare().add(waterGrass,fertilizeGrass,transplantGrass);

        // использование разных по структуре операций идентично
        waterCactus1.perform();
        waterCactus2.perform();
        careGrass.perform();*/

    }
}
