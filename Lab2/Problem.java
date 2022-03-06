package com.company;

import java.util.ArrayList;

public class Problem {
    private ArrayList<Event> events;
    private ArrayList<Room> rooms;

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public Problem(ArrayList<Event> events, ArrayList<Room> rooms) {
        this.events = events;
        this.rooms = rooms;
    }
}
