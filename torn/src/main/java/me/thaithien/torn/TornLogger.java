package me.thaithien.torn;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Use Torn Request to make API call
 * Then write to log
 */
public class TornLogger {

    private TornRequest tornRequest;
    private Logger logger = LoggerFactory.getLogger(MainApp.class);
    private List<String> watchList = null;
    protected String userWatchlistDir = null;

    private List<String> userWatchList = null;

    private static TornLogger INSTANCE = new TornLogger();

    private TornLogger(){
        this.tornRequest = new TornRequest();
        Configurations configs = new Configurations();
        try
        {
            Configuration config = configs.properties(new File("conf/torn.properties"));
            // access configuration properties
            userWatchlistDir = config.getString("torn.user_watch_list", "watchlist/user.txt");
        }
        catch (ConfigurationException cex)
        {
            userWatchlistDir = "watchlist/user.txt"; //default value
        }
    }

    /**
     * read user watch list from file
     * @param path
     */
    public List<String> getWatchListFromFile(String path){
        List<String> result = null;
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            result = stream.collect(Collectors.toList());
        } catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }

    public static TornLogger getInstance(){
        return INSTANCE;
    }

    /**
     * Request status of user and write to log
     * @param userId
     * @return
     */
    public String getUserById(String userId){
        String result = tornRequest.requestUserByID(userId);
        logger.info(result);
        return result;
    }

    /**
     * get info of user in list
     */
    public void getUser(){

    }



}
