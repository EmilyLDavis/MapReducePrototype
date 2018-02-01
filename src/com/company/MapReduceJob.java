package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapReduceJob {

    public MapReduceJob(ArrayList<ArrayList> PassArrayList, String key, String r) {

        ArrayList<List<ArrayList>> ListofSubList = new ArrayList<List<ArrayList>>();
        for (int start = 0; start < PassArrayList.size(); start += 20) {
            int end = Math.min(start + 20, PassArrayList.size());

            List<ArrayList> sublist = PassArrayList.subList(start, end);
            ListofSubList.add(sublist);
        }
        ArrayList<HashMap<String, List<String>>> Passmap = new ArrayList<>();
        ArrayList<HashMap<String, String>> result = new ArrayList<>();

        HashMap<String, List<String>> combined = new HashMap<String, List<String>>();
        HashMap<String, List<String>> Sorted = new HashMap();

        for (List sublist : ListofSubList) {
            Mapper mapper = new PassMapper();
            Thread t = new Thread(mapper);
            mapper.setblockrow(sublist);
            t.run();

            Combiner combiner = new Combiner();
            result = mapper.getList();
            combined = combiner.combine(result);

            Passmap.add(combined);

        }

        Sorting sort = new Sorting();
        sort.Sorting(Passmap, key);
        Sorted = sort.getSortedList();
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, List<String>> entry : Sorted.entrySet()) {
            if (r.equals("ReducerList")) {
                Reducer reducer = new ReducerList<String, String>();
                reducer.setMapper(result);
                reducer.Reducer(entry);
                Thread t = new Thread(reducer);
                t.run();
                sb.append(System.getProperty("line.separator")).append(reducer.getresult()).toString();
            } else {
                Reducer reducer = new ReducerCount<String, String>();
                reducer.Reducer(entry);
                Thread t = new Thread(reducer);
                t.run();
                sb.append(System.getProperty("line.separator")).append(reducer.getresult()).toString();
                // reducer.Reducer(entry);
            }
        }

        String string = sb.toString();
        LoadFile lf = new LoadFile();
        lf.printfile(string);

    }
}

