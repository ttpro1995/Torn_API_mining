package me.thaithien.torn;

import org.junit.Test;

public class TornRequestTest {

    @Test
    public void collectUserByID() {
        TornRequest collector = new TornRequest();
        collector.setUserAgent(TornRequest.class.getName());
        String result =  collector.requestUserByID("1576144");
        System.out.println(result);
    }
}