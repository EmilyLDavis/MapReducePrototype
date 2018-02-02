package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapReduceJob {
    //  private   ArrayList<ArrayList> AirportArrayList;

    public MapReduceJob(ArrayList<ArrayList> PassArrayList, String key, String r, int Q, ArrayList<ArrayList> AirportArrayList) {
        HashMap<String, List<String>> Airmap = new HashMap<>();
        HashMap<String, List<String>> Sorted = new HashMap<String, List<String>>();
        if (Q == 1) {
            Airmap = getAirMap(AirportArrayList, "Airport Code", "Airport");
            Sorted = getAirMap(PassArrayList, key, "PassMap");
        }
        if(Q ==3){
            Airmap = getAirMap(PassArrayList, "Passenger ID", "PassMap");
            Sorted = getAirMap(PassArrayList, key, "PassMap");
        }


        StringBuilder sb = new StringBuilder();


        ArrayList al = new ArrayList(Airmap.keySet());
       // ArrayList q3 = new ArrayList()

        ArrayList<HashMap<String, String>> FinalResult = new ArrayList<>();
        ArrayList<Reducer> threads = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : Sorted.entrySet()) {
         //   System.out.println("Sorted List: " + entry);
           /* if(r.equals("ReducerList")) {
                Reducer reducer = new ReducerList<String, String>();
                reducer.setMapper(PassMapResult);
                reducer.Reducer(entry);
                Thread t = new Thread(reducer);
                t.run();
                sb.append(System.getProperty("line.separator")).append(reducer.getresult()).toString();
            }
            else{*/

            Reducer reducer = new ReducerCount();
            reducer.setMapper(al);
            reducer.Reducer(entry);
            threads.add(reducer);
           threads.get(threads.size()-1).start();

        }
        for(int i =0; i < threads.size(); i++){
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            FinalResult.add(threads.get(i).getresult());
        }
        Q1(FinalResult, al);

    }

    public void Q1(  ArrayList<HashMap<String, String>> FinalResult,  ArrayList al ){
        StringBuilder sb = new StringBuilder();
        sb.append("Flight List: ");
        for (HashMap hm: FinalResult) {
            hm.forEach((key1, value) -> {
                sb.append(System.getProperty("line.separator")).append(key1.toString()).append(" - ").append(value);

            });
        }

        ArrayList keyset = new ArrayList();
        for (HashMap hm : FinalResult) {
            hm.forEach((key1, value) -> keyset.add(key1.toString()));
        }

        for (int i = 0; i < al.size(); i++) {
            for(int j =0; j < keyset.size(); j++) {
                if (keyset.get(j).toString().equals(al.get(i).toString())) {
                    al.remove(i);
                }
            }
        }

        sb.append(System.getProperty("line.separator")).append("No Flights From: " );
        for (int i = 0; i < al.size(); i++) {
            System.out.println("No flights " + al.get(i) + " 0");
            sb.append(System.getProperty("line.separator")).append(al.get(i));
        }

        String string = sb.toString();
        LoadFile lf = new LoadFile();
        lf.printfile(sb.toString());
    }

    public HashMap<String, List<String>> getAirMap(ArrayList<ArrayList> AirportArrayList, String key, String Mapper) {

        ArrayList<HashMap<String, List<String>>> Airmap = new ArrayList<>();
        ArrayList<List<ArrayList>> ListSubList = new ArrayList<>();
        for (int start = 0; start < AirportArrayList.size(); start += 20) {
            int end = Math.min(start + 20, AirportArrayList.size());

            List<ArrayList> sublist = AirportArrayList.subList(start, end);
            ListSubList.add(sublist);
        }

        ArrayList<HashMap<String, String>> res = new ArrayList<>();
        ArrayList<ArrayList<HashMap<String, String>>> mapperresult = new ArrayList<>();

        HashMap<String, List<String>> comb = new HashMap<String, List<String>>();
        ArrayList<Mapper> threads = new ArrayList<>();
        ArrayList<Combiner> cthreads = new ArrayList<>();

        if(Mapper.equals("Airport")){
            for (List sublist : ListSubList) {
                Mapper mapper = new AirportMapper();
                threads.add(mapper);
                mapper.setblockrow(sublist);
                threads.get(threads.size()-1).start();

            }

        }
        else {
            for (List sublist : ListSubList) {
                Mapper mapper = new PassMapper();
                threads.add(mapper);
                mapper.setblockrow(sublist);
                threads.get(threads.size() - 1).start();

            }
        }
            for(int i =0; i < threads.size(); i++){
                try {
                    threads.get(i).join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mapperresult.add(threads.get(i).getList());

            }
            for(int i =0; i < mapperresult.size(); i++){
                Combiner combiner = new Combiner();
                cthreads.add(combiner);
                combiner.combine(mapperresult.get(i));
                cthreads.get(cthreads.size()-1).start();
            }
            for(int i =0; i < cthreads.size(); i++){
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

   /* public void setAirportArrayList(ArrayList<ArrayList> airportArrayList) {
        AirportArrayList = airportArrayList;
    }*/
}

