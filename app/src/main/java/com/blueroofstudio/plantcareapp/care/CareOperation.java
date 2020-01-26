package com.blueroofstudio.plantcareapp.care;

import com.blueroofstudio.plantcareapp.plant.Plant;

import java.util.Date;

public class CareOperation implements PlantCare {
    private Plant plant;
    private CareType careType;

    public CareOperation(Plant plant, CareType careType) {
        this.plant = plant;
        this.careType = careType;
    }

    @Override
    public void perform() {
        switch (careType) {
            case WATER:
                plant.setLastWatering(new Date());
                break;
            case FERTILIZE:
                plant.setLastFertilizing(new Date());
                break;
            case TRANSPLANT:
                plant.setLastTransplanting(new Date());
        }
        System.out.println(getExplanation());
    }

    @Override
    public String getExplanation() {
        return String.format("%s %sED", plant.getName(), careType);
    }
}
