package com.company;

import java.util.*;

public interface Reducer<K, V> extends Runnable {

    public void Reducer(Map.Entry<K, List<V>> entry);

    @Override
    public void run();

    public String getresult();

    public void setresult(String result);

    public void setMapper(ArrayList<HashMap<K, V>> mapper);
}
