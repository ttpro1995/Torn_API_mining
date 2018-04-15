package me.thaithien.torn;

import org.junit.Test;

import static org.junit.Assert.*;

public class TornCollectorTest {

    @Test
    public void collectUserByID() {
        TornCollector collector = new TornCollector();
        collector.setUserAgent(TornCollector.class.getName());
        String result =  collector.collectUserByID("1576144");
        System.out.println(result);
    }
}