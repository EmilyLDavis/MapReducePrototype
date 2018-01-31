package com.company;

import javafx.util.Pair;

import java.awt.desktop.SystemSleepEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Reducer implements Runnable {
    //private StringBuilder sb;
    private String result;

    public void Reducer(Map.Entry<String, List<String>> entry) {
        int count = 0;
        List list = new ArrayList(entry.getValue());
        for (int i = 0; i < list.size(); i++) {
            count++;
        }
        StringBuilder sb = new StringBuilder();
        result = sb.append(list.get(0).toString()).append(": ").append(count).toString();
        System.out.println(list.get(0).toString() + ": " + count);
    }

    public void reduce(Map.Entry<String, List<String>> entry, ArrayList<HashMap<String, String>> mapper) {
        List list = new ArrayList(entry.getValue());
        HashMap<String, List<String>> newl = new HashMap();

        StringBuilder s = new StringBuilder();
        s.append(list.get(1)).append(System.getProperty("line.separator"));
        for (HashMap<String, String> map : mapper) {
            if (map.containsValue(list.get(1).toString())) {

                List<String> temp = new ArrayList();
                temp.add(map.get("Passenger ID"));
                s.append(temp.toString()).append(" ");
                System.out.println(temp.toString());
            }
            //sb.append(temp.toString());

        }
        result = s.toString();
    }

    @Override
    public void run() {

    }

    public String getresult() {
        return result;
    }

    public void setresult(String result) {
        this.result = result;
    }
}
