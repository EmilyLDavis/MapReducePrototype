package com.company;

import java.util.*;

public class ReducerList extends Reducer<String,String> {
    private HashMap<String, List<String>> result;
    private  ArrayList<ArrayList<HashMap<String, String>>> mapper;


    @Override
    public void Reducer(Map.Entry<String, List<String>> entry) {
        ArrayList data = new ArrayList();
        List Passengers = new ArrayList();
        result = new HashMap<>();
        for(int i =0; i < mapper.size(); i++){
            for (HashMap hm: mapper.get(i)   ) {
                hm.forEach((key, value) -> {
                    if(entry.getKey().equals(value)) {
                        data.add(value);
                        if(!Passengers.contains(key)) {
                            Passengers.add(key);
                        }

                    }
                });
            }
        }

        result.put(entry.getKey(), Passengers);
    }

    @Override
    public void run() {

    }

    @Override
    public HashMap<String, List<String>> getres() {
        return result;
    }


    public void setM( ArrayList<ArrayList<HashMap<String, String>>> mapper) {
        this.mapper = mapper;

    }
}
