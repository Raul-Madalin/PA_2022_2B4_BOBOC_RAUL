package com.company;

import com.github.javafaker.Faker;
import org.jgrapht.Graph;
import org.jgrapht.alg.spanning.PrimMinimumSpanningTree;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.IntStream;

public class Lab4 {
    public static void main(String[] args) {
        Lab4 lab4 = new Lab4();
        //lab4.compulsory();
        lab4.homework();
        lab4.bonus();
    }

    void compulsory() {
        var intersections = IntStream.rangeClosed(0, 8)
                .mapToObj(i -> new Intersection("intersection " + i))
                .toArray(Intersection[]::new);
        Street[] streetArray = new Street[16];
        streetArray[0] = new Street("street0", 2);
        streetArray[1] = new Street("street1", 2);
        streetArray[2] = new Street("street2", 2);
        streetArray[3] = new Street("street3", 2);
        streetArray[4] = new Street("street4", 3);
        streetArray[5] = new Street("street5", 1);
        streetArray[6] = new Street("street6", 2);
        streetArray[7] = new Street("street7", 2);
        streetArray[8] = new Street("street8", 3);
        streetArray[9] = new Street("street9", 1);
        streetArray[10] = new Street("street10", 2);
        streetArray[11] = new Street("street11", 1);
        streetArray[12] = new Street("street12", 1);
        streetArray[13] = new Street("street13", 1);
        streetArray[14] = new Street("street14", 3);
        streetArray[15] = new Street("street15", 1);

        List<Street> streetList = new LinkedList<Street>();
        streetList.addAll(Arrays.asList(streetArray));
        Collections.sort(streetList);

        Set<Intersection> intersectionSet = new HashSet<>();
        intersectionSet.addAll(Arrays.asList(intersections));

    }

    void homework() {
        var intersections = IntStream.rangeClosed(0, 8)
                .mapToObj(i -> new Intersection("intersection " + i))
                .toArray(Intersection[]::new);
        Street[] streetArray = new Street[16];
        streetArray[0] = new Street("street0", 2);
        streetArray[1] = new Street("street1", 2);
        streetArray[2] = new Street("street2", 2);
        streetArray[3] = new Street("street3", 2);
        streetArray[4] = new Street("street4", 3);
        streetArray[5] = new Street("street5", 1);
        streetArray[6] = new Street("street6", 2);
        streetArray[7] = new Street("street7", 2);
        streetArray[8] = new Street("street8", 3);
        streetArray[9] = new Street("street9", 1);
        streetArray[10] = new Street("street10", 2);
        streetArray[11] = new Street("street11", 1);
        streetArray[12] = new Street("street12", 1);
        streetArray[13] = new Street("street13", 1);
        streetArray[14] = new Street("street14", 3);
        streetArray[15] = new Street("street15", 1);

        List<Street> streetList = new LinkedList<Street>();
        streetList.addAll(Arrays.asList(streetArray));
        //Collections.sort(streetList);

        List<Intersection> intersectionList = new ArrayList<>();
        intersectionList.addAll(Arrays.asList(intersections));

        Map<Intersection, List<Street>> cityMap = new HashMap<>();
        cityMap.put(intersectionList.get(0), Arrays.asList(streetArray[0], streetArray[1], streetArray[2]));
        cityMap.put(intersectionList.get(1), Arrays.asList(streetArray[0], streetArray[3], streetArray[4]));
        cityMap.put(intersectionList.get(2), Arrays.asList(streetArray[1], streetArray[3], streetArray[5], streetArray[6], streetArray[7]));
        cityMap.put(intersectionList.get(3), Arrays.asList(streetArray[2], streetArray[5], streetArray[8]));
        cityMap.put(intersectionList.get(4), Arrays.asList(streetArray[4], streetArray[9], streetArray[10], streetArray[11]));
        cityMap.put(intersectionList.get(5), Arrays.asList(streetArray[7], streetArray[12], streetArray[13]));
        cityMap.put(intersectionList.get(6), Arrays.asList(streetArray[6], streetArray[8], streetArray[9], streetArray[14]));
        cityMap.put(intersectionList.get(7), Arrays.asList(streetArray[11], streetArray[12], streetArray[15]));
        cityMap.put(intersectionList.get(8), Arrays.asList(streetArray[10], streetArray[13], streetArray[14], streetArray[15]));

        City myCity = new City("myCity", cityMap);
        //System.out.println(myCity.getCityMap().keySet());
        Street comparableStreet = new Street("compare", 3);

        for (int j = 0; j < streetList.size(); j++) {
            int finalJ = j;
            if (streetList.get(finalJ).compareTo(comparableStreet) >= 0) {
                Arrays.stream(intersections)
                        .filter(i -> myCity.getCityMap().get(i).contains(streetList.get(finalJ)))
                        .filter(o -> myCity.getCityMap().get(o).size() >= 4)
                        .forEach(System.out::println);
                System.out.println();
            }
        }

        Faker faker = new Faker();

        String name = faker.name().fullName(); // Miss Samanta Schmidt
        String firstName = faker.name().firstName(); // Emory
        String lastName = faker.name().lastName(); // Barton

        String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449

        PrimMinimumSpanningTree sol = new PrimMinimumSpanningTree<Intersection, Street>((Graph<Intersection, Street>) myCity);
    }

    void bonus() {
        // bonus
    }
}
