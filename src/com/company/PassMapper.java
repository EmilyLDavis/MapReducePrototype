package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PassMapper {
        //extends Mapperold<Integer, String> {

    public Map<Integer, String> Mapper(List array)

    {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < array.size(); i++) {
            //array.get(i);
            String[] line = array.get(i).toString().split(",");
            String PassId = line[0];
            String FlightId = line[1];
            String From = line[2];
            String Dest = line[3];
            String DeptTime = line[4];
            String FlightTime = line[5];

            // line1.add();

            // Future<Integer> i= exc
            // Mapperold mapper<i, From> = new Mapperold();

            map.put(i, From);


        }
        return map;

    }


}

