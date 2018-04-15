package me.thaithien.torn;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TornLoggerTest {

    @Test
    public void getWatchListFromFile() {
        TornLogger logger = TornLogger.getInstance();
        List<String> result = logger.getWatchListFromFile("watchlist/user.txt");
        System.out.println(result);
    }
}