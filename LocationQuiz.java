import java.net.http.HttpClient;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpRequest;

public class LocationQuiz {

    public static int request(String city) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.teleport.org/api/urban_areas/slug:" + city + "/scores/"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println(response.body());


            String s = response.body();
            String[] wordArray = s.split("\\W+");

            //System.out.println(wordArray[wordArray.length - 2]);

            int value = Integer.parseInt(wordArray[wordArray.length - 2]);
            return value;

        } catch (Exception e) {
            System.out.println("request error:" + e);
            return -1;
        } //try-catch

    } //request

} //LocationQuiz
