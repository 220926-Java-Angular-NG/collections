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
     * This is the default constructor for the hashmap
     * that calls initBuckets method
     *
     */

    public VanquishHashMap() {
        initBuckets();
    }
    /**
     * @param initialCapacity is passed in as a parameter and this sets the number
     * of buckets in the hash table
     */

    public VanquishHashMap(int initialCapacity) {
        this.bucketCount = initialCapacity;
        initBuckets();
    }
    /** Initial capacity and load factor passes in as parameters
     * @param loadFactor set to 75% so to prevent the hash table from overloading
     * @param initialCapacity sets how many buckets the Map starts with
     * sets upper limit of how full the hash table is allowed to get which is when
     * number of entries > loadfactor * current capacity of the hash table
     * the table is then rehashed automatically and capacity is doubled
     */

    public VanquishHashMap(int initialCapacity,double loadFactor) {
        this.bucketCount = initialCapacity;
        this.loadFactor=loadFactor;
        initBuckets();
    }
    /** Initial capacity and load factor passes in as parameters
     * @param loadFactor set to 75% so to prevent the hash table from overloading
     * sets upper limit of how full the hash table is allowed to get which is when
     * number of entries > loadfactor * current capacity of the hash table
     * the table is then rehashed automatically and capacity is doubled
     */
    public VanquishHashMap(double loadFactor) {
        this.loadFactor=loadFactor;
        initBuckets();
    }
    /**
     * Intializes the linked lists effectivly clearing the table, and creating a new with correct specifications.
     */

    public void initBuckets(){
        elements = 0;
        buckets = (LinkedList<Entry>[]) new LinkedList[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new LinkedList();
        }
    }
    // Map functions

    /**
     *
     * @return the number of key value pairs store within the map
     */
    public int size() {
        return elements;
    }

    /**
     *
     * @return true only if there are 0 elements within the map
     */
    public boolean isEmpty() {
        return elements == 0;
    }

    /**
     *
     * @param key key whose presence in this map is to be tested
     * @return true if the map contains siad key false otherwise
     */
    public boolean containsKey(Object key) {
        int code = Math.abs(key.hashCode()%bucketCount);
        for(Entry nodes:buckets[code]){
            if(nodes.getKey().equals(key)){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param value value whose presence in this map is to be tested
     * @return true if the map contains the value
     */
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

    /**
     *
     * @param key the key whose associated value is to be returned
     * @return gets the value from the key given, otherwise returns null
     */
    public Object get(Object key) {
            int code = key.hashCode()%bucketCount;

            for (Entry node:buckets[code]){
                if (node.getKey() == key)
                    return node.getValue();

            }
            return null;
        }

    /**
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the value object provided is returned after it has been paired
     * with the key object provided. If there was a value already associated with
     * the key provided, then the object value provided replaced the previous
     * value.
     */

    public Object put(Object key, Object value) {
        if(this.containsKey(key)){
            for(LinkedList<Entry> lists: buckets){
                for(Entry node:lists){
                    if(node.getKey().equals(key)){
                        Object res = node.getValue();
                        node.setValue(value);
                        return res;
                    }
                }
            }
        }else{
        int code = Math.abs(key.hashCode()%bucketCount);
        buckets[code].add(new Node(key,value));
        elements ++;
        grow(checkCapacity(code));
        }
        return null;
    }
    /**
     *
     * @param input, an Entry Object, which contains a key and value, so call put(key,value)
     * @return the value object provided is returned after it has been paired
     * with the key object provided. If there was a value already associated with
     * the key provided, then the object value provided replaced the previous
     * value.
     */
    public Object put(Entry input) {
        return put(input.getKey(),input.getValue());
    }

    public V remove(Object key) {
        int code = key.hashCode()%bucketCount;
        for (Entry node:buckets[code]){
            if (node.getKey() == key) {
                V res = (V) node.getValue();
                buckets[code].remove(node);
                elements --;
                return res;
            }
        }
        return null;
    }
    /**
     *
     * @param m, an entire map of key value pairs, to be called in a loop
     * @return nothing
     */
    public void putAll(Map m) {
        Set<Entry> nodes = m.entrySet();
        for (Entry node: nodes){
            put(node);
        }
    }

    /**
     * Empties the HashMap
     */
    public void clear() {
        elements = 0;
        initBuckets();
    }

    /**
     *
     * @return Returs a set of all keys used within the map
     */
    public Set keySet() {
        Set<Object> keys = new HashSet<Object>();

        for (LinkedList<Entry> nodes : buckets){
            for (Entry node: nodes){
                keys.add(node.getKey());
            }
        }

        return keys;
    }

    /**
     *
     * @return returns a list of all values stored in the map
     */
    public Collection values() {
        List<Object> values = new ArrayList<Object>();

        for (LinkedList<Entry> nodes : buckets){
            for (Entry node: nodes){
                values.add(node.getValue());
            }
        }

        return values;
    }

    /**
     *
     * @return Gives the set of all key value pairs.
     */
    public Set<Entry> entrySet() {
        Set<Entry> nodes = new HashSet<Entry>();

        for (LinkedList<Entry> lst : buckets){
            for(Entry node:lst) {
                nodes.add((Entry) node);
            }
        }

        return nodes;
    }
    // map functions

    /**
     *
     * @param code hashcode to investigate a specific bucket
     * @return a 0 1 2 or 3, to be used in grow function
     */
    public int checkCapacity(int code){
        int res = 0;
        if(elements > bucketCount * maxBucketCapacity * loadFactor ){
            res = res + 1; //
        }
        if(buckets[code].size()*loadFactor > maxBucketCapacity){
            res = res + 2;
        }
        return res;
    }
    /**
     *
     * @param type Takes in an integer from the checkCapacity method,
     * and doubles the bucketCount, maxBucketCapacity, or both. Takes the
     * LinkedLists from the previous array. Creates a new LinkedList array with
     * the new bucketCount and maxBucketCapacity, and inserts the old elements to
     * the new array.
     */

    public void grow(int type) {
        Set<Entry> old;
        switch (type) {
            case 1: //Increase buckets
                this.bucketCount = 2 * bucketCount;
                old = this.entrySet();
                initBuckets();
                for (Entry entry : old) {
                    put(entry);
                }
                break;
            case 2: // Increase bucket capacity
                this.maxBucketCapacity = 2 * maxBucketCapacity;
                return;
            case 3: // Increase both;
                this.bucketCount = 2 * bucketCount;
                this.maxBucketCapacity = 2 * bucketCount;
                old = this.entrySet();
                initBuckets();
                for (Entry entry : old) {
                    put(entry);
                }
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {

    }
}