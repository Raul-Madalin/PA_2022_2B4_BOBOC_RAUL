package com.company;

import java.util.ArrayList;

public abstract class Algorithm {
    protected Problem my_Problem;
    private ArrayList<Event> events;
    private ArrayList<Room> rooms;

    public Algorithm(Problem my_Problem) {
        this.my_Problem = my_Problem;
    }

    public abstract Solution solve();
}
