package com.company;

import javax.xml.transform.Result;
import java.util.*;

    public class Reducer3 extends Reducer<String, String> {
        private HashMap<String, String> result;
        private  ArrayList<ArrayList<HashMap<String, String>>> mapper;

        @Override
        public void Reducer(Map.Entry<String, List<String>> entry) {
        ArrayList data = new ArrayList();
            result = new HashMap<>();
            System.out.println("New CALL TO REDUCER");
            Boolean found = false;
          for(int i =0; i < mapper.size(); i++){
          //  for(int j =0; j < PassArrayList.get(i).size(); j++){
                for (HashMap hm: mapper.get(i)   ) {
                    hm.forEach((key, value) -> {
                        if(entry.getKey().equals(value)) {
                            data.add(value);
                        }

                     //   System.out.println("Key and Val: " + key + " " + value);
                    });
                }
            }
            result.put(entry.getKey(), String.valueOf(data.size()));
           // System.out.println("dATA IS: " +data);

           /* if(found){
                //List<String> list = new ArrayList<>(entry.getValue());
                int count =data.size();
                result.put(entry.getKey(),String.valueOf(count) );
            }else{
                result.put(entry.getKey(), String.valueOf(0) );
            }
            System.out.println("RESULT:  " + result);*/


        }


        @Override
        public void run() {

        }

        public HashMap<String, String> getresult() {
            return result;
        }



        public void setMap( ArrayList<ArrayList<HashMap<String, String>>> mapper) {
            this.mapper = mapper;

        }
    }


