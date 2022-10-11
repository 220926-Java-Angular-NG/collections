package com.revature;
import org.junit.Assert;
import org.junit.Test;

public class VanquishHashMapTest{
    @Test
    public void connectionTest(){
        VanquishHashMap<String ,Integer> map = new VanquishHashMap<String,Integer>();
        map.put("Chicken",12);
        System.out.println(map.buckets[Math.abs("Chicken".hashCode()%map.maxBucketCapacity)].get(0).key);
        Assert.assertEquals("Chicken",map.buckets[Math.abs("Chicken".hashCode()%map.maxBucketCapacity)].get(0).key);
    }
}