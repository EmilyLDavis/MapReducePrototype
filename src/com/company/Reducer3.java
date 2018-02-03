package com.company;

import java.util.*;

    public class Reducer3 extends Reducer<String, String> {
        private HashMap<String, String> result;
        private  ArrayList<ArrayList<HashMap<String, String>>> mapper;

        @Override
        public void Reducer(Map.Entry<String, List<String>> entry) {
        ArrayList data = new ArrayList();
            result = new HashMap<>();
            System.out.println("New CALL TO REDUCER");
          for(int i =0; i < mapper.size(); i++){
                for (HashMap hm: mapper.get(i)   ) {
                    hm.forEach((key, value) -> {
                        if(entry.getKey().equals(value)) {
                            data.add(value);
                        }

                    });
                }
            }
            result.put(entry.getKey(), String.valueOf(data.size()));
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


