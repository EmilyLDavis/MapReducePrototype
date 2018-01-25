package com.company;

import java.util.*;

public class Sorting {

    public HashMap<String, List<String>> Sorting(HashMap<String, List<String>> combinedList) {

        HashMap<String, List<String>> sortedList = new HashMap<String, List<String>>();
        String key = "From Airport";

        ArrayList list = new ArrayList(combinedList.get("From Airport"));
        Collections.sort(list);
        sortedList.put(key, list);
        return sortedList;

    }

}
