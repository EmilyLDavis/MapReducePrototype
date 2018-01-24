package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;

public class Main {


    public static void main(String[] args) {
        ArrayList<ArrayList> arrayList = new ArrayList();

        LoadFile loadFile = new LoadFile();
        arrayList = loadFile.loadFile();

        ArrayList<List<ArrayList>> ListofSubList = new ArrayList<List<ArrayList>>();


        for (int start = 0; start < arrayList.size(); start += 20) {
            int end = Math.min(start + 20, arrayList.size());

            List<ArrayList> sublist = arrayList.subList(start, end);
            //  System.out.println(sublist);
            ListofSubList.add(sublist);

        }



        ArrayList<Future<ArrayList<HashMap<String, String>>>> future = new ArrayList<>();
        ArrayList<ArrayList> map = new ArrayList<>();
        ExecutorService es = Executors.newFixedThreadPool(ListofSubList.size());



        for (int i = 0; i < ListofSubList.size(); i++) {
            Mapper mapper = new PassMapper();
            mapper.setblockrow(ListofSubList.get(i));

            Thread t = new Thread(mapper);
            t.run();
            map.add(mapper.getList());

        }
        System.out.println(map);


    }
}
