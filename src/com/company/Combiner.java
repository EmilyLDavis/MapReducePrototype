package com.company;

import java.util.*;

public class Combiner {

    public Map<Integer, String> combine(Map<Integer, String> map) {
        //
          Map<Integer, String> newmap = new HashMap<>();
        ArrayList value = new ArrayList();

     //   newmap.putAll(map);


        for (Map.Entry m : map.entrySet()) {


           /* if (!value.contains(m.getValue())) {
                String val = m.getValue().toString();
                value.add(val);
            }*/
            //newmap.put(m.getKey(), m.getValue());

            //    newmap.merge(m.getKey(), m.getValue(), String::concat);




         //   map.merge((Integer) m.getKey(), m.getValue().toString(), String::concat);


        }

        return map;
    }
}
