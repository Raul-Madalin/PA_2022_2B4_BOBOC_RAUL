package com.company;

public class ComputerLab extends Room {
    private String operatingSystem;

    public ComputerLab(String name, RoomType type, int cap, String operatingSystem) {
        super(name, type, cap);
        this.operatingSystem = operatingSystem;
    }
}
