import org.junit.Test;
import sun.rmi.runtime.Log;

import java.util.StringJoiner;

import static org.junit.Assert.*;

public class LogParserTest {

    @Test
    public void parseUserLastAction() {
        String rawSentence = "2018-04-19 16:30:28.819 === [Timer-0] INFO  === me.thaithien.torn.TornLogger === {\"rank\":\"Reasonable Hitman\",\"level\":14,\"gender\":\"Male\",\"property\":\"Mansion\",\"signup\":\"2018-03-06 03:53:26\",\"awards\":36,\"friends\":2,\"enemies\":1,\"forum_posts\":2,\"karma\":0,\"age\":44,\"role\":\"Civilian\",\"donator\":1,\"player_id\":2106002,\"name\":\"Stone_Head\",\"property_id\":1595497,\"last_action\":\"3 hours ago\",\"life\":{\"current\":603,\"maximum\":603,\"increment\":30,\"interval\":300,\"ticktime\":272,\"fulltime\":0},\"status\":[\"Okay\",\"\"],\"job\":{\"position\":\"Employee\",\"company_id\":44557,\"company_name\":\"Strength gym, hiring\"},\"faction\":{\"position\":\"Member\",\"faction_id\":27902,\"days_in_faction\":12,\"faction_name\":\"Yakuza - Infinity\"},\"married\":{\"spouse_id\":0,\"spouse_name\":\"None\",\"duration\":0},\"icons\":{\"icon6\":\"Male\",\"icon3\":\"Donator\",\"icon4\":\"Subscriber\",\"icon27\":\"Company - Employee of Strength gym, hiring (Furniture Store)\",\"icon9\":\"Faction - Member of Yakuza - Infinity\"}}";
        String result = LogParser.parseUserLastAction(rawSentence);
        System.out.println(result);
        StringJoiner builder = new StringJoiner("\t");
        builder.add("2018-04-19 16:30:28.819");
        builder.add("2106002");
        builder.add("Stone_Head");
        builder.add("3 hours ago");
        String expected = builder.toString();
        assertEquals(expected, result);
    }


    @Test
    public void parseLog() {
        String inputFile = "testdata/19042018_daily_torn.log";
        String outputFile = "testdata/19042018_daily_torn.csv";
        LogParser.parseLog(inputFile, outputFile, LogParser::parseUserLastAction);
    }
}