
package com.company;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;


public interface Mapper<K, V> extends Runnable {

    public ArrayList<HashMap<K, V>>Mapper(List<ArrayList> blockrow);
    public void setblockrow(List<ArrayList>  blockrow);
    ;
    public ArrayList<HashMap<String, String>> getList();


}
