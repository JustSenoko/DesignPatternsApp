package com.blueroofstudio.plantcareapp.conditions;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
