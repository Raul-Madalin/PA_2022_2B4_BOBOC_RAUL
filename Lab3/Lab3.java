package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lab3 {
    public static void main(String[] args) {
        Lab3 lab3 = new Lab3();
        //lab3.compulsory();
        lab3.homework();
        lab3.bonus();
    }
    void compulsory () {
        List<Node> myList = new ArrayList<>();
        Computer myComputerA = new Computer("computerA", "address1", "location1", "addressIP1", 10);
        Router myRouterA = new Router("routerA", "address2", "location2", "ipAddress1");
        Switch mySwitchA = new Switch("switchA", "address3", "location3");
        Switch mySwitchB = new Switch("switchB", "address4", "location4");
        Router myRouterB = new Router("routerB", "address5", "location5", "ipAddress2");
        Computer myComputerB = new Computer("computerB", "address6", "location6", "addressIP2", 10);

        Map<String, Integer> myComputerAMap = new HashMap<>();
        myComputerAMap.put("myRouterA", 10);
        myComputerAMap.put("mySwitchA", 50);
        myComputerA.setCosts(myComputerAMap);

        Map<String, Integer> myRouterAMap = new HashMap<>();
        myRouterAMap.put("mySwitchA", 20);
        myRouterAMap.put("mySwitchB", 20);
        myRouterAMap.put("myRouterB", 20);
        myRouterA.setCosts(myRouterAMap);

        Map<String, Integer> mySwitchAMap = new HashMap<>();
        mySwitchAMap.put("mySwitchB", 10);
        mySwitchA.setCosts(mySwitchAMap);

        Map<String, Integer> mySwitchBMap = new HashMap<>();
        mySwitchBMap.put("myRouterB", 30);
        mySwitchBMap.put("myComputerB", 10);
        mySwitchB.setCosts(mySwitchBMap);

        Map<String, Integer> myRouterBMap = new HashMap<>();
        myRouterBMap.put("myComputerB", 20);
        myRouterB.setCosts(myRouterBMap);

        myList.add(myComputerA);
        myList.add(myRouterA);
        myList.add(mySwitchA);
        myList.add(mySwitchB);
        myList.add(myRouterB);
        myList.add(myComputerB);

        Network myNetwork = new Network(myList);
        System.out.println(myNetwork.toString());
    }
    void homework () {
        List<Node> myList = new ArrayList<>();
        Computer myComputerA = new Computer("computerA", "address1", "location1", "addressIP1", 10);
        Router myRouterA = new Router("routerA", "address2", "location2", "ipAddress1");
        Switch mySwitchA = new Switch("switchA", "address3", "location3");
        Switch mySwitchB = new Switch("switchB", "address4", "location4");
        Router myRouterB = new Router("routerB", "address5", "location5", "ipAddress2");
        Computer myComputerB = new Computer("computerB", "address6", "location6", "addressIP2", 10);

        Map<String, Integer> myComputerAMap = new HashMap<>();
        myComputerAMap.put("myRouterA", 10);
        myComputerAMap.put("mySwitchA", 50);
        myComputerA.setCosts(myComputerAMap);

        Map<String, Integer> myRouterAMap = new HashMap<>();
        myRouterAMap.put("mySwitchA", 20);
        myRouterAMap.put("mySwitchB", 20);
        myRouterAMap.put("myRouterB", 20);
        myRouterA.setCosts(myRouterAMap);

        Map<String, Integer> mySwitchAMap = new HashMap<>();
        mySwitchAMap.put("mySwitchB", 10);
        mySwitchA.setCosts(mySwitchAMap);

        Map<String, Integer> mySwitchBMap = new HashMap<>();
        mySwitchBMap.put("myRouterB", 30);
        mySwitchBMap.put("myComputerB", 10);
        mySwitchB.setCosts(mySwitchBMap);

        Map<String, Integer> myRouterBMap = new HashMap<>();
        myRouterBMap.put("myComputerB", 20);
        myRouterB.setCosts(myRouterBMap);

        myList.add(myComputerA);
        myList.add(myRouterA);
        myList.add(mySwitchA);
        myList.add(mySwitchB);
        myList.add(myRouterB);
        myList.add(myComputerB);

        Network myNetwork = new Network(myList);
        /*
        System.out.println("myComputerA -> " + myComputerA.getCosts());
        System.out.println("myRouterA -> " + myRouterA.getCosts());
        System.out.println("mySwitchA -> " + mySwitchA.getCosts());
        System.out.println("mySwitchB -> " + mySwitchB.getCosts());
        System.out.println("myRouterB -> " + myRouterB.getCosts());
        System.out.println("myComputerB -> " + myComputerB.getCosts());
        */
        myNetwork.printIdentifiables();

    }
    void bonus () {
        // bonus
    }
}
