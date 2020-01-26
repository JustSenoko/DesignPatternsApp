package com.blueroofstudio.plantcareapp.database;

import com.blueroofstudio.plantcareapp.plant.Plant;

import java.util.List;

public interface DBHelper {

    void insert(Plant plant);
    void update(Integer id, Plant plant);
    void delete(Plant plant);
    List<Plant> selectAll();
    Plant findById(Integer id);
}
