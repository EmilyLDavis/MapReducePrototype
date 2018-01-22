package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class Main {


    public static void main(String[] args) {
        List arrayList = new ArrayList();

        LoadFile loadFile = new LoadFile();
        arrayList = loadFile.loadFile();

        ArrayList<List<String>> ListofSubList = new ArrayList<List<String>>();


        for (int start = 0; start < arrayList.size(); start += 10) {
            int end = Math.min(start + 10, arrayList.size());

            List<String> sublist = arrayList.subList(start, end);
            //  System.out.println(sublist);
            ListofSubList.add(sublist);

        }

        ExecutorService executor = Executors.newFixedThreadPool(ListofSubList.size());
        List<Future<Map<Integer, String>>> list = new ArrayList<Future<Map<Integer, String>>>();
        Mapper mapper = new Mapper();

        for (int i = 0; i < ListofSubList.size(); i++) {

            mapper.setArray(ListofSubList.get(i));

            Callable<Map<Integer, String>> callable = new Mapper();

            Future<Map<Integer, String>> future = executor.submit(callable);

            list.add(future);
        }


        for (Future<Map<Integer, String>> fut : list) {
            try {

                System.out.println(fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }


        }
    }
}
