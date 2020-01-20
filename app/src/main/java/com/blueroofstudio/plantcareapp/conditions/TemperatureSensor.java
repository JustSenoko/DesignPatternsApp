package com.blueroofstudio.plantcareapp.conditions;

import java.util.ArrayList;
import java.util.List;

public class TemperatureSensor implements Observable {
    List<Observer> observers = new ArrayList<>();
    int temperature = 0;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.notifyTemperature(temperature);
        }
    }

    public  void measure() {
        temperature = (int) (Math.random() * 100);
        notifyObservers();
    }
}
