package com.company;

import java.util.*;
import java.util.concurrent.Callable;

public class Combiner<K,V> implements Callable {
  private   HashMap<K, List<V>> combinedlist = new HashMap<>();
  private ArrayList<HashMap<K, V>> mappedList = new ArrayList<>();

    public void setMappedList(ArrayList<HashMap<K, V>> mappedList) {
        this.mappedList = mappedList;
    }

    public HashMap<K, List<V>> combine(ArrayList<HashMap<K, V>> mappedList) {

        List<V> vallist = new ArrayList<>();

        //for (int i = 0; i < mappedList.size(); i++) {
            for (HashMap<K, V> map : mappedList) {
                for (Map.Entry<K, V> mapEntry : map.entrySet()) {

                    K key = mapEntry.getKey();
                    V value = mapEntry.getValue();
                    Boolean bool = combinedlist.keySet().contains(key);
                    if (bool == true) {
                        vallist.add(value);
                        combinedlist.get(key).add(value);
                    }
                    if (!combinedlist.containsKey(mapEntry.getKey())) {
                        List<V> temp = new ArrayList();
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



