package com.company;

import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.Callable;

public class Sorting implements Callable {
    HashMap<String, List<String>> combinedList = new HashMap<String, List<String>>();
    HashMap<String, List<String>> sortedList = new HashMap<String, List<String>>();

    public void setCombinedList(HashMap<String, List<String>> combinedList) {
        this.combinedList = combinedList;
    }



    public void Sorting(HashMap<String, List<String>> combinedList) {

        HashMap<String, List<String>> sortedList = new HashMap<String, List<String>>();
        String key = "From Airport";

        ArrayList list = new ArrayList(combinedList.get("From Airport"));
        Collections.sort(list);
        HashSet<String> uniqueValues = new HashSet<>(list);


        for (String s : uniqueValues) {
            ArrayList newlist = new ArrayList();
            for (int j = 0; j < list.size(); j++) {
                String val = list.get(j).toString();

                if (s.equals(val)) {
                    newlist.add(list.get(j));
                }
            }

            Reducer reducer = new Reducer();
            reducer.red(newlist);
        }
    }

    @Override
    public Object call() throws Exception {
        Sorting(combinedList);
        return sortedList;
    }
}
