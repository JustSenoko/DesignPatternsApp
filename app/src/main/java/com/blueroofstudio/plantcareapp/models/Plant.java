package com.blueroofstudio.plantcareapp.models;

import com.blueroofstudio.plantcareapp.conditions.Observer;

import java.util.Date;

public class Plant implements Observer {

    private Integer id;
    private String name;
    private Date lastWatering;
    private int daysBetweenWatering;
    private Date lastFertilizing;
    private int daysBetweenFertilizing;
    private Date lastTransplanting;
    private int monthsBetweenTransplanting;

    private int maxComfortTemperature = 25;
    private int deltaDays = 0;

    public Plant(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getLastWatering() {
        return lastWatering;
    }

    public int getDaysBetweenWatering() {
        return daysBetweenWatering + deltaDays;
    }

    public Date getLastFertilizing() {
        return lastFertilizing;
    }

    public int getDaysBetweenFertilizing() {
        return daysBetweenFertilizing;
    }

    public Date getLastTransplanting() {
        return lastTransplanting;
    }

    public int getMonthsBetweenTransplanting() {
        return monthsBetweenTransplanting;
    }

    public int getMaxComfortTemperature() {
        return maxComfortTemperature;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastWatering(Date lastWatering) {
        this.lastWatering = lastWatering;
    }

    public void setDaysBetweenWatering(int daysBetweenWatering) {
        this.daysBetweenWatering = daysBetweenWatering;
    }

    public void setLastFertilizing(Date lastFertilizing) {
        this.lastFertilizing = lastFertilizing;
    }

    public void setDaysBetweenFertilizing(int daysBetweenFertilizing) {
        this.daysBetweenFertilizing = daysBetweenFertilizing;
    }

    public void setLastTransplanting(Date lastTransplanting) {
        this.lastTransplanting = lastTransplanting;
    }

    public void setMonthsBetweenTransplanting(int monthsBetweenTransplanting) {
        this.monthsBetweenTransplanting = monthsBetweenTransplanting;
    }

    public void setMaxComfortTemperature(int maxComfortTemperature) {
        this.maxComfortTemperature = maxComfortTemperature;
    }

    @Override
    public void notifyTemperature(int temp) {
        if (temp > maxComfortTemperature) {
            deltaDays = -1;
            System.out.printf("Температура %d слишком велика для %s, его надо поливать чаще", temp, name);
        } else {
            deltaDays = 0;
        }
    }
}
