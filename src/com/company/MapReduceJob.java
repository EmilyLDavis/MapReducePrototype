package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapReduceJob {
    //  private   ArrayList<ArrayList> AirportArrayList;

    public MapReduceJob(ArrayList<ArrayList> PassArrayList, String key, String r, int Q, ArrayList<ArrayList> AirportArrayList) {
        HashMap<String, List<String>> Airmap = new HashMap<>();
        ArrayList<ArrayList<HashMap<String, String>>> Passengers = new ArrayList<>();
        HashMap<String, List<String>> Sorted = new HashMap<String, List<String>>();
        ArrayList<List<ArrayList>> ListSubList = new ArrayList<>();

        if (Q == 1) {
            Airmap = getSortedData(makeList(AirportArrayList), "Airport Code", "Airport");
            Sorted = getSortedData(makeList(PassArrayList), key, "PassMap");
        }
        if (Q == 3) {
            Airmap = getSortedData(makeList(AirportArrayList), "Airport Code", "Airport");
            Sorted = getSortedData(makeList(PassArrayList), key, "PassMap");
            ArrayList<AdditionalMap> t = new ArrayList<>();
          // Passengers= callMap("P", makeList(PassArrayList));

            // Passengers = getSortedData(makeList(PassArrayList), "Passenger ID" , "PassMap");
            ListSubList = makeList(PassArrayList);

            for (int i = 0; i < ListSubList.size(); i++) {
               AdditionalMap map = new AdditionalMap();
                t.add(map);
               // map.setblockrow(ListSubList.get(i));
                map.Mapper(ListSubList.get(i));
                t.get(t.size() - 1).start();
            }
            Passengers.clear();

            for (int i = 0; i < t.size(); i++) {
                try {
                    t.get(i).join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Passengers.add(t.get(i).getList());
            }
        }


        ArrayList al = new ArrayList(Airmap.keySet());
        ArrayList<HashMap<String, String>> FinalResult = new ArrayList<>();
        ArrayList<Reducer> threads = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : Sorted.entrySet()) {
            //   System.out.println("Sorted List: " + entry);
            /*if(r.equals("ReducerList")) {
                Reducer reducer = new ReducerList<String, String>();
                reducer.setMapper(PassMapResult);
                reducer.Reducer(entry);
                Thread t = new Thread(reducer);
                t.run();
                sb.append(System.getProperty("line.separator")).append(reducer.getresult()).toString();
            }*/
            if(Q==1) {
                Reducer reducer = new ReducerCount();
                reducer.setMapper(al);
                reducer.Reducer(entry);
                threads.add(reducer);
                threads.get(threads.size() - 1).start();
            }else if(Q==3){
                Reducer reducer = new Reducer3();
                reducer.setMap(Passengers);
                reducer.Reducer(entry);
                threads.add(reducer);
                threads.get(threads.size() - 1).start();
            }

        }
        for (int i = 0; i < threads.size(); i++) {
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            FinalResult.add(threads.get(i).getresult());
        }
        if (Q == 1) {
            Q1(FinalResult, al);
        } else if (Q == 3) {
            StringBuilder sb = new StringBuilder();
            sb.append("Number of Passengers on each flight: ").append(System.getProperty("line.separator"));
            for(int i =0; i < FinalResult.size(); i ++){
                sb.append(FinalResult.get(i)).append(System.getProperty("line.separator"));
            }
            String string = sb.toString();
            LoadFile lf = new LoadFile();

            lf.printfile(sb.toString(), "Output3.txt");
        }

    }

    public void Q1(ArrayList<HashMap<String, String>> FinalResult, ArrayList al) {
        StringBuilder sb = new StringBuilder();
        sb.append("Flight List: ");
        for (HashMap hm : FinalResult) {
            hm.forEach((key1, value) -> {
                sb.append(System.getProperty("line.separator")).append(key1.toString()).append(" - ").append(value);

            });
        }

        ArrayList keyset = new ArrayList();
        for (HashMap hm : FinalResult) {
            hm.forEach((key1, value) -> keyset.add(key1.toString()));
        }

        for (int i = 0; i < al.size(); i++) {
            for (int j = 0; j < keyset.size(); j++) {
                if (keyset.get(j).toString().equals(al.get(i).toString())) {
                    al.remove(i);
                }
            }
        }

        sb.append(System.getProperty("line.separator")).append("No Flights From: ");
        for (int i = 0; i < al.size(); i++) {
            System.out.println("No flights " + al.get(i) + " 0");
            sb.append(System.getProperty("line.separator")).append(al.get(i));
        }

        String string = sb.toString();
        LoadFile lf = new LoadFile();
        lf.printfile(sb.toString(), "Output1");
    }

    public ArrayList<List<ArrayList>> makeList(ArrayList<ArrayList> AirportArrayList) {

        ArrayList<List<ArrayList>> ListSubList = new ArrayList<>();
        for (int start = 0; start < AirportArrayList.size(); start += 20) {
            int end = Math.min(start + 20, AirportArrayList.size());

            List<ArrayList> sublist = AirportArrayList.subList(start, end);
            ListSubList.add(sublist);
        }
        return ListSubList;

    }

    public HashMap<String, List<String>> getSortedData(ArrayList<List<ArrayList>> ListSubList, String key, String Mapper) {

        ArrayList<HashMap<String, List<String>>> Airmap = new ArrayList<>();
        ArrayList<HashMap<String, String>> res = new ArrayList<>();
        ArrayList<ArrayList<HashMap<String, String>>> mapperresult = new ArrayList<>();

        HashMap<String, List<String>> comb = new HashMap<String, List<String>>();

        ArrayList<Combiner> cthreads = new ArrayList<>();

        mapperresult = callMap(Mapper, ListSubList);

        for (int i = 0; i < mapperresult.size(); i++) {
            Combiner combiner = new Combiner();
            cthreads.add(combiner);
            combiner.combine(mapperresult.get(i));
            cthreads.get(cthreads.size() - 1).start();
        }
        for (int i = 0; i < cthreads.size(); i++) {
            try {
                cthreads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Airmap.add(cthreads.get(i).getCombinedList());

        }


        HashMap<String, List<String>> Sorted = new HashMap<String, List<String>>();
        Sorting sort = new Sorting();
        sort.Sorting(Airmap, key);
        Sorted = sort.getSortedList();


        return Sorted;

    }

    public ArrayList<ArrayList<HashMap<String, String>>> callMap(String Mapper, ArrayList<List<ArrayList>> ListSubList) {
        ArrayList<Mapper> threads = new ArrayList<>();
        ArrayList<ArrayList<HashMap<String, String>>> mapperresult = new ArrayList<>();
        if (Mapper.equals("Airport")) {
            for (List sublist : ListSubList) {
                Mapper mapper = new AirportMapper();
                threads.add(mapper);
                mapper.setblockrow(sublist);
                threads.get(threads.size() - 1).start();
            }
        } else if(Mapper.equals("PassMap")){
            for (List sublist : ListSubList) {
                Mapper mapper = new PassMapper();
                threads.add(mapper);
                mapper.setblockrow(sublist);
                threads.get(threads.size() - 1).start();
            }
        }
        for (int i = 0; i < threads.size(); i++) {
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mapperresult.add(threads.get(i).getList());

        }
        return mapperresult;
    }

   /* public void setAirportArrayList(ArrayList<ArrayList> airportArrayList) {
        AirportArrayList = airportArrayList;
    }*/
}

