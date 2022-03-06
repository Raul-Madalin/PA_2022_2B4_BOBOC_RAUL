package com.company;

public class LectureHall extends Room {
    private boolean hasProjector;

    public LectureHall(String name, RoomType type, int cap, boolean hasProjector) {
        super(name, type, cap);
        this.hasProjector = hasProjector;
    }
}
