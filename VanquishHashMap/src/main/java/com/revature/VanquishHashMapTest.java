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
        birdNumber.put("chicken",2);
        birdNumber.put("chicken",6);
        birdNumber.put("chicken",10);
        birdNumber.put("chicken",12);
        birdNumber.put("chicken",123);
        birdNumber.put("chicken",1234);
        System.out.println(birdNumber.size());
        Assertions.assertEquals(1234,birdNumber.get("chicken"));
    }
    @Test
    public void testHashMap(){
        Map<String, Integer> birdNumber = new HashMap<String, Integer>(1);
        birdNumber.put("chicken",9);
        birdNumber.put("chicken",2);
        birdNumber.put("chicken",6);
        birdNumber.put("chicken",10);
        birdNumber.put("chicken",12);
        birdNumber.put("chicken",123);
        birdNumber.put("chicken",1234);
        System.out.println(birdNumber.size());
        Assertions.assertEquals(1234,birdNumber.get("chicken"));
    }
}