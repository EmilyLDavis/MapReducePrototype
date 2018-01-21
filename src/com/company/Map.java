
package com.company;
import java.util.*;

public class Map<Key, Value> {
    private Key key;
    private Value value;


    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }
}


