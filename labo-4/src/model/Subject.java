package model;

import view.Observer;

public interface Subject {
    void registerObserver(Observer o);
    // TODO removeObserver never used, what's the point of this method?
    void removeObserver(Observer o);
    void notifyObservers();
}
