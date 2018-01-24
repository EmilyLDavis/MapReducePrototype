package com.company;

import java.util.HashMap;
import java.util.Map;

public class Reducer {

    public void Reducer(Map<String, String> map){
        Map<String, String> reducedmap = new HashMap();

       // reducedmap.merge()

      for (Map.Entry m : map.entrySet()) {
             map.merge( m.getKey().toString(), m.getValue().toString(), String::concat);

        }



    }
}
