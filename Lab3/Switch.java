package com.company;

import java.util.Map;

public class Switch extends Node {

    public Switch(String name, String address, String location) {
        super(name, address, location);
    }

    @Override
    public String toString() {
        return "Switch{" +
                "name=" + getName() +
                ", location=" + getLocation() +
                ", address=" + getAddress() +
                ", costs='" + getCosts() + '\'' +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return 0;
    }
}
