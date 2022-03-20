package com.company;

import java.util.List;
import java.util.Map;

public class City {
    String cityName;
    Map <Intersection, List <Street>> cityMap;

    public City(String cityName, Map<Intersection, List<Street>> cityMap) {
        this.cityName = cityName;
        this.cityMap = cityMap;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Map<Intersection, List<Street>> getCityMap() {
        return cityMap;
    }

    public void setCityMap(Map<Intersection, List<Street>> cityMap) {
        this.cityMap = cityMap;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", cityMap=" + cityMap +
                '}';
    }
}
