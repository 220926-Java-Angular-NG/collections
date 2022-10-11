package com.revature;
import org.junit.Assert;
import org.junit.Test;

public class mainTest {
    @Test
    public void connectionTest(){
        VanquishHashMap<String ,Integer> map = new VanquishHashMap<String,Integer>();
        map.put("Chicken",12);
        System.out.println(map.buckets["Chicken".hashCode()].get(0).value);
        Assert.assertEquals("chicken",map.buckets["Chicken".hashCode()].get(0).value);
    }
}