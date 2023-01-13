import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TrailAPI {

    public String GetTrailsByLatLon(String lat, String lon) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://trailapi-trailapi.p.rapidapi.com/trails/explore/?lat="+lat+"&lon="+lon))
                .header("X-RapidAPI-Key", "75c57a6c66msh39969c817ae241bp1c2d6cjsn7261c4374359")
                .header("X-RapidAPI-Host", "trailapi-trailapi.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        TrailAPI api = new TrailAPI();
        api.GetTrailsByLatLon("40.0274", "-105.2519");
    }
}
