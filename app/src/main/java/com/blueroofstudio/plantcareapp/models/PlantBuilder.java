package com.blueroofstudio.plantcareapp.models;

import java.util.Date;

public class PlantBuilder {

    private Plant plant;

    public PlantBuilder(Integer id, String name) {
        plant = new Plant(id, name);
    }

    public PlantBuilder addWatering(Date lastWatering, int daysBetweenWatering) {
        plant.setLastWatering(lastWatering);
        plant.setDaysBetweenWatering(daysBetweenWatering);
        return this;
    }

    public PlantBuilder addFertilizing(Date lastFertilizing, int daysBetweenFertilizing) {
        plant.setLastFertilizing(lastFertilizing);
        plant.setDaysBetweenFertilizing(daysBetweenFertilizing);
        return this;
    }

    public PlantBuilder addTransplanting(Date lastTransplanting, int monthsBetweenTransplanting) {
        plant.setLastTransplanting(lastTransplanting);
        plant.setMonthsBetweenTransplanting(monthsBetweenTransplanting);
        return this;
    }

    public Plant build() {
        return plant;
    }
}
