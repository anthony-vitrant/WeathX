import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.List;

public class WeatherAPI {
    String APIkey="459efbd5093b3213f4ee6f05999fde8c";

    public String GetWeatherByLatLon(String lat, String lon) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid="+APIkey))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        WeatherAPI api = new WeatherAPI();
        NominatimAPI nominatimAPI = new NominatimAPI();
        String json = nominatimAPI.getLatLonByCityName("Rochefort-du-Gard");
        List<String> latlon = nominatimAPI.getLatLonFromJson(json);
        api.GetWeatherByLatLon(latlon.get(0), latlon.get(1));
    }
}
// working