/*
package com.company;

import java.util.*;

public class ReducerList<K, V> implements Reducer<K,V> {
    private String result;
    private ArrayList<HashMap<K, V>> mapper;


    @Override
    public void Reducer(Map.Entry<K, List<V>> entry) {
        List<V> list = new ArrayList(entry.getValue());
        List<V> passlist = new ArrayList();
            StringBuilder sb = new StringBuilder();
        System.out.println("Flight ID: " + list.get(0) + "  ");
        sb.append("Flight ID").append(list.get(0)).append(System.getProperty("line.separator"));

        for(HashMap<K, V> hm : mapper){
            if(hm.get("Flight ID").equals(list.get(0))){
                passlist.add(hm.get("Passenger ID"));

                sb.append("Passenger ID").append(System.getProperty("line.separator"));
                System.out.println( hm.get("Passenger ID"));
            }
        }
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
*/
