package com.company;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.regex.Pattern;

public class PassMapper implements Mapper<String, String>, Runnable{




    private ArrayList<HashMap<String, String>> mapblock = new ArrayList<>();
    private   ArrayList<HashMap<String, String>> list = new  ArrayList<HashMap<String, String>>();
    List<ArrayList>  blockrow;


    public ArrayList<HashMap<String, String>> getList(){
        return list;
    }


    @Override
    public ArrayList<HashMap<String, String>> Mapper(List<ArrayList>  blockrow) {
        List row = new ArrayList();
        ArrayList errorlist = new ArrayList();

        for (int i = 0; i < blockrow.size(); i++) {

            HashMap<String, String> hashmap = new HashMap<>();
            row = blockrow.get(i);
            //if(validate(row)) {


                hashmap.put("Passenger ID", row.get(0).toString());
                hashmap.put("Flight ID", row.get(1).toString());
                hashmap.put("From Airport", row.get(2).toString());
                hashmap.put("Destination", row.get(3).toString());
                hashmap.put("Departure Time", row.get(4).toString());
                hashmap.put("FlightTime", row.get(5).toString());

                list.add(hashmap);
            }
         //   else{
             //   errorlist.add(row);
           // }
        return list;
        }



    public void validate (List row){

/*
        final Pattern pattern = Pattern.compile("^[A-Za-z, ]++$");
        if (!pattern.matcher(row.get(0).toString()).matches()) {

        throw new IllegalArgumentException("Invalid String");

        }
        else {
            return true;
        }
*/
    }


    @Override
    public void run() {
        Mapper(blockrow);
    }
    @Override
    public void setblockrow(List<ArrayList> blockrow) {
        this.blockrow = blockrow;
    }

  /*  @Override
    public Object call() throws Exception {
        Mapper(blockrow);
        return list;
    }*/
}

