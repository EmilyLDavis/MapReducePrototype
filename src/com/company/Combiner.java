package com.company;

import java.util.*;
import java.util.concurrent.Callable;

public class Combiner implements Callable {
  private   HashMap<String, List<String>> combinedlist = new HashMap<String, List<String>>();
  private ArrayList<HashMap<String, String>> mappedList = new ArrayList<HashMap<String, String>>();

    public void setMappedList(ArrayList<HashMap<String, String>> mappedList) {
        this.mappedList = mappedList;
    }

    public HashMap<String, List<String>> combine(ArrayList<HashMap<String, String>> mappedList) {

        List<String> vallist = new ArrayList<String>();

        //for (int i = 0; i < mappedList.size(); i++) {
            for (HashMap<String, String> map : mappedList) {
                for (Map.Entry<String, String> mapEntry : map.entrySet()) {

                    String key = mapEntry.getKey();
                    String value = mapEntry.getValue();
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
           // }
        }

        return combinedlist;
    }

    @Override
    public Object call() throws Exception {
        combine(mappedList);
        return combinedlist;
    }
}



