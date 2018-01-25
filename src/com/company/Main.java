package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
            //  System.out.println(sublist);
            ListofSubList.add(sublist);
        }

        HashMap<String, List<String>> Passmap = new HashMap<>();
        HashMap<String, List<String>> Airportmap = new HashMap<String, List<String>>();
        HashMap<String, List<String>> Sorted = new HashMap<>();
        HashMap<String, Integer> Reduced = new HashMap<>();
        ArrayList<HashMap<String, List<String>>> fullist = new ArrayList<>();

        Mapper mapper = new PassMapper();
        ExecutorService es = Executors.newFixedThreadPool(ListofSubList.size());

        for (int i = 0; i < ListofSubList.size(); i++) {
            Thread thread = new Thread(mapper);
            mapper.setblockrow(ListofSubList.get(i));
            thread.run();

            System.out.println(Thread.activeCount());
            Combiner combiner = new Combiner();
            Passmap = combiner.combine(mapper.getList());

            Sorting sort = new Sorting();
            Sorted = sort.Sorting(Passmap);
            fullist.add(Sorted);

        }


        Reducer reduce = new Reducer();
        Reduced = reduce.Reducer(fullist);

        System.out.println(Reduced);





      /*  ArrayList<List<ArrayList>> ListofAirportList = new ArrayList<List<ArrayList>>();
        for (int start = 0; start < AirportArrayList.size(); start += 20) {
            int end = Math.min(start + 20, AirportArrayList.size());

            List<ArrayList> sublist = PassArrayList.subList(start, end);
            //  System.out.println(sublist);
            ListofAirportList.add(sublist);
        }



        for (int i = 0; i < ListofAirportList.size(); i++) {
            Mapper mapper = new AirportMapper();
            mapper.setblockrow(ListofAirportList.get(i));

            Thread t = new Thread(mapper);
            t.run();
            Combiner combiner= new Combiner();
            Airportmap = combiner.combine(mapper.getList());
            Sorting sort = new Sorting();
            Sorted = sort.Sorting(Airportmap);


        }


        Reducer reduce = new Reducer();
        Reduced = reduce.Reducer(Sorted);
       System.out.println(Reduced);


*/
    }
}
