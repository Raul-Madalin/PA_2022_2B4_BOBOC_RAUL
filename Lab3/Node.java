package com.company;

import java.util.Map;
import java.util.Objects;

public abstract class Node implements Comparable<Node> {
    private String name;
    private String address;
    private String location;
    private Map<String, Integer> costs;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<String, Integer> getCosts() {
        return costs;
    }

    public void setCosts(Map<String, Integer> costs) {
        this.costs = costs;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", location='" + location + '\'' +
                ", costs='" + costs + '\'' +
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
        return this.name.compareTo(node.name);
    }
}
