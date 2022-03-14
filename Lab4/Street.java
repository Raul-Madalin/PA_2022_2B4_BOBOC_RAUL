package com.company;

public class Street implements Comparable<Street>{
    String streetName;
    int streetLength;

    public Street(String streetName, int streetLength) {
        this.streetName = streetName;
        this.streetLength = streetLength;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetLength() {
        return streetLength;
    }

    public void setStreetLength(int streetLength) {
        this.streetLength = streetLength;
    }

    @Override
    public String toString() {
        return "Street{" +
                "streetName='" + streetName + '\'' +
                ", streetLength=" + streetLength +
                '}';
    }


    @Override
    public int compareTo(Street o) {
        return this.getStreetLength() - o.getStreetLength();
    }
}
