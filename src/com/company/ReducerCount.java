package com.company;

import java.util.*;

public class ReducerCount<K, V> implements Reducer<K,V> {
    private String result;
    private ArrayList<HashMap<K, V>> mapper;

    @Override
    public void Reducer(Map.Entry<K, List<V>> entry) {
        int count = 0;
        List list = new ArrayList(entry.getValue());
        for (int i = 0; i < list.size(); i++) {
            count++;
        }
        StringBuilder sb = new StringBuilder();
       // result = sb.append(list.get(0).toString()).append(": ").append(count).toString();
        System.out.println(list.get(0).toString() + ": " + count);
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

    @Override
    public void setMapper(ArrayList<HashMap<K, V>> mapper) {
        this.mapper = mapper;

    }
}
