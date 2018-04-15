package me.thaithien.torn;





import com.github.kevinsawicki.http.HttpRequest;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * create and call API request
 */
public class TornRequest {

    /**
     * environment variable name that contain torn api
     * in Terminal
     * Type:  export TORN_API=your_torn_api_key
     */
    public static final String ENV_TORN_API = "TORN_API";

    private String userAgent = null;

    public TornRequest(){}

    public void setUserAgent(String userAgent){
        this.userAgent = userAgent;
    }

    public String getUserAgent(){
        return this.userAgent;
    }

    /**
     * Collect summary information of user
     * @param id
     * @return json
     */
    public String requestUserByID(String id){
        String torn_api_key = System.getenv(ENV_TORN_API);
        // https://api.torn.com/user/2096019?key=your_api_key
        String url = "https://api.torn.com/user";
        String charset = java.nio.charset.StandardCharsets.UTF_8.name();
        String result = null;
        try {

            String query = String.format("/%s?key=%s",
                    URLEncoder.encode(id, charset),
                    URLEncoder.encode(torn_api_key, charset));

//            URLConnection connection = new URL(url + query).openConnection();
//            connection.setRequestProperty("Accept-Charset", charset);
//            InputStream response = connection.getInputStream();
//            result = IOUtils.toString(response, StandardCharsets.UTF_8);

            String response = HttpRequest.get(url + query).userAgent(this.userAgent).body();
            result = response;

        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
            result = e.toString();
        }

        return result;
    }

}
