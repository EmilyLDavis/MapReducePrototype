package com.company;

import java.util.*;
import java.util.concurrent.Callable;

public class AirportMapper extends Mapper<String, String>{

    private ArrayList<HashMap<String, String>> mapblock = new ArrayList<>();
    private   ArrayList<HashMap<String, String>> list = new  ArrayList<HashMap<String, String>>();
    List<ArrayList>  blockrow;

    public ArrayList<HashMap<String, String>> getList(){
        return list;
    }


    @Override
    public ArrayList<HashMap<String, String>> Mapper(List<ArrayList>  blockrow) {
        List row = new ArrayList();
        List BadData = new ArrayList();
        List<ArrayList> correctdata = new ArrayList<>();

        for (int i = 0; i < blockrow.size(); i++) {

            row = blockrow.get(i);
            if (    row.get(0).toString().matches("[A-Z| |/]{3,20}") &&  row.get(0)!= null&&
                    row.get(1).toString().matches("[A-Z]{3}") && row.get(1)!= null&&
                    row.get(2).toString().matches("-?[0-9]{1,2}.[0-9]{6}") && row.get(2)!= null&&
                    row.get(3).toString().matches("-?[0-9]{1,3}.[0-9]{6}") && row.get(3)!= null){
                ArrayList newrow = new ArrayList(row);
                correctdata.add(newrow);
            } else {
                BadData.add(row);
            }
        }


        for (int i = 0; i < correctdata.size(); i++) {

            HashMap<String, String> hashmap = new HashMap<>();
            row = correctdata.get(i);
            hashmap.put("Airport Name", row.get(0).toString());
            hashmap.put("Airport Code", row.get(1).toString());
            hashmap.put("Latitude", row.get(2).toString());
            hashmap.put("Longitude", row.get(3).toString());

            list.add(hashmap);

        }

        return list;
    }

    @Override
    public void setblockrow(List<ArrayList> blockrow) {
        this.blockrow = blockrow;
    }
    @Override
    public void run() {
        Mapper(blockrow);
    }


}

