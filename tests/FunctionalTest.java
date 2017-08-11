package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {
    public void testStorage(Shortener shortener) {
        String stra = "AAA";
        String strb = "BBB";
        String strc = "AAA";
        long a = shortener.getId(stra);
        long b = shortener.getId(strb);
        long c = shortener.getId(strc);
        Assert.assertNotEquals(a,b);
        Assert.assertNotEquals(c,b);
        Assert.assertEquals(a,c);
        String sa = shortener.getString(a);
        String sb = shortener.getString(b);
        String sc = shortener.getString(c);
        Assert.assertEquals(sa,stra);
        Assert.assertEquals(sb,strb);
        Assert.assertEquals(sc,strc);
    }
    @Test
    public void testHashMapStorageStrategy() {
        Shortener s = new Shortener(new HashMapStorageStrategy());
        testStorage(s);
    }
    @Test
    public void testOurHashMapStorageStrategy() {
        Shortener s = new Shortener(new OurHashMapStorageStrategy());
        testStorage(s);
    }
    @Test
    public void testFileStorageStrategy() {
        Shortener s = new Shortener(new FileStorageStrategy());
        testStorage(s);
    }
    @Test
    public void testHashBiMapStorageStrategy() {
        Shortener s = new Shortener(new HashBiMapStorageStrategy());
        testStorage(s);
    }
    @Test
    public void testDualHashBidiMapStorageStrategy() {
        Shortener s = new Shortener(new DualHashBidiMapStorageStrategy());
        testStorage(s);
    }
    @Test
    public void testOurHashBiMapStorageStrategy() {
        Shortener s = new Shortener(new OurHashBiMapStorageStrategy());
        testStorage(s);
    }
}
