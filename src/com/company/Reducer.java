package com.company;

import java.util.HashMap;
import java.util.Map;

public class Reducer {

    public void Reducer(Map<String, String> map){
        Map<String, String> reducedmap = new HashMap();

       // reducedmap.merge()


  /*      for(int i =0; i < mappedList.size(); i++){
            // Set<Map.Entry<String,String> m = mappedList.get(i).entrySet();

            for(Map.Entry<String, String> e : mappedList.get(i).entrySet()) {
                if(!combinedlist.containsKey(e.getKey())) {

                    String key = e.getKey();
                    value.add(e.getValue());

                    combinedlist.put(key, value);
                }

            }*/


            for (Map.Entry m : map.entrySet()) {
             map.merge( m.getKey().toString(), m.getValue().toString(), String::concat);

        }



    }
}
