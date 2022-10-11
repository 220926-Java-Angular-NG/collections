package com.revature;
import java.util.*;


public class Node<K,V> implements Map.Entry {
    V value;
    K key;
    public Node(K key, V value){
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public Object setValue(Object value) {
        Object val = this.value;
        this.value = (V) value;
        return val;
    }
}
