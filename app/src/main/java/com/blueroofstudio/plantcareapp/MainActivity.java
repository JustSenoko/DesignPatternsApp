package com.blueroofstudio.plantcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.blueroofstudio.plantcareapp.care.CareOperation;
import com.blueroofstudio.plantcareapp.care.CareType;
import com.blueroofstudio.plantcareapp.care.CompositeCare;
import com.blueroofstudio.plantcareapp.care.PlantCare;
import com.blueroofstudio.plantcareapp.models.Plant;
import com.blueroofstudio.plantcareapp.models.PlantBuilder;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Plant cactus1 = new PlantBuilder(1, "Cactus 1")
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

        PlantCare waterCactus1 = new CareOperation(cactus1, CareType.WATER);
        PlantCare waterCactus2 = new CareOperation(cactus2, CareType.WATER);
        PlantCare waterGrass = new CareOperation(grass, CareType.WATER);
        PlantCare fertilizeGrass = new CareOperation(grass, CareType.FERTILIZE);
        PlantCare transplantGrass = new CareOperation(grass, CareType.TRANSPLANT);
        PlantCare careGrass = new CompositeCare().add(waterGrass,fertilizeGrass,transplantGrass);

        // использование разных по структуре операций идентично
        waterCactus1.perform();
        waterCactus2.perform();
        careGrass.perform();

    }
}
