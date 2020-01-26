package com.blueroofstudio.plantcareapp.plant;

import android.text.TextUtils;

import com.blueroofstudio.plantcareapp.R;
import com.blueroofstudio.plantcareapp.activities.NewPlantActivity;

public class PlantPresenter {
    private NewPlantActivity view;
    private PlantModel model;

    public PlantPresenter(PlantModel model) {
        this.model = model;
    }

    public void attachView(NewPlantActivity view) {
        this.view = view;
    }

    public void detachView() {
        view = null;
    }

    public void loadPlants() {
        model.loadPlants();
    }

    public void add() {
        Plant plant = view.getPlantData();
        if (TextUtils.isEmpty(plant.getName()) || plant.getDaysBetweenWatering() == 0) {
            view.showToast(R.string.empty_values);
            return;
        }
        model.add(plant);
    }

    public void delete(Plant plant) {
        model.delete(plant);
        loadPlants();
    }
}
