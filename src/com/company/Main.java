package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        LoadFile loadFile = new LoadFile();

        ArrayList<ArrayList> PassArrayList = new ArrayList();
        PassArrayList = loadFile.loadFile("C:\\Users\\edavi\\Documents\\AComp_Passenger_data_no_error.csv");
        ArrayList<ArrayList> AirportArrayList = new ArrayList();
        AirportArrayList = loadFile.loadFile("C:\\Users\\edavi\\Documents\\Top30_airports_LatLong.csv");


        ArrayList<List<ArrayList>> ListofSubList = new ArrayList<List<ArrayList>>();
        for (int start = 0; start < PassArrayList.size(); start += 20) {
            int end = Math.min(start + 20, PassArrayList.size());

            List<ArrayList> sublist = PassArrayList.subList(start, end);
            ListofSubList.add(sublist);
        }

       ArrayList<HashMap<String, List<String>>> Passmap = new ArrayList<>();

        HashMap<String, List<String>> combined = new HashMap<String, List<String>>();
        HashMap<String, List<String>> Sorted = new HashMap();
        HashMap<String, Integer> Reduced = new HashMap<>();
        ArrayList<HashMap<String, List<String>>> fullist = new ArrayList<>();

        for (List sublist: ListofSubList ) {
            Mapper mapper = new PassMapper();
            Thread t = new Thread(mapper);
            mapper.setblockrow(sublist);
           // mapper.Mapper(sublist);
            t.run();

            Combiner combiner = new Combiner();
            combined = combiner.combine(mapper.getList());

            Passmap.add(combined);

        }


        Sorting sort = new Sorting();
       // sort.setPassmap(Passmap);
        sort.Sorting(Passmap);
        Sorted = sort.getSortedList();

        for (Map.Entry<String, List<String>> entry: Sorted.entrySet()) {
            Reducer reducer = new Reducer();
            reducer.Reducer(entry);
         //  Runnable r = new Runnable();

            Thread t = new Thread(reducer);
            t.run();

            //reducer.getSb();

        }


        //Reducer reducer = new Reducer();



        //  System.out.println(PassArrayList.get());
        // System.out.println(Passmap.entrySet());

    }
}
