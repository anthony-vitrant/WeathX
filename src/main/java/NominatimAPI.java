import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class NominatimAPI {

    public String getLatLonByCityName(String CityName) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://nominatim.openstreetmap.org/search?q="+CityName+"&format=json"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("NOMINATIM REVERSE = "+response.body());
        return response.body();
    }

    public List<String> getLatLonFromJson(String json) {
        String[] objects = json.split("},");
        //System.out.println( "FIRST RESULT = "+objects[0] );

        String[] lat1 = objects[0].split("\"lat\":\"");
        String[] lat2 = lat1[1].split("\",");
        String lat = lat2[0];

        String[] lon1 = objects[0].split("\"lon\":\"");
        String[] lon2 = lon1[1].split("\",");
        String lon = lon2[0];

        System.out.println("latitude = "+ lat );
        System.out.println("longitude = "+ lon );

        return List.of(lat, lon);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        NominatimAPI api = new NominatimAPI();
        String json = api.getLatLonByCityName("Rochefort-du-Gard");
        api.getLatLonFromJson(json);
    }
}
// working