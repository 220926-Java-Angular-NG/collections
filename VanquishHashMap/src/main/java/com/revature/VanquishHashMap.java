package com.revature;

import java.util.*;

public class VanquishHashMap<V,K> implements Map {
    int bucketCount = 8; // how many Hash locations exist
    int maxBucketCapacity = 8;  // how long an individual is allowed to get
    double loadFactor = .75;  // load factor, this effects our size variable, and once elements * loadFactor > bucketCount*maxBucketSize
                                // size will double, if any given bucket reaches loadfactor MaxBucketCapacity will increase by 1.5
    int elements = 0; // how key value pairs are stored
    LinkedList<K>[] buckets;
    /**
     *
     */
    public VanquishHashMap() {
        buckets = (LinkedList<K>[]) new LinkedList[bucketCount];
    }

    public VanquishHashMap(int initialCapacity) {
        this.bucketCount = initialCapacity;
        buckets = (LinkedList<K>[]) new LinkedList[bucketCount];

    }
    public VanquishHashMap(int initialCapacity,double loadFactor) {
        this.bucketCount = initialCapacity;
        this.loadFactor=loadFactor;
        buckets = (LinkedList<K>[]) new LinkedList[bucketCount];
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
        return null;
    }

    public Object remove(Object key) {
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
}