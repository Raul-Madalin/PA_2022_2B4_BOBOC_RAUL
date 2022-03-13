package com.company;

import java.util.Map;

public class Computer extends Node implements Identifiable, Storage {

    private String ipAddress;
    private int storageCapacity;

    public Computer(String name, String address, String location, String ipAddress, int storageCapacity) {
        super(name, address, location);
        this.ipAddress = ipAddress;
        this.storageCapacity = storageCapacity;
    }

    @Override
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "ipAddress='" + ipAddress + '\'' +
                ", storageCapacity=" + storageCapacity +
                ", name=" + getName() +
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
