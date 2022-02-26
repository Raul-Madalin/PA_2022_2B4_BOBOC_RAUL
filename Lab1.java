package com.company;
import java.util.*;

public class Lab1 {
    private static class adjList {
        private int size;
        private String name;
        private String[] neighbors = {"NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL","NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL"};
    }

    public static void main(String args[]) {
        if (args.length < 3) {
            System.out.println(
                    "Usage: number, number, one or more characters");
            System.exit(-1);
        }
        int n = Integer.parseInt(args[0]);
        int p = Integer.parseInt(args[1]);
        int m = args.length - 2;
        char alphabet[] = new char[m];
        for(int i=0; i<m; i++) {
            alphabet[i] = args[i + 2].charAt(0);
        }

        Lab1 lab1 = new Lab1();
        lab1.compulsory();
        lab1.homework(n, p, m, alphabet);
        lab1.bonus();
    }

    private String createRandomWord(int len, char[] alphabet) {
        StringBuilder word = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            int k = rand.nextInt(alphabet.length);
            word.append(alphabet[k]);
        }
        return word.toString();
    }

    private void cloneString(String str1, String str2) {
        System.out.println("FUCK");
        str1 = str2;
    }

    void compulsory() {
        System.out.println("Hello World");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n *= 3;
        n += Integer.parseInt("10101", 2);
        n += Integer.parseInt("FF", 16);
        n *= 6;
        int sum = 0;
        do {
            if (sum > 9) {
                n = sum;
                sum = 0;
            }
            while (n > 9) {
                sum += (n % 10);
                n /= 10;
            }
            sum += (n % 10);
        } while (sum > 9);
        System.out.println("Willy-nilly, this semester I will learn " + languages[sum]);
    }
    void homework(int n, int p, int m, char alphabet[]) {
        long start = System.nanoTime();
        String[] words = new String[n];
        System.out.print("    ");
        for (int i = 0; i < n; i++) {
            words[i] = createRandomWord(p, alphabet);
            System.out.print(words[i] + "  ");
        }
        System.out.println();

        boolean[][] adjMatrix = new boolean[n][n];
        boolean neighbors = false;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                neighbors = false;
                for (int k = 0; k < p; k++) {
                    if (words[j].indexOf(words[i].charAt(k)) != -1)
                        neighbors = true;
                }
                adjMatrix[i][j] = neighbors;
                adjMatrix[j][i] = neighbors;
                //System.out.println(words[i] + " " + words[j] + " " + neighbors);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(words[i] + " ");
            for (int j = 0; j < n; j++) {
                if (adjMatrix[i][j] == true)
                    System.out.print(adjMatrix[i][j] + "  ");
                else
                    System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < n; i++) {
            adjList myList = new adjList();
            myList.name = words[i];
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (adjMatrix[i][j] == true && i != j) {
                    myList.neighbors[count] = words[j];
                    count++;
                }
            }
            System.out.print(myList.name + ": ");
            for (int j = 0; j < count; j++) {
                System.out.print(myList.neighbors[j] + " ");
            }
            System.out.println();
        }

        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        if (n > 30000)
            System.out.println(timeElapsed + " nanoseconds");
    }
    void bonus() {
        LinkedList<String> ll = new LinkedList<String>();
        // se parcurge lista de adiacenta de la Homework in DFS, se marcheaza nodurile vizitate
        // si se adauga in lista, si se continua cu backtracking in cautarea celui mai lung drum
    }
}