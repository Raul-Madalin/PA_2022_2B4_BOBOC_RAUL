package com.company;

public abstract class Room {
    protected String name;
    private RoomType type;
    private int cap;

    public RoomType getType() { return type; }

    public void setType(RoomType type) { this.type = type; }

    public Room(String name, RoomType type, int cap) {
        this.name = name;
        this.type = type;
        this.cap = cap;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", cap=" + cap +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Room)) {
            return false;
        }
        Room other = (Room) obj;
        return name.equals(other.name);
    }
}
