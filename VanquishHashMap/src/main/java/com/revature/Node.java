package com.revature;

public class Node<K,V> {
    V value;
    K key;
    public Node(K key, V value){
        this.key = key;
        this.value = value;
    }
}
