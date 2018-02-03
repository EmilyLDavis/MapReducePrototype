package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdditionalMap extends Thread{
    List<ArrayList> blockrow;
    private ArrayList<HashMap<String, String>> list = new ArrayList<>();


    public void Mapper(List<ArrayList> blockrow){
        ArrayList<HashMap> map = new ArrayList<>();
        List row = new ArrayList();
        for (int i = 0; i < blockrow.size(); i++) {
            row = blockrow.get(i);
            HashMap<String, String> hashmap = new HashMap<>();
            //row = correctdata.get(i);
            String k = row.get(0).toString();
            String v = row.get(1).toString();
            hashmap.put(k,v);

            list.add(hashmap);
        }
    }


    public void setblockrow(List<ArrayList> blockrow) {
        this.blockrow = blockrow;
    }
    public ArrayList<HashMap<String, String>> getList() {
        return list;
    }




}
