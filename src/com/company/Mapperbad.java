/*

package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Mapper implements Callable {
    private List array;
    //  private Map map;

    private List<Map> maplist = new ArrayList<Map>();
    Map<Integer, String> map = new HashMap<>();
   // Map <Future<Integer, String>> list = new ArrayList<Future<Integer>>();

    public Map<Integer, String> mapper() {

        for (int i = 0; i < array.size(); i++) {
            //array.get(i);
            String[] line = array.get(i).toString().split(",");
            String PassId = line[0];
            String FlightId = line[1];
            String From = line[2];
            String Dest = line[3];
            String DeptTime = line[4];
            String FlightTime = line[5];

           // Future<Integer> i= exc

            map.put(i, From);

        }
        return map;
    }

    public List getArray() {
        return maplist;
    }

    public void setArray(List array) {
        this.array = array;
    }

 */
/*   @Override
    public void run() {
         mapper();
    }
*//*


    @Override
    public Object call() throws Exception {

      //  ExecutorService executor = Executors.newFixedThreadPool(10);
       // Map <Future<Integer, String>> map = new HashMap<Future<Integer, String>>();
       // Map<Future<Integer>, Future<String>> map2 = new HashMap<>();
       // map2 = mapper();
        mapper();
        //mapper();
        return map;
    }
}
*/
