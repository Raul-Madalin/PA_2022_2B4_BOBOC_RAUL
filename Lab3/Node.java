package com.company;

import java.util.*;

public abstract class Node implements Comparable<Node> {
    private String name;
    private String address;
    private String ipAddress;
    private String location;
    private Map<Node, Integer> cost = new HashMap<>();
    private String type;

    protected Node(String name, String address, String location) {
        this.name = name;
        this.address = address;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCost(Node node) {
        if (cost.get(node) == null) return Integer.MAX_VALUE;
        return cost.get(node);
    }

    public void setCost(Node node, int value) {
        cost.put(node, value);
    }

    public Map<Node, Integer> getMap() {
        return cost;
    }

    public void setMap(Map<Node, Integer> cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", location='" + location + '\'' +
                ", costs='" + cost + '\'' +
                ", IpAddress='" + ipAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return name.equals(node.name) && address.equals(node.address) && location.equals(node.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, location);
    }

    @Override
    public int compareTo(Node node) {
        return this.ipAddress.compareTo(node.getIpAddress());
    }
}
