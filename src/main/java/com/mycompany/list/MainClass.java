package com.mycompany.list;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        test();
        System.out.println("MyLinkedList and java.util.LinkedList compare\n");
        compareListsAll();
        System.out.println("\nArrayList and LinkedList compare\n");
        TestCollections.compCollectA();
        System.out.println("\nHashSet, LinkedHashSet and TreeSet compare\n");
        TestCollections.compCollectB();
        System.out.println("\nHashMap, LinkedHashMap and TreeMap compare\n");
        TestCollections.compCollectC();

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

        //toArray
        System.out.println("toArray");
        String[] strArray = new String[strings.size()];
        strings.toArray(strArray);

        for (int i = 0; i < strArray.length; i++) {
            System.out.println(strArray[i]);
        }
        //foreach
        System.out.println("foreach");
        for (String str:strings) {
            System.out.println(str);
        }
        strings.clear();
    }

    public static void compareListsInsert(ILinkedList<String> myStrings, List<String> jStrings, int n) {
        String str = "example";
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
    }

    public static void compareListsFind(ILinkedList<String> myStrings, List<String> jStrings, int n) {
        String str = "example";
        long start, end;
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
    }

    public static void compareListsDelete(ILinkedList<String> myStrings, List<String> jStrings, int n) {
        System.out.println("*deleting " + n + " elements");
        long start, end;
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

    public static void compareListsAll() {
        ILinkedList<String> myStrings = new MyLinkedList<>();
        List<String> jStrings = new LinkedList<>();
        int n = 5000;
        compareListsInsert(myStrings, jStrings, n);
        compareListsFind(myStrings, jStrings, n);
        compareListsDelete(myStrings, jStrings, n);
    }
}
