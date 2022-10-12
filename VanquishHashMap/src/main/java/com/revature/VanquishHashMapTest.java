package com.revature;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

public class VanquishHashMapTest{
    @Test
    public void connectionTest(){
        VanquishHashMap<String ,Integer> map = new VanquishHashMap<String,Integer>();
        map.put("Chicken",12);
        System.out.println(map.buckets[Math.abs("Chicken".hashCode()%map.maxBucketCapacity)].get(0).getKey());
        Assert.assertEquals("Chicken",map.buckets[Math.abs("Chicken".hashCode()%map.maxBucketCapacity)].get(0).getKey());
    }
    @Test
    public void canPutPair(){
        VanquishHashMap<String, Integer> birdNumber = new VanquishHashMap<String, Integer>();
        birdNumber.put("chicken",9);
        Assertions.assertEquals(9,birdNumber.get("chicken"));
    }
    @Test
    public void forceGrow(){
        VanquishHashMap<String, Integer> birdNumber = new VanquishHashMap<String, Integer>(1);
        birdNumber.put("chicken",9);
        birdNumber.put("chiken",2);
        birdNumber.put("cickn",6);
        birdNumber.put("chicn",10);
        birdNumber.put("chickn",12);
        birdNumber.put("chcken",123);
        birdNumber.put("chic",1234);
        Assertions.assertEquals(7,birdNumber.size());
    }
    @Test
    public void RemoveTest(){
        VanquishHashMap<String, Integer> birdNumber = new VanquishHashMap<String, Integer>(1);
        birdNumber.put("chicken",9);
        birdNumber.put("chiken",2);
        birdNumber.put("cickn",6);
        birdNumber.put("chicn",10);
        birdNumber.put("chickn",12);
        birdNumber.put("chcken",123);
        birdNumber.put("chic",1234);
        birdNumber.remove("chic");
        System.out.println(birdNumber.size());
        Assertions.assertEquals(false,birdNumber.containsKey("chic"));
    }

    @Test
    public void putAlltest(){
        VanquishHashMap<String, Integer> birdNumber = new VanquishHashMap<String, Integer>(1);
        birdNumber.put("chicken",9);
        birdNumber.put("chiken",2);
        birdNumber.put("cickn",6);
        birdNumber.put("chicn",10);
        birdNumber.put("chickn",12);
        birdNumber.put("chcken",123);
        birdNumber.put("chic",1234);
        VanquishHashMap<String, Integer> birdNumber2 = new VanquishHashMap<String, Integer>();
        birdNumber2.putAll(birdNumber);
        Assertions.assertEquals(birdNumber2.size(),birdNumber.size());
    }
    @Test
    public void isEmpty(){
        VanquishHashMap<String, Integer> birdNumber = new VanquishHashMap<String, Integer>(1);
        birdNumber.put("BirdUp",1);
        Assertions.assertEquals(false,birdNumber.isEmpty());
    }
    @Test
    public void containsValue(){
        VanquishHashMap<String, Integer> birdNumber = new VanquishHashMap<String, Integer>(8,(double)0.5);
        birdNumber.put("BirdUp",1);
        birdNumber.put("chicken",9);
        birdNumber.put("chiken",2);
        birdNumber.put("cickn",6);
        birdNumber.put("chicn",10);
        birdNumber.put("chickn",12);
        birdNumber.put("chcken",123);
        birdNumber.put("chic",1234);
        Assertions.assertEquals(true,birdNumber.containsValue(123));
    }

}