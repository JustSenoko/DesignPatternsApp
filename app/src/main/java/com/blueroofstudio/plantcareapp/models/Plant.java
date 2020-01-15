package com.blueroofstudio.plantcareapp.models;

import java.util.Date;

public class Plant {

    private int id;
    private String name;
    private Date lastWatering;
    private int daysBetweenWatering;
    private Date lastFertilizing;
    private int daysBetweenFertilizing;
    private Date lastTransplanting;
    private int monthsBetweenTransplanting;

    public Plant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getLastWatering() {
        return lastWatering;
    }

    public int getDaysBetweenWatering() {
        return daysBetweenWatering;
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

    public void setId(int id) {
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
}
