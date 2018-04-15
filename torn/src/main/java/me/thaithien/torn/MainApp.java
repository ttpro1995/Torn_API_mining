/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.thaithien.torn;

import java.util.Timer;

/**
 *
 * @author thaithien
 */
public class MainApp {



    public static void main(String[] args)  {
//        Logger logger = LoggerFactory.getLogger(MainApp.class);
//        logger.info("Hello World");
//
//        Configurations configs = new Configurations();
//        try
//        {
//            Configuration config = configs.properties(new File("conf/torn.properties"));
//            // access configuration properties
//            String user_watch_list_dir = config.getString("torn.user_watch_list");
//            System.out.println(user_watch_list_dir);
//        }
//        catch (ConfigurationException cex)
//        {
//            // Something went wrong
//        }

        Timer timer = new Timer();
        timer.schedule(new TornUserTask(), 10000, 60000);



    }

}
