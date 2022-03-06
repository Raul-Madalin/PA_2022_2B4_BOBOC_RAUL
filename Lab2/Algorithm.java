package com.company;

import java.util.ArrayList;

public abstract class Algorithm {
    protected Problem pb;
    private ArrayList<Event> events;
    private ArrayList<Room> rooms;

    public Algorithm(Problem pb) {
        this.pb = pb;
    }

    public abstract Solution solve();
}
