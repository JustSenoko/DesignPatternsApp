package com.blueroofstudio.plantcareapp.database;

import com.blueroofstudio.plantcareapp.models.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DBHelperImpl implements DBHelper {

    private List<Plant> db = new ArrayList<>();
    private static Map<Integer, Plant> identityMap = new ConcurrentHashMap<>();

    @Override
    public void insert(Plant plant) {
        identityMap.put(plant.getId(), plant);
        db.add(plant);
    }

    @Override
    public void update(Integer id, Plant plant) {
        identityMap.put(plant.getId(), plant);
        updateInDBById(id, plant);
    }

    @Override
    public void delete(Plant plant) {
        identityMap.remove(plant.getId());
        db.remove(plant);
    }

    @Override
    public List<Plant> selectAll() {
        List<Plant> plants = selectAllFromDB();
        for (Plant plant : plants) {
            identityMap.put(plant.getId(), plant);
        }
        return plants;
    }

    @Override
    public Plant findById(Integer id) {
        if (identityMap.containsKey(id)) {
            return identityMap.get(id);
        }
        Plant plant = findInDBById(id);
        if (plant != null) {
            identityMap.put(id, plant);
        }
        return plant;
    }

    private void updateInDBById(Integer id, Plant newPlant) {
        Plant oldPlant = findInDBById(id);
        if (oldPlant != null) {
            db.remove(oldPlant);
        }
        db.add(newPlant);
    }

    private Plant findInDBById(Integer id) {
        for (Plant plant : db) {
            if (plant.getId().equals(id)) {
                return  plant;
            }
        }
        return null;
    }

    private List<Plant> selectAllFromDB() {
        return db;
    }
}
