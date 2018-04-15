/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.thaithien.torn;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.TimerTask;

/**
 *
 * @author thaithien
 */
public class MainApp {



    public static void main(String[] args)  {
        Logger logger = LoggerFactory.getLogger(MainApp.class);
        logger.info("Hello World");

        Configurations configs = new Configurations();
        try
        {
            Configuration config = configs.properties(new File("conf/torn.properties"));
            // access configuration properties
            String user_watch_list_dir = config.getString("torn.user_watch_list");
            System.out.println(user_watch_list_dir);
        }
        catch (ConfigurationException cex)
        {
            // Something went wrong
        }


    }

}
