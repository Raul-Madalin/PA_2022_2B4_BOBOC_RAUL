package com.company;

import java.util.ArrayList;

public class Solution {
    private Room[] assignment;

    public Solution(Room[] assignment) {
        this.assignment = assignment;
    }

    public int computeUsedRooms() {
        for (int i = 0; i < assignment.length; i++) {
            if (assignment[i] != null)
                System.out.println(assignment[i].getName());
        }
        return 0;
    }
}


