package com.revature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class mainTest {
    @Test
    public void connectionTest(){
        VanquishHashMap.main(null);
        VanquishHashMap<String ,Integer> map = new VanquishHashMap();
        map.put("Chicken",12);
        System.out.println(map.buckets["Chicken".hashCode()].get(0).value);
        Assertions.assertEquals("chicken",map.buckets["Chicken".hashCode()].get(0).value);
    }
}
