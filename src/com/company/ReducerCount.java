package com.company;

import java.util.*;

public class ReducerCount extends Reducer<String, String> {
    private HashMap<String, String> result;
    private ArrayList mapper;

    @Override
    public void Reducer(Map.Entry<String, List<String>> entry) {

        result = new HashMap<>();
        Boolean found = false;
        for(  int i =0; i < mapper.size(); i++ ){
            if(entry.getKey().equals(mapper.get(i).toString())){
                found= true;
            }
        }
        List<String> none = new ArrayList<>();
        none.add("0");
        if(found){
            List<String> list = new ArrayList<>(entry.getValue());
            int count =list.size();

            result.put(entry.getKey(),String.valueOf(count));
        }else{
            result.put(entry.getKey(), String.valueOf(0) );
        }
    }

    @Override
    public void run() {

    }

    public HashMap<String,String> getresult() {
        return result;
    }


    @Override
    public void setMapper(ArrayList mapper) {
        this.mapper = mapper;
    }
}
