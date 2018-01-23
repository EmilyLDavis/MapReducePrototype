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
        HashMap hm = new HashMap();
       PassMapper mapper = new PassMapper();

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < ListofSubList.size(); i++) {

          map=  mapper.Mapper(ListofSubList.get(i));

           // mapper.setArray(ListofSubList.get(i));
        //   executor.submit(mapper);


           Combiner combiner = new Combiner();
           combiner.combine(map);

            System.out.println(map);


           /*callable = new Mapper();

            future = executor.submit(callable);
            future.isDone();*/


          /*  try {
     //           System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }*/


            //list.add(future);


        }

      /*  for (int i = 0; i < list.size(); i++) {


                System.out.println(list.get(i).get(future));

        }
*/
/*
        for (Future<Map<Integer, String>> fut : list) {
            try {
                System.out.println(fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

        }*/
    }
}
