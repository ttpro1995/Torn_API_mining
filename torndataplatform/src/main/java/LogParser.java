import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringJoiner;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.stream.Stream;


public class LogParser {

    /**
     * Parse single line in log
     * get info about last_action
     * @param inputLine format:  datetime === type === collector === data as json
     * @return  one line of csv with format: datetime userid username last_action
     */
    public static String parseUserLastAction(String inputLine){
        String result="";

        String [] logparts = inputLine.split("===");

        String datetime = logparts[0].trim();
        String dataJsonString = logparts[3].trim();

        JsonObject data = new JsonObject();
        JsonParser parser = new JsonParser();

        data = parser.parse(dataJsonString).getAsJsonObject();

        // get data from json
        String playerId = data.get("player_id").getAsString();
        String playerName = data.get("name").getAsString();
        String lastAction = data.get("last_action").getAsString();

        // build csv
        StringJoiner builder = new StringJoiner("\t");
        builder.add(datetime);
        builder.add(playerId);
        builder.add(playerName);
        builder.add(lastAction);

        result = builder.toString();

        return result;
    }

    /**
     * actually run and parse a log file
     * @param logFileName
     * @param outputFileName
     * @param parseMethod the static method from LogParser (i.e: parseUserLastAction)
     */
    public static void parseLog(String logFileName, String outputFileName, Function<String, String> parseMethod){
        //read file into stream, try-with-resources

        try {
            Stream<String> stream = Files.lines(Paths.get(logFileName));
            FileWriter fw = new FileWriter(outputFileName);
            stream.map(parseMethod).forEach(x -> {
                try{
                    fw.write(x+"\n");
                }catch (IOException e){
                    e.printStackTrace();
                }
            });
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
