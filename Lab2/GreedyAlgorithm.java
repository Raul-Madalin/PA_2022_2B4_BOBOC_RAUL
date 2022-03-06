package com.company;

import java.util.ArrayList;

public class GreedyAlgorithm extends Algorithm{
    public GreedyAlgorithm(Problem pb) {
        super(pb);
    }

    public Solution solve() {
        ArrayList<Event> events;
        ArrayList<Room> rooms;
        Room[] assignment = new Room[10];

        events = pb.getEvents();
        rooms = pb.getRooms();
        assignment[0] = rooms.get(0);

        System.out.println(assignment[0]);
        return null;
    }
}
