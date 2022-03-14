package com.company;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.IntStream;

public class Lab4 {
    public static void main(String[] args) {
        Lab4 lab3 = new Lab4();
        lab3.compulsory();
        lab3.homework();
        lab3.bonus();
    }
    void compulsory () {
        var intersections = IntStream.rangeClosed(0, 8).mapToObj(i -> new Intersection("intersection " + i) ).toArray(Intersection[]::new);
        Street[] streetArray = new Street[16];
        streetArray[0] = new Street("street0", 2);
        streetArray[1] = new Street("street1", 2);
        streetArray[2]  = new Street("street2", 2);
        streetArray[3]  = new Street("street3", 2);
        streetArray[4]  = new Street("street4", 3);
        streetArray[5]  = new Street("street5", 1);
        streetArray[6]  = new Street("street6", 2);
        streetArray[7]  = new Street("street7", 2);
        streetArray[8]  = new Street("street8", 3);
        streetArray[9]  = new Street("street9", 1);
        streetArray[10]  = new Street("street10", 2);
        streetArray[11]  = new Street("street11", 1);
        streetArray[12]  = new Street("street12", 1);
        streetArray[13]  = new Street("street13", 1);
        streetArray[14]  = new Street("street14", 3);
        streetArray[15]  = new Street("street15", 1);

        List<Street> streetList = new LinkedList<Street>();
        streetList.addAll(Arrays.asList(streetArray));
        Collections.sort(streetList, ((u, v) -> u.compareTo(v)));

        Set<Intersection> intersectionSet = new HashSet<>();
        intersectionSet.addAll(Arrays.asList(intersections));

    }
    void homework () {
        // homework
    }
    void bonus () {
        // bonus
    }
}
