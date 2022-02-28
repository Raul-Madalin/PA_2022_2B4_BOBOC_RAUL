package com.company;

public class Lab2 {

    public static void main(String args[]) {
        Lab2 lab2 = new Lab2();
        lab2.compulsory();
        lab2.homework();
        lab2.bonus();
    }

    void compulsory() {
        Event c1=new Event("C1",100,8,10);
        Event c2=new Event("C2",100, 10, 12);
        Event l1=new Event("L1",30,8,10);
        Event l2=new Event("L2",30,8,10);
        Event l3=new Event("L3",30,10,12);
        Room r401=new Room("401",RoomType.COMPUTER_LAB,30);
        Room r403=new Room("403",RoomType.COMPUTER_LAB,30);
        Room r405=new Room("405",RoomType.COMPUTER_LAB,30);
        Room r309=new Room("309",RoomType.LECTURE_HALL, 30);

        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(l1.toString());
        System.out.println(l2.toString());
        System.out.println(l3.toString());
        System.out.println(r401.toString());
        System.out.println(r403.toString());
        System.out.println(r405.toString());
        System.out.println(r309.toString());
    }

    void homework() {

    }

    void bonus() {

    }
}
