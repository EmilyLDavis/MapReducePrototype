package com.company;

import java.util.*;
import java.util.concurrent.Callable;

public class Sorting implements Callable {
    HashMap<String, List<String>> combinedList = new HashMap<String, List<String>>();
    private HashMap<String, List<String>> sortedList = new HashMap<String, List<String>>();
    ArrayList<HashMap<String, String>> passmap = new ArrayList<>();
    private List list = new ArrayList();


    public HashMap getSortedList() {
        return sortedList;
    }

    public void setPassmap(ArrayList<HashMap<String, String>> passmap) {
        this.passmap = passmap;
    }


    public void Sorting(ArrayList<HashMap<String, List<String>>> combinedList) {

        HashMap<String, List<String>> List = new HashMap<String, List<String>>();
        String key = "Flight ID";

        for (int i = 0; i < combinedList.size(); i++) {
           list.add(combinedList.get(i).get(key));
           // list.add(l);

        }


        //  Collections.sort(list);
        HashSet<String> uniqueValues = new HashSet<>(list);


        for (String s : uniqueValues) {
            List<String> temp = new ArrayList();
            for (int j = 0; j < list.size(); j++) {
                String val = list.get(j).toString();

                if (s.equals(val)) {
                    temp.add(val);
                    sortedList.put(s, temp);
                }
            }

        }

    }


    @Override
    public Object call() throws Exception {
        // Sorting(combinedList);
        return sortedList;
    }
}
