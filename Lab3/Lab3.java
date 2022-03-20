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
        Node myComputerA = new Computer("computerA", "address2", "location1", "addressIP1", 10);
        Node myRouterA = new Router("routerA", "address1", "location2", "addressIP2");
        Node mySwitchA = new Switch("switchA", "address3", "location3");
        Node mySwitchB = new Switch("switchB", "address4", "location4");
        Node myRouterB = new Router("routerB", "address6", "location5", "addressIP4");
        Node myComputerB = new Computer("computerB", "address5", "location6", "addressIP3", 10);

        myComputerA.setCost(myRouterA, 10);
        myRouterA.setCost(myComputerA, 10);
        myComputerA.setCost(mySwitchA, 50);
        mySwitchA.setCost(myComputerA, 50);

        myRouterA.setCost(mySwitchA, 20);
        mySwitchA.setCost(myRouterA, 20);
        myRouterA.setCost(mySwitchB, 20);
        mySwitchB.setCost(myRouterA, 20);
        myRouterA.setCost(myRouterB, 20);
        myRouterB.setCost(myRouterA, 20);

        mySwitchA.setCost(mySwitchB, 10);
        mySwitchB.setCost(mySwitchA, 10);

        mySwitchB.setCost(myRouterB, 30);
        myRouterB.setCost(mySwitchB, 30);
        mySwitchB.setCost(myComputerB, 10);
        myComputerB.setCost(mySwitchB, 10);

        myRouterB.setCost(myComputerB, 20);
        myComputerB.setCost(myRouterB, 20);

        myList.add(myComputerA);
        myList.add(myRouterA);
        myList.add(mySwitchA);
        myList.add(mySwitchB);
        myList.add(myRouterB);
        myList.add(myComputerB);

        Network myNetwork = new Network(myList);

        myNetwork.printIdentifiables();

        int graph[][] = new int[myNetwork.getNodes().size()][myNetwork.getNodes().size()];
        for (int i = 0; i < myNetwork.getNodes().size(); i++) {
            for (int j = 0; j < myNetwork.getNodes().size(); j++) {
                if (myNetwork.getNodes().get(i).getCost(myNetwork.getNodes().get(j)) == Integer.MAX_VALUE) {
                    graph[i][j] = graph[j][i] = 0;
                }
                else graph[i][j] = graph[j][i] = myNetwork.getNodes().get(i).getCost(myNetwork.getNodes().get(j));
            }
        }/*
        for (int i = 0; i < myNetwork.getNodes().size(); i++) {
            for (int j = 0; j < myNetwork.getNodes().size(); j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }*/
        //myNetwork.dijkstra(graph, 0);
    }
    void bonus () {
        // bonus
    }
}
