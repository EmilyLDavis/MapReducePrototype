package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        LoadFile loadFile = new LoadFile();
        int question = 1;
        ArrayList<ArrayList> PassArrayList = new ArrayList();
        PassArrayList = loadFile.loadFile("C:\\Users\\edavi\\Documents\\AComp_Passenger_data.csv");
        ArrayList<ArrayList> AirportArrayList = new ArrayList();
        AirportArrayList = loadFile.loadFile("C:\\Users\\edavi\\Documents\\Top30_airports_LatLong.csv");

        if(question == 1) {
            String key = "From Airport";
            String reducer = "ReducerCount";
            MapReduceJob mapReduceJob = new MapReduceJob(PassArrayList, key, reducer);

        }else if(question ==2){
            String key = "Flight ID";
            String reducer = "ReducerList";
            MapReduceJob mapReduceJob = new MapReduceJob(PassArrayList, key, reducer);


        }else if(question ==3){
            String key = "Flight ID";
            String reducer = "ReducerCount";
            MapReduceJob mapReduceJob = new MapReduceJob(PassArrayList, key, reducer);


        }


    }
}
