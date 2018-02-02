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

        if(found){
            List<String> list = new ArrayList<>(entry.getValue());
            int count =list.size();
            result.put(entry.getKey(),String.valueOf(count) );
        }else{
            result.put(entry.getKey(), String.valueOf(0) );
        }
        System.out.println("RESULT:  " + result);


    /*    List list = new ArrayList(entry.getValue());
        ArrayList valid;
        result = new HashMap<>();
        //List list = new ArrayList(entry.getValue());
        V val = (V) list.get(0);
        int  count = list.size();
         if(Compare(val, mapper)){
             result.put((K)val, (V)String.valueOf(count));
             System.out.println("RESYLT: " + result);
         }*/


       // StringBuilder sb = new StringBuilder();

        // result = sb.append(list.get(0).toString()).append(": ").append(count).toString();
        //System.out.println(list.get(0).toString() + ": " + count);
    }

    public Boolean Compare(String e, ArrayList map) {
        //  ArrayList list = new ArrayList(map.values());
        ArrayList<String> ValidData = new ArrayList<>();
        ArrayList<String> InvalidData = new ArrayList<>();

        if (map.contains(e)) {

            System.out.println("Valid Airport: ");
            ValidData.add(e);
            return true;
        }
        else {
            System.out.println("Invalid Airport: ");
            InvalidData.add(e);
            return false;
        }
    }


    @Override
    public void run() {

    }

    public HashMap<String, String> getresult() {
        return result;
    }


    @Override
    public void setMapper(ArrayList mapper) {
        this.mapper = mapper;

    }
}
