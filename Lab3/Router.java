package com.company;

public class Router extends Node implements Identifiable{
    private String ipAddress;

    public Router(String name, String address, String location, String ipAddress) {
        super(name, address, location);
        this.ipAddress = ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    @Override
    public String toString() {
        return "Router{" +
                "IP_address='" + ipAddress + '\'' +
                ", name=" + getName() +
                ", location=" + getLocation() +
                ", address=" + getAddress() +
                ", costs='" + getCost() + '\'' +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return 0;
    }
}
