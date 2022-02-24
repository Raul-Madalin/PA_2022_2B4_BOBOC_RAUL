package com.company;
import java.util.Random;

public class Lab1 {
    private static class adjList {
        private int size;
        private String word;
        private String[] neighbors;
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
            alphabet[i] = args[i+2].charAt(0);
        }

        Lab1 lab1 = new Lab1();
        //lab1.compulsory();
        lab1.homework(n, p, m, alphabet);
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
        String[] words = new String[n];
        System.out.print("    ");
        for (int i = 0; i < n; i++) {
            words[i] = createRandomWord(p, alphabet);
            System.out.print(words[i] + "   ");
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

        for (int i = 0; i < n; i++) {
            adjList myList = new adjList();
            myList.word = words[i];
            for (int j = i; j < n; j++) {
                if (adjMatrix[i][j] == true) {

                }
            }
            System.out.println(myList.word);
        }

    }
    void bonus() {
        //Do stuff
    }
}