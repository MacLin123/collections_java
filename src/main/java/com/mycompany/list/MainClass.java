package com.mycompany.list;

import java.util.LinkedList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
//        test();
        compareLists();

    }

    public static void test() {
        ILinkedList<String> strings = new MyLinkedList<>();
        strings.add("dsd");
        strings.add(1, "dsd1");
        strings.add(1, "dsd2");
        strings.add(1, "dsd3");
        strings.add("dsd4");
        strings.set(4, "dsd4New");
        strings.remove(4);

        System.out.println(strings.get(3));
        System.out.println(strings.indexOf("dsd1"));
        System.out.println(strings);
        strings.clear();

        System.out.println(strings);
    }

    public static void compareLists() {
        String str = "example";
        ILinkedList<String> myStrings = new MyLinkedList<>();
        List<String> jStrings = new LinkedList<>();
        int n = 5000;
        System.out.println("*inserting " + n + " elements");
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            String strInsert = str + i;
            jStrings.add(jStrings.size() / 2, strInsert);
        }
        long end = System.nanoTime();

        System.out.println("Java List = " + (end - start) / 1E6 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            String strInsert = str + i;
            myStrings.add(myStrings.size() / 2, strInsert);
        }
        end = System.nanoTime();

        System.out.println("My List = " + (end - start) / 1E6 + " ms");

        System.out.println("*finding " + n + " elements");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            String strInsert = str + i;
            jStrings.indexOf(strInsert);
        }
        end = System.nanoTime();

        System.out.println("Java List = " + (end - start) / 1E6 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            String strInsert = str + i;
            myStrings.indexOf(strInsert);
        }
        end = System.nanoTime();

        System.out.println("My List = " + (end - start) / 1E6 + " ms");

        System.out.println("*deleting " + n + " elements");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            jStrings.remove(jStrings.size() / 2);
        }
        end = System.nanoTime();

        System.out.println("Java List = " + (end - start) / 1E6 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            myStrings.remove(myStrings.size() / 2);
        }
        end = System.nanoTime();

        System.out.println("My List = " + (end - start) / 1E6 + " ms");
    }

    public static void compareCollections() {
        
    }
}
