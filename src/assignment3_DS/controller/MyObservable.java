package assignment3_DS.controller;

import java.util.Observable;

/**
 * Created by pv42 on 29.06.2017.
 */
public class MyObservable extends Observable{
    public void notifyChanged(Object arg) {
        setChanged();
        notifyObservers(arg);
    }
}

