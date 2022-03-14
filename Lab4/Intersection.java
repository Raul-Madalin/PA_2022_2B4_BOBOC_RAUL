package com.company;

public class Intersection implements Comparable<Intersection>{
    String intersectionName;

    public Intersection(String intersectionName) {
        this.intersectionName = intersectionName;
    }

    public String getIntersectionName() {
        return intersectionName;
    }

    public void setIntersectionName(String intersectionName) {
        this.intersectionName = intersectionName;
    }

    @Override
    public String toString() {
        return "Intersection{" +
                "intersectionName='" + intersectionName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Intersection o) {
        return this.getIntersectionName().compareTo(o.getIntersectionName());
    }
}
