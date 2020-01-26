package com.blueroofstudio.plantcareapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.blueroofstudio.plantcareapp.R;
import com.blueroofstudio.plantcareapp.database.DBHelper;
import com.blueroofstudio.plantcareapp.database.DBHelperImpl;
import com.blueroofstudio.plantcareapp.plant.Plant;
import com.blueroofstudio.plantcareapp.plant.PlantListAdapter;
import com.blueroofstudio.plantcareapp.plant.PlantController;
import com.blueroofstudio.plantcareapp.plant.PlantModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PlantListAdapter adapter;
    private PlantController controller;
    private final int NEW_PLANT_REQUEST = 444;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new PlantListAdapter();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        RecyclerView userList = findViewById(R.id.plants);
        userList.setLayoutManager(layoutManager);
        userList.setAdapter(adapter);

        FloatingActionButton btnAddPlant = findViewById(R.id.fab);
        btnAddPlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewPlantActivity.class);
                startActivityForResult(intent, NEW_PLANT_REQUEST);
            }
        });

        controller = new PlantController();
        controller.attachView(this);
        controller.loadPlants();
    }

    public void showPlants(List<Plant> plants) {
        adapter.setData(plants);
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        controller.detachView();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == NEW_PLANT_REQUEST) {
                String name = data.getStringExtra("NAME");
                int days = data.getIntExtra("DAYS", 0);
                controller.add(name, days);
            }
        }
    }
}
