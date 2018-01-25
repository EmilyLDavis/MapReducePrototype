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

        ArrayList<ArrayList> Passmap = new ArrayList<>();

        for (int i = 0; i < ListofSubList.size(); i++) {
            Mapper mapper = new PassMapper();
            mapper.setblockrow(ListofSubList.get(i));

            Thread t = new Thread(mapper);
            t.run();
            Passmap.add(mapper.getList());

        }

        ArrayList<List<ArrayList>> ListofAirportList = new ArrayList<List<ArrayList>>();
        for (int start = 0; start < AirportArrayList.size(); start += 20) {
            int end = Math.min(start + 20, AirportArrayList.size());

            List<ArrayList> sublist = PassArrayList.subList(start, end);
            //  System.out.println(sublist);
            ListofAirportList.add(sublist);
        }

       ArrayList<HashMap<String, List<String>>> Airportmap = new ArrayList<HashMap<String, List<String>>>();

        for (int i = 0; i < ListofAirportList.size(); i++) {
            Mapper mapper = new AirportMapper();
            mapper.setblockrow(ListofAirportList.get(i));

            Thread t = new Thread(mapper);
            t.run();
            Combiner combiner= new Combiner();
            Airportmap.add(combiner.combine(mapper.getList()));


           // Airportmap.add(mapper.getList());

        }
        System.out.println(Airportmap);



    }
}
