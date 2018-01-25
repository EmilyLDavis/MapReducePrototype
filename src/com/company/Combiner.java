package com.company;

import java.util.*;

public class Combiner {

    public HashMap<String, List<String>> combine(ArrayList<HashMap<String, String>> mappedList) {


        HashMap<String, List<String>> combinedlist = new HashMap<String, List<String>>();

        List<String> vallist = new ArrayList<String>();

        for (int i = 0; i < mappedList.size(); i++) {
            for (HashMap<String, String> map : mappedList) {
                for (Map.Entry<String, String> mapEntry : map.entrySet()) {

                    String key = mapEntry.getKey();
                    String value = mapEntry.getValue();
                    System.out.println(key + value);
                    Boolean bool = combinedlist.keySet().contains(key);
                    if (bool == true) {
                        vallist.add(value);
                        combinedlist.get(key).add(value);
                    }
                    if (!combinedlist.containsKey(mapEntry.getKey())) {
                        List<String> temp = new ArrayList();
                        temp.add(mapEntry.getValue());
                        combinedlist.put(mapEntry.getKey(), temp);

                    }
                }
            }
        }

        return combinedlist;
    }
    
}



