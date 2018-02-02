package com.company;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.regex.*;

import static javafx.scene.input.KeyCode.Z;

public class PassMapper extends Mapper<String, String> {


    private ArrayList<HashMap<String, String>> mapblock = new ArrayList<>();
    private ArrayList<HashMap<String, String>> list = new ArrayList<>();
    List<ArrayList> blockrow;


    public ArrayList<HashMap<String, String>> getList() {
        return list;
    }


    @Override
    public ArrayList<HashMap<String, String>> Mapper(List<ArrayList> blockrow) {
        List row = new ArrayList();

        List BadData = new ArrayList();
        ArrayList errorlist = new ArrayList();
        List<ArrayList> correctdata = new ArrayList<>();
        List<ArrayList> ListData = new ArrayList<>();

        for (int i = 0; i < blockrow.size(); i++) {

            row = blockrow.get(i);
            if (row.get(0).toString().matches("[A-Z]{3}[0-9]{4}[A-Z]{2}[0-9]") &&
                    row.get(1).toString().matches("[A-Z]{3}[0-9]{4}[A-Z]") &&
                    row.get(2).toString().matches("[A-Z]{3}") &&
                    row.get(3).toString().matches("[A-Z]{3}") &&
                    row.get(4).toString().matches("[0-9]{10}") &&
                    row.get(5).toString().matches("[0-9]{1,4}")) {
                ArrayList newrow = new ArrayList(row);
                correctdata.add(newrow);
            }else{
                BadData.addAll(row);
            }


        }


        for (int i = 0; i < correctdata.size(); i++) {

            HashMap<String, String> hashmap = new HashMap<>();
            //row = correctdata.get(i);
            hashmap.put("Passenger ID", correctdata.get(i).get(0).toString());
            hashmap.put("Flight ID", correctdata.get(i).get(1).toString());
            hashmap.put("From Airport", correctdata.get(i).get(2).toString());
            hashmap.put("Destination", correctdata.get(i).get(3).toString());
            hashmap.put("Departure Time", correctdata.get(i).get(4).toString());
            hashmap.put("FlightTime", correctdata.get(i).get(5).toString());


            list.add(hashmap);
        }

        return list;
    }



    @Override
    public void run() {
        Mapper(blockrow);
    }

    @Override
    public void setblockrow(List<ArrayList> blockrow) {
        this.blockrow = blockrow;
    }


}

