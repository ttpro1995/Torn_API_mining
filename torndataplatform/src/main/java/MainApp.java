public class MainApp {
    public static void main(String[] args) {
        String wwwww = "WORK IN PROGRESS";


        String s = "2018-04-19 16:30:28.819 === [Timer-0] INFO  === me.thaithien.torn.TornLogger === {\"rank\":\"Reasonable Hitman\",";
        String[] toks = s.split("===");
        for (String ss : toks){
            System.out.println(ss.trim());
        }
    }
}
