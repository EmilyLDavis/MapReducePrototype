package com.company;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reducer {

    public  HashMap<String,Integer> Reducer( ArrayList<HashMap<String, List<String>>> sortedList) {
        List<String> vallist = new ArrayList<>();
        for(int i =0; i <sortedList.size(); i++) {
            List<String>  temp = new ArrayList(sortedList.get(i).values());
            vallist.addAll(temp);
        }

        //sortedList

       // Pair<String, Integer> pair = new Pair<>();
        HashMap<String,Integer> no = new HashMap<>();
        ArrayList<Pair<String, Integer>> listpair = new ArrayList<>();


        int count = 0;
        //vallist = sortedList.values();

        for (int i = 0; i < sortedList.size(); i++) {

            for (Map.Entry<String, List<String>> mapEntry : sortedList.get(i).entrySet()) {
            //System.out.println(mapEntry);
                vallist = mapEntry.getValue();
                for(int j=0; j <vallist.size(); j++){
                    if(!no.containsKey(vallist.get(j))){
                        String key = vallist.get(j);
                        int c =1;
                        no.put(vallist.get(j), c);



                    }else if(no.keySet().contains(vallist.get(j))) {

                        String key = vallist.get(j);
                        count++;
                        no.put(vallist.get(j), count);
                    }

                }
            }

        }

        return no;
    }

    public void red( List list){
        int count=0;
        for(int i =0; i <list.size(); i++){
            count++;

        }
        System.out.println(list.get(1).toString() + " :" +count);
    }
}
