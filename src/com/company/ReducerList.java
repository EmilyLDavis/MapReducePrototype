package com.company;

import java.util.*;

public class ReducerList<K, V> implements Reducer<K,V> {
    private String result;
    private ArrayList<HashMap<K, V>> mapper;


    @Override
    public void Reducer(Map.Entry<K, List<V>> entry) {
        List list = new ArrayList(entry.getValue());
        HashMap<K, List<V>> newl = new HashMap();

        StringBuilder s = new StringBuilder();
        s.append(list.get(0).toString() ).append(System.getProperty("line.separator"));
        for (HashMap<K, V> map : mapper) {
            if (map.containsValue(list.get(0).toString())) {

                List<V> temp = new ArrayList();
                temp.add(map.get("Passenger ID"));
                s.append(temp.toString()).append(" ");
                System.out.println(temp.toString());
            }

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

    public void setMapper(ArrayList<HashMap<K, V>> mapper) {
        this.mapper = mapper;
    }
}
