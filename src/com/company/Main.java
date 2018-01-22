package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
      //  Future<ArrayList> arrList = new Future<ArrayList>();
//        ArrayList <Future<ArrayList<Map>>> list = new ArrayList<Future<ArrayList>>();
       ArrayList<Map> list = new ArrayList<Map>();

        LoadFile loadFile = new LoadFile();
        arrayList = loadFile.loadFile();


        Mapper mapper = new Mapper();
        mapper.setArray(arrayList);
      //  mapper.mapper();
       // Thread thread = new Thread(mapper);
        //thread.run();
        Map<Integer, String> map = new HashMap<Integer, String>();

       // list = mapper.call().;
       map = mapper.mapper();




      // list = mapper.getArray();

        for(Map.Entry m:map.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }

       /* for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
*/
    }
}
