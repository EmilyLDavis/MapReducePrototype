package com.company;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

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

        try {
            list = mapper.call().get();


        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getValue() + " " + list.get(i).getKey());
        }

    }
}
