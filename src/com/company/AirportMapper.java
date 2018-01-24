package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirportMapper {

    public Map<String, String> Mapper(List array)

    {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < array.size(); i++) {
            //array.get(i);
            String[] line = array.get(i).toString().split(",");
            String AirportName = line[0];
            String AirportCode = line[1];
            String Latitude = line[2];
            String Longtitude = line[3];

            map.put("Passenger ID", AirportName);
            map.put("FlightID", AirportCode);
            map.put("From Airport", Latitude);
            map.put("Destination", Longtitude );



        }
        return map;

    }
}
