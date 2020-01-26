package com.blueroofstudio.plantcareapp.plant;

import com.blueroofstudio.plantcareapp.database.DBHelper;

import java.util.List;

public class PlantModel {

    private final DBHelper dbHelper;

    public PlantModel(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public List<Plant> loadPlants() {
        return dbHelper.selectAll();
    }

    public void add(Plant plant) {
        dbHelper.insert(plant);
    }

    public void delete(Plant plant) {
        dbHelper.delete(plant);
    }
}
