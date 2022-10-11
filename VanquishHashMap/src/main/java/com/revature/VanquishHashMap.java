package com.revature;
import java.util.*;

public class VanquishHashMap<K,V> implements Map {
    int bucketCount = 8; // how many Hash locations exist
    int maxBucketCapacity = 8;  // how long an individual is allowed to get
    double loadFactor = .75;  // load factor, this effects our size variable, and once elements * loadFactor > bucketCount*maxBucketCapacity
                                // size will double, if any given bucket reaches loadfactor MaxBucketCapacity will increase by 1.5
    int elements = 0; // how key value pairs are stored
    LinkedList<Entry>[] buckets;
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
        elements = 0;
        buckets = (LinkedList<Entry>[]) new LinkedList[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new LinkedList();
        }
    }
    // Map functions
    public int size() {
        return elements;
    }

    public boolean isEmpty() {
        return elements == 0;
    }

    public boolean containsKey(Object key) {
        int code = Math.abs(key.hashCode()%bucketCount);
        for(Entry nodes:buckets[code]){
            if(nodes.getKey().equals(key)){
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object value) {
        for(LinkedList<Entry> lists: buckets){
            for(Entry node:lists){
                if(node.getValue().equals(value)){
                    return true;
                }
            }
        }
        return false;
    }

    public Object get(Object key) {
            int code = key.hashCode()%bucketCount;

            for (Entry node:buckets[code]){
                if (node.getKey() == key)
                    return node.getValue();

            }
            return null;
        }

    public Object put(Object key, Object value) {
        int code = Math.abs(key.hashCode()%bucketCount);
        buckets[code].add(new Node(key,value));
        elements ++;
        grow(checkCapacity(code));
        return value;
    }
    public void put(Entry input) {
        int code = Math.abs(input.getKey().hashCode()%bucketCount);
        buckets[code].add(input);
        elements ++;
        grow(checkCapacity(code));
    }

    public V remove(Object key) {
        return null;
    }

    public void putAll(Map m) {
        Set<Entry> nodes = m.entrySet();
        for (Entry node: nodes){
            put(node);
        }
    }

    public void clear() {
        elements = 0;
        initBuckets();
    }

    public Set keySet() {
        Set<Object> keys = new HashSet<Object>();

        for (LinkedList<Entry> nodes : buckets){
            for (Entry node: nodes){
                keys.add(node.getKey());
            }
        }

        return keys;
    }

    public Collection values() {
        List<Object> values = new ArrayList<Object>();

        for (LinkedList<Entry> nodes : buckets){
            for (Entry node: nodes){
                values.add(node.getValue());
            }
        }

        return values;
    }

    public Set<Entry> entrySet() {
        Set<Entry> nodes = new HashSet<Entry>();

        for (LinkedList<Entry> node : buckets){
            nodes.add((Entry) node);
        }

        return nodes;
    }
    // map functions


    public int checkCapacity(int code){
        int res = 0;
        if(elements * loadFactor > bucketCount*maxBucketCapacity){
            res = res + 1; //
        }
        if(buckets[code].size()*loadFactor > maxBucketCapacity){
            res = res + 2;
        }
        return res;
    }
    public void grow(int type){
        switch (type){
        case 1: //Increase buckets
            this.bucketCount = 2*bucketCount;
            break;
        case 2: // Increase bucket capacity
            this.maxBucketCapacity = 2*maxBucketCapacity;
            return;
        case 3: // Increase both;
            this.bucketCount = 2*bucketCount;
            this.maxBucketCapacity = 2*bucketCount;
            break;
        default:
            break;
        }
        Set<Entry> old = this.entrySet();
        initBuckets();
        for (Entry entry:old){
            put(entry);
        }
    }

    public static void main(String[] args) {

    }
}