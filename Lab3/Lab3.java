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

        myComputerA.setCost(myRouterA, 10);
        myComputerA.setCost(mySwitchA, 50);

        myRouterA.setCost(mySwitchA, 20);
        myRouterA.setCost(mySwitchB, 20);
        myRouterA.setCost(myRouterB, 20);

        mySwitchA.setCost(mySwitchB, 10);

        mySwitchB.setCost(myRouterB, 30);
        mySwitchB.setCost(myComputerB, 10);

        myRouterB.setCost(myComputerB, 20);

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
        Node myComputerA = new Computer("computerA", "address1", "location1", "addressIP1", 10);
        Node myRouterA = new Router("routerA", "address2", "location2", "ipAddress1");
        Node mySwitchA = new Switch("switchA", "address3", "location3");
        Node mySwitchB = new Switch("switchB", "address4", "location4");
        Node myRouterB = new Router("routerB", "address5", "location5", "ipAddress2");
        Node myComputerB = new Computer("computerB", "address6", "location6", "addressIP2", 10);

        myComputerA.setCost(myRouterA, 10);
        myComputerA.setCost(mySwitchA, 50);

        myRouterA.setCost(mySwitchA, 20);
        myRouterA.setCost(mySwitchB, 20);
        myRouterA.setCost(myRouterB, 20);

        mySwitchA.setCost(mySwitchB, 10);

        mySwitchB.setCost(myRouterB, 30);
        mySwitchB.setCost(myComputerB, 10);

        myRouterB.setCost(myComputerB, 20);

        myList.add(myComputerA);
        myList.add(myRouterA);
        myList.add(mySwitchA);
        myList.add(mySwitchB);
        myList.add(myRouterB);
        myList.add(myComputerB);

        Network myNetwork = new Network(myList);

        myNetwork.printIdentifiables();
    }
    void bonus () {
        // bonus
    }
}
