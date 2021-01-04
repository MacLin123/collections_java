package com.mycompany.list;

import java.util.*;

public class TestCollections {

    public static void compCollectA() {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        int n = 20000;

        compCollectAInsert(arrayList, linkedList, n);
        compCollectAFind(arrayList, linkedList, n);
        compCollectAIndex(arrayList, linkedList, n);
        compCollectADelete(arrayList, linkedList, n);

    }

    private static void compCollectADelete(ArrayList<String> arrayList, LinkedList<String> linkedList,
                                           int n) {
        System.out.println("*deleting " + n + " elements");
        long start, end;
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arrayList.remove(arrayList.size() / 2);
        }
        end = System.nanoTime();

        System.out.println("ArrayList = " + (end - start) / 1E6 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedList.remove(arrayList.size() / 2);
        }
        end = System.nanoTime();

        System.out.println("LinkedList = " + (end - start) / 1E6 + " ms");
    }

    public static void compCollectAInsert(ArrayList<String> arrayList,
                                          LinkedList<String> linkedList, int n) {
        String str = "example";
        System.out.println("*inserting " + n + " elements");
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            String strInsert = str + i;
            arrayList.add(0, strInsert);
        }
        long end = System.nanoTime();

        System.out.println("ArrayList = " + (end - start) / 1E6 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            String strInsert = str + i;
            linkedList.add(0, strInsert);
        }
        end = System.nanoTime();

        System.out.println("LinkedList = " + (end - start) / 1E6 + " ms");
    }

    private static void compCollectAFind(ArrayList<String> arrayList, LinkedList<String> linkedList,
                                         int n) {
        String str = "example";
        long start, end;
        System.out.println("*finding " + n + " elements");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            String strInsert = str + i;
            arrayList.indexOf(strInsert);
        }
        end = System.nanoTime();

        System.out.println("arrayList = " + (end - start) / 1E6 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            String strInsert = str + i;
            linkedList.indexOf(strInsert);
        }
        end = System.nanoTime();

        System.out.println("LinkedList = " + (end - start) / 1E6 + " ms");
    }

    private static void compCollectAIndex(ArrayList<String> arrayList, LinkedList<String> linkedList,
                                          int n) {
        long start, end;
        System.out.println("*Index " + n + " elements");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arrayList.get(arrayList.size() / 2);
        }
        end = System.nanoTime();

        System.out.println("arrayList = " + (end - start) / 1E6 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedList.get(linkedList.size() / 2);
        }
        end = System.nanoTime();

        System.out.println("LinkedList = " + (end - start) / 1E6 + " ms");
    }

    public static void compCollectB() {
        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        int n = 100000;
        compCollectBInsert(hashSet, linkedHashSet, treeSet, n);
        compCollectBFind(hashSet, linkedHashSet, treeSet, n);
        compCollectBDelete(hashSet, linkedHashSet, treeSet, n);

    }

    private static void compCollectBDelete(HashSet<String> hashSet,
                                           LinkedHashSet<String> linkedHashSet,
                                           TreeSet<String> treeSet, int n) {
        System.out.println("*deleting " + n + " elements");
        String str = "example";
        long start, end;
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            String strInsert = str + i;
            hashSet.remove(strInsert);
        }
        end = System.nanoTime();

        System.out.println("hashSet = " + (end - start) / 1E6 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            String strInsert = str + i;
            linkedHashSet.remove(strInsert);
        }
        end = System.nanoTime();

        System.out.println("linkedHashSet = " + (end - start) / 1E6 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            String strInsert = str + i;
            treeSet.remove(strInsert);
        }
        end = System.nanoTime();

        System.out.println("treeSet = " + (end - start) / 1E6 + " ms");
    }

    private static void compCollectBFind(HashSet<String> hashSet,
                                         LinkedHashSet<String> linkedHashSet,
                                         TreeSet<String> treeSet, int n) {
        String str = "example";
        System.out.println("*finding " + n + " elements");
        long start, end;
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            String strInsert = str + i;
            hashSet.contains(strInsert);
        }
        end = System.nanoTime();

        System.out.println("hashSet = " + (end - start) / 1E6 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            String strInsert = str + i;
            linkedHashSet.contains(strInsert);
        }
        end = System.nanoTime();

        System.out.println("linkedHashSet = " + (end - start) / 1E6 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            String strInsert = str + i;
            treeSet.contains(strInsert);
        }
        end = System.nanoTime();

        System.out.println("treeSet = " + (end - start) / 1E6 + " ms");
    }

    private static void compCollectBInsert(HashSet<String> hashSet,
                                           LinkedHashSet<String> linkedHashSet,
                                           TreeSet<String> treeSet, int n) {
        String str = "example";
        System.out.println("*inserting " + n + " elements");
        long start, end;
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            String strInsert = str + i;
            hashSet.add(strInsert);
        }
        end = System.nanoTime();

        System.out.println("hashSet = " + (end - start) / 1E6 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            String strInsert = str + i;
            linkedHashSet.add(strInsert);
        }
        end = System.nanoTime();

        System.out.println("linkedHashSet = " + (end - start) / 1E6 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            String strInsert = str + i;
            treeSet.add(strInsert);
        }
        end = System.nanoTime();

        System.out.println("treeSet = " + (end - start) / 1E6 + " ms");

    }

    public static void compCollectC() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        int n = 100000;
        compCollectCInsert(hashMap, linkedHashMap, treeMap, n);
        compCollectCFindByValue(hashMap, linkedHashMap, treeMap, n);
        compCollectCFindByKey(hashMap, linkedHashMap, treeMap, n);
        compCollectCDelete(hashMap, linkedHashMap, treeMap, n);

    }

    private static void compCollectCFindByKey(HashMap<Integer, String> hashMap,
                                              LinkedHashMap<Integer, String> linkedHashMap,
                                              TreeMap<Integer, String> treeMap, int n) {
        System.out.println("*finding by key " + n + " elements");
        long start, end;
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            hashMap.containsKey(i);
        }
        end = System.nanoTime();

        System.out.println("hashMap = " + (end - start) / 1E6 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedHashMap.containsKey(i);
        }
        end = System.nanoTime();

        System.out.println("linkedHashMap = " + (end - start) / 1E6 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            treeMap.containsKey(i);
        }
        end = System.nanoTime();

        System.out.println("treeMap = " + (end - start) / 1E6 + " ms");
    }

    private static void compCollectCDelete(HashMap<Integer, String> hashMap,
                                           LinkedHashMap<Integer, String> linkedHashMap,
                                           TreeMap<Integer, String> treeMap, int n) {
        System.out.println("*deleting " + n + " elements");
        long start, end;
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            hashMap.remove(i);
        }
        end = System.nanoTime();

        System.out.println("hashMap = " + (end - start) / 1E6 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedHashMap.remove(i);
        }
        end = System.nanoTime();

        System.out.println("linkedHashMap = " + (end - start) / 1E6 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            treeMap.remove(i);
        }
        end = System.nanoTime();

        System.out.println("treeMap = " + (end - start) / 1E6 + " ms");

    }

    private static void compCollectCFindByValue(HashMap<Integer, String> hashMap,
                                                LinkedHashMap<Integer, String> linkedHashMap,
                                                TreeMap<Integer, String> treeMap, int n) {
        String str = "example";
        System.out.println("*finding by value " + n + " elements");
        long start, end;
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            String strInsert = str + i;
            hashMap.containsValue(strInsert);
        }
        end = System.nanoTime();

        System.out.println("hashMap = " + (end - start) / 1E6 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            String strInsert = str + i;
            linkedHashMap.containsValue(strInsert);
        }
        end = System.nanoTime();

        System.out.println("linkedHashMap = " + (end - start) / 1E6 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            String strInsert = str + i;
            treeMap.containsValue(strInsert);
        }
        end = System.nanoTime();

        System.out.println("treeMap = " + (end - start) / 1E6 + " ms");
    }

    private static void compCollectCInsert(HashMap<Integer, String> hashMap,
                                           LinkedHashMap<Integer, String> linkedHashMap,
                                           TreeMap<Integer, String> treeMap, int n) {

        String str = "example";
        System.out.println("*inserting " + n + " elements");
        long start, end;
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            String strInsert = str + i;
            hashMap.put(0, strInsert);
        }
        end = System.nanoTime();

        System.out.println("hashMap = " + (end - start) / 1E6 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            String strInsert = str + i;
            linkedHashMap.put(0, strInsert);
        }
        end = System.nanoTime();

        System.out.println("linkedHashMap = " + (end - start) / 1E6 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            String strInsert = str + i;
            treeMap.put(0, strInsert);
        }
        end = System.nanoTime();

        System.out.println("treeMap = " + (end - start) / 1E6 + " ms");
    }
}
