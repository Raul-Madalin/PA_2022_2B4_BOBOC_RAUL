package com.company;

import java.util.ArrayList;

public class GreedyAlgorithm extends Algorithm{
    public GreedyAlgorithm(Problem my_Problem) {
        super(my_Problem);
    }

    public Solution solve() {
        ArrayList<Event> events;
        ArrayList<Room> rooms;

        ArrayList<Room> freeRooms;
        Event tempEvent;
        Room tempRoom;

        events = my_Problem.getEvents();
        rooms = my_Problem.getRooms();
        freeRooms = rooms;
        Room[] assignment = new Room[events.size()];
        assignment[0] = freeRooms.get(0);

        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < events.size(); j++) {
                tempEvent = events.get(j);
                if (tempEvent.getEnd() == i) {
                    freeRooms.add(assignment[j]);
                }
            }
            for (int j = 0; j < events.size(); j++) {
                tempEvent = events.get(j);
                if (tempEvent.getStart() == i) {
                    for (int k = 0; k < freeRooms.size(); k++) {
                        tempRoom = freeRooms.get(k);
                        if (tempRoom.getCap() >= tempEvent.getSize()) {
                            assignment[j] = tempRoom;
                            freeRooms.remove(k);
                            break;
                        }
                    }
                }
            }
        }

        /*
        for (int i = 0; i < assignment.length; i++) {
            if (assignment[i] != null)
                System.out.println(events.get(i).getName() + " "
                        + events.get(i).getStart() + " "
                        + events.get(i).getEnd() + " "
                        + events.get(i).getSize() + ": "
                        + assignment[i].getName() + " "
                        + assignment[i].getCap());
        }
        */

        Solution sol = new Solution(assignment);
        return sol;
    }
}
