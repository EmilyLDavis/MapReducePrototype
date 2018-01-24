package com.company;

import java.util.*;

public class Combiner {

    public Map<String, String> combine(Map<String, String> map) {
        //
          Map<String, String> newmap = new HashMap<>();

        Map<String, String> groupval = new HashMap<>();




        for (Map.Entry m : map.entrySet()) {

            if(map.containsKey(m.getKey())){
                map.merge( m.getKey().toString(), m.getValue().toString(), String::concat);
            }

           /* if(!map.containsKey(m.getKey())){
                list.add(m.getKey());


                newmap.get(m.getKey()).add(m.getValue());

                newmap.put(m.getKey().toString(), list);
            }
            list.add(m.getValue());

            map.get(m.getKey());*/

           // map.merge( m.getKey().toString(), m.getValue().toString(), String::concat);

        }

        return map;
    }
}
