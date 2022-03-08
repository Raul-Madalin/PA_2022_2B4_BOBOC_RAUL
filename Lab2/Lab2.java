package com.company;

import java.util.ArrayList;

public class Lab2 {

    public static void main(String args[]) {
        Lab2 lab2 = new Lab2();
        lab2.compulsory();
        lab2.homework();
        lab2.bonus();
    }

    void compulsory() {
        Event c1 = new Event("C1",100,8,10);
        Event c2 = new Event("C2",100, 10, 12);
        Event l1 = new Event("L1",30,8,10);
        Event l2 = new Event("L2",30,8,10);
        Event l3 = new Event("L3",30,10,12);

        LectureHall r401 = new LectureHall("401", RoomType.COMPUTER_LAB, 30, false);
        LectureHall r403 = new LectureHall("403", RoomType.COMPUTER_LAB, 30, false);
        LectureHall r405 = new LectureHall("405", RoomType.COMPUTER_LAB, 30, false);
        LectureHall r309 = new LectureHall("309", RoomType.LECTURE_HALL, 30, false);

        /*
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(l1.toString());
        System.out.println(l2.toString());
        System.out.println(l3.toString());
        System.out.println(r401.toString());
        System.out.println(r403.toString());
        System.out.println(r405.toString());
        System.out.println(r309.toString());
        */
    }

    void homework() {
        ArrayList<Event> events = new ArrayList<>();
        ArrayList<Room> rooms = new ArrayList<>();

        Event Course_1 = new Event("C1",100,8,10);
        Event Course_2 = new Event("C2",100, 10, 12);
        Event Lab_1 = new Event("L1",30,8,10);
        Event Lab_2 = new Event("L2",30,8,10);
        Event Lab_3 = new Event("L3",30,10,12);
        events.add(Course_1);
        events.add(Course_2);
        events.add(Lab_1);
        events.add(Lab_2);
        events.add(Lab_3);

        ComputerLab Room_401 = new ComputerLab("Room 401", RoomType.COMPUTER_LAB, 30, "Windows 11");
        ComputerLab Room_403 = new ComputerLab("Room 403", RoomType.COMPUTER_LAB, 30, "Ubuntu");
        ComputerLab Room_405 = new ComputerLab("Room 405", RoomType.COMPUTER_LAB, 30, "Windows 10");
        LectureHall Room_309 = new LectureHall("Room 309", RoomType.LECTURE_HALL, 100, false);
        rooms.add(Room_401);
        rooms.add(Room_403);
        rooms.add(Room_405);
        rooms.add(Room_309);

        Problem my_Problem = new Problem(events, rooms);
        Algorithm greedy = new GreedyAlgorithm(my_Problem);
        Solution my_Solution = greedy.solve();
        my_Solution.computeUsedRooms();
    }

    void bonus() {

    }
}
