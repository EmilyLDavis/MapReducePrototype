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

//        ArrayList<List<ArrayList>> ListofSubList = new ArrayList<List<ArrayList>>();
//        for (int start = 0; start < PassArrayList.size(); start += 20) {
//            int end = Math.min(start + 20, PassArrayList.size());
//
//            List<ArrayList> sublist = PassArrayList.subList(start, end);
//            //  System.out.println(sublist);
//            ListofSubList.add(sublist);
//        }

        /*ArrayList<HashMap<String, String>> Passmap = new ArrayList<>();
        HashMap<String, List<String>> Airportmap = new HashMap<String, List<String>>();
        HashMap<String, List<String>> Sorted = new HashMap<>();
        HashMap<String, List<String>> Combined = new HashMap<>();
        HashMap<String, Integer> Reduced = new HashMap<>();
        ArrayList<HashMap<String, List<String>>> fullist = new ArrayList<>();


        ExecutorService es = Executors.newFixedThreadPool(ListofSubList.size());


        //   for (int i = 0; i < ListofSubList.size(); i++) {
        Mapper mapper = new PassMapper();
        // Thread thread = new Thread(mapper);
       // es.submit(mapper);
       // List<Callable<String>> callableTasks = new ArrayList<>();
        for (int i = 0; i < ListofSubList.size(); i++) {





        mapper.setblockrow(ListofSubList.get(i));
        Future<ArrayList<HashMap<String, String>>> future = es.submit(mapper);

        try {
            Passmap = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        System.out.println(Thread.activeCount());

        Combiner combiner = new Combiner();
        combiner.setMappedList(Passmap);
        Future<HashMap<String, List<String>>> futureC = es.submit(combiner);

        try {
            Combined = futureC.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        es.shutdown();

        ExecutorService exe = Executors.newFixedThreadPool(ListofSubList.size());

        Sorting sort = new Sorting();
        sort.setCombinedList(Combined);
        Future<HashMap<String, List<String>>> futureS = exe.submit(sort);

        try {
            Sorted = futureS.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        es.shutdown();


        fullist.add(Sorted);
        }
*/
        // }

/*

        Reducer reduce = new Reducer();
        Reduced = reduce.Reducer(fullist);

        System.out.println(Reduced);
*/



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
  //      ExecutorService es = Executors.newFixedThreadPool(ListofSubList.size());

     //   for (int i = 0; i < ListofSubList.size(); i++) {
          //  Thread thread = new Thread(mapper);
            //mapper.setblockrow(ListofSubList);
            mapper.Mapper(PassArrayList);
         //   thread.run();


          //  System.out.println(Thread.activeCount());
            Combiner combiner = new Combiner();
            Passmap = combiner.combine(mapper.getList());

            Sorting sort = new Sorting();
            sort.Sorting(Passmap);
//           Sorted = sort.Sorting(Passmap);
          // Sorted = sort.sort();

            fullist.add(Sorted);

       // }


       // Reducer reduce = new Reducer();
      // Reduced = reduce.Reducer(fullist);


        //System.out.println(Reduced);

    }
}
