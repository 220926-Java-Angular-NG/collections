package com.revature;

import java.util.*;

public class VanquishHashMap<K,V> implements Map {
    int bucketCount = 8; // how many Hash locations exist
    int maxBucketCapacity = 8;  // how long an individual is allowed to get
    double loadFactor = .75;  // load factor, this effects our size variable, and once elements * loadFactor > bucketCount*maxBucketCapacity
                                // size will double, if any given bucket reaches loadfactor MaxBucketCapacity will increase by 1.5
    int elements = 0; // how key value pairs are stored
    LinkedList<Node>[] buckets;
    /**
     *
     * @params
     *
     */
    public VanquishHashMap() {
        initBuckets();
    }

    public VanquishHashMap(int initialCapacity) {
        this.bucketCount = initialCapacity;
        initBuckets();
    }
    public VanquishHashMap(int initialCapacity,double loadFactor) {
        this.bucketCount = initialCapacity;
        this.loadFactor=loadFactor;
        initBuckets();
    }
    public void initBuckets(){
        buckets = (LinkedList<Node>[]) new LinkedList[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new LinkedList();
        }
    }
    // Map functions
    public int size() {
        return bucketCount;
    }

    public boolean isEmpty() {
        return elements == 0;
    }

    public boolean containsKey(Object key) {
        return false;
    }

    public boolean containsValue(Object value) {
        return false;
    }

    public Object get(Object key) {
        return null;
    }

    public Object put(Object key, Object value) {
        int code = Math.abs(key.hashCode()%bucketCount);
        buckets[code].add(new Node(key,value));
        elements ++;
        if(checkCapacity(code)){
            grow();
        }
        return value;
    }

    public V remove(Object key) {
        return null;
    }

    public void putAll(Map m) {

    }

    public void clear() {

    }

    public Set keySet() {
        return null;
    }

    public Collection values() {
        return null;
    }

    public Set<Entry> entrySet() {
        return null;
    }
    // map functions


    public boolean checkCapacity(int code){
        return (elements * loadFactor > bucketCount*maxBucketCapacity || buckets[code].size()*loadFactor > maxBucketCapacity);
    }
    public void grow(){
     return;
    }

    public static void main(String[] args) {

    }
}