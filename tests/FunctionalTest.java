package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class FunctionalTest {

    public void testStorage(Shortener shortener) {
        String stra = "AAA";
        String strb = "BBB";
        String strc = "AAA";
        long a = shortener.getId(stra);
        long b = shortener.getId(strb);
        long c = shortener.getId(strc);
        assertNotEquals(a,b);
        assertNotEquals(c,b);
        assertEquals(a,c);
        String sa = shortener.getString(a);
        String sb = shortener.getString(b);
        String sc = shortener.getString(c);
        assertEquals(sa,stra);
        assertEquals(sb,strb);
        assertEquals(sc,strc);
    }
    @Test
    public void testHashMapStorageStrategy() {
        HashMapStorageStrategy hashmap = new HashMapStorageStrategy();
        Shortener s = new Shortener(hashmap);
        testStorage(s);
    }
    @Test
    public void testOurHashMapStorageStrategy() {
        OurHashMapStorageStrategy ourhash = new OurHashMapStorageStrategy();
        Shortener s = new Shortener(ourhash);
        testStorage(s);
    }
    @Test
    public void testFileStorageStrategy() {
        FileStorageStrategy filestor = new FileStorageStrategy();
        Shortener s = new Shortener(filestor);
        testStorage(s);
    }
    @Test
    public void testHashBiMapStorageStrategy() {
        HashBiMapStorageStrategy hashbi = new HashBiMapStorageStrategy();
        Shortener s = new Shortener(hashbi);
        testStorage(s);
    }
    @Test
    public void testDualHashBidiMapStorageStrategy() {
        DualHashBidiMapStorageStrategy dual = new DualHashBidiMapStorageStrategy();
        Shortener s = new Shortener(dual);
        testStorage(s);
    }
    @Test
    public void testOurHashBiMapStorageStrategy() {
        OurHashBiMapStorageStrategy ourhash = new OurHashBiMapStorageStrategy();
        Shortener s = new Shortener(ourhash);
        testStorage(s);
    }
}
