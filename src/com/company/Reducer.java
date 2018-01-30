package com.company;

import javafx.util.Pair;

import java.awt.desktop.SystemSleepEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Reducer implements Runnable {
    private StringBuilder sb;

    public void Reducer(Map.Entry<String, List<String>> entry) {
        int count = 0;
        List list = new ArrayList(entry.getValue());
        for (int i = 0; i < list.size(); i++) {
            count++;

        }

        System.out.println(list.get(1).toString() + " :" + count);

    }

    public void reduce(List list, ArrayList<HashMap<String, String>> mapper) {
        List listofval = new ArrayList();
        HashSet dist = new HashSet();
        HashMap<String, List<String>> newl = new HashMap();

       sb.append(list.get(1)).append("/n");


        for (HashMap<String, String> map : mapper) {

            if(map.containsValue(list.get(1).toString())){

                List<String> temp = new ArrayList();
                temp.add(map.get("Passenger ID"));
               sb.append(temp.toString());
                //newl.put(list.get(1).toString(), temp);

            }

        }
        LoadFile file = new LoadFile();
        file.printfile(sb);

      /*  for (Map.Entry<String, List<String>> n : newl.entrySet()) {
            System.out.println(n.getKey() + ": ");
            for(String s: n.getValue()){
                System.out.println(s);
            }
        }*/

    }

    @Override
    public void run() {

    }

    public StringBuilder getSb() {
        return sb;
    }

    public void setSb(StringBuilder sb) {
        this.sb = sb;
    }
}
