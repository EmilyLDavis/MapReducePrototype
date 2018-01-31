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
        PassArrayList = loadFile.loadFile("C:\\Users\\edavi\\Documents\\AComp_Passenger_data.csv");
        ArrayList<ArrayList> AirportArrayList = new ArrayList();
        AirportArrayList = loadFile.loadFile("C:\\Users\\edavi\\Documents\\Top30_airports_LatLong.csv");


        ArrayList<List<ArrayList>> ListofSubList = new ArrayList<List<ArrayList>>();
        for (int start = 0; start < PassArrayList.size(); start += 20) {
            int end = Math.min(start + 20, PassArrayList.size());

            List<ArrayList> sublist = PassArrayList.subList(start, end);
            ListofSubList.add(sublist);
        }

       ArrayList<HashMap<String, List<String>>> Passmap = new ArrayList<>();
        ArrayList<HashMap<String, String>> result = new ArrayList<>();

        HashMap<String, List<String>> combined = new HashMap<String, List<String>>();
        HashMap<String, List<String>> Sorted = new HashMap();

        for (List sublist: ListofSubList ) {
            Mapper mapper = new PassMapper();
            Thread t = new Thread(mapper);
            mapper.setblockrow(sublist);
            t.run();

            Combiner combiner = new Combiner();
            result = mapper.getList();
            combined = combiner.combine(result);

            Passmap.add(combined);

        }

        Sorting sort = new Sorting();
        sort.Sorting(Passmap);
        Sorted = sort.getSortedList();

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, List<String>> entry: Sorted.entrySet()) {
            Reducer reducer = new Reducer();
            reducer.Reducer(entry);
        //    reducer.reduce(entry, result);
            Thread t = new Thread(reducer);
            t.run();

          sb.append(System.getProperty("line.separator")). append(reducer.getresult()).toString();
        }

        String string = sb.toString();
        LoadFile lf = new LoadFile();
        lf.printfile(string);

    }
}
