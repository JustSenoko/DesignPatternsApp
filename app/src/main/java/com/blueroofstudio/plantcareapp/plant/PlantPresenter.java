package com.blueroofstudio.plantcareapp.plant;

import android.text.TextUtils;

import com.blueroofstudio.plantcareapp.R;
import com.blueroofstudio.plantcareapp.activities.MainActivity;
import com.blueroofstudio.plantcareapp.activities.NewPlantActivity;

import java.util.List;

public class PlantPresenter {
    private MainActivity view;
    private PlantModel model;

    public PlantPresenter(PlantModel model) {
        this.model = model;
    }

    public void attachView(MainActivity view) {
        this.view = view;
    }

    public void detachView() {
        view = null;
    }

    public void loadPlants() {
        List<Plant> plants = model.loadPlants();
        view.showPlants(plants);
    }

    public void add(String name, int days) {
        Plant plant = new Plant(0, name);
        plant.setDaysBetweenWatering(days);
        model.add(plant);
        loadPlants();
    }
}
