package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Mapper implements Callable {
    private ArrayList array;

    private ArrayList<Map> maplist = new ArrayList<Map>();
    Map map = new Map();
    Map newMap = new Map();

    public void mapper() {

        for (int i = 0; i < array.size(); i++) {
            //array.get(i);
            String[] line = array.get(i).toString().split(",");
            String  PassId = line[0];
            String FlightId = line[1];
            String From = line[2];
            String Dest = line[3];
            String DeptTime = line[4];
            String FlightTime = line[5];

            map.setKey(i);
            map.setValue(From);


            maplist.add(map.getKey());


        }

    }

    public Future<ArrayList<Map>> call() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable call = new Callable() {
            @Override
            public Object call() throws Exception {
                mapper();
                return maplist;
            }

        };
        return executorService.submit(call);
    }

    // ArrayList<myObject> lst_MyObjects= new ArrayList<myObject>();
    /* return lst_MyObjects;*/


    public ArrayList getArray() {
        return array;
    }

    public void setArray(ArrayList array) {
        this.array = array;
    }


 /*   Map<Integer,String> map=new HashMap<Integer,String>();
  map.put(100,"Amit");
  map.put(101,"Vijay");
  map.put(102,"Rahul");
  for(Map.Entry m:map.entrySet()){
        System.out.println(m.getKey()+" "+m.getValue());
    }*/


}
