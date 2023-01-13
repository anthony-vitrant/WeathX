import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class OpenStreetMapAPI {
    public String getHotelsByLatLon(String lat , String lon) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://nominatim.openstreetmap.org/search.php?q=hotel+near+"+lat+"%2C"+lon+"&format=jsonv2"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("HOTELS = "+response.body());
        return response.body();
    }

    public String getRestaurantsByLatLon(String lat , String lon) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://nominatim.openstreetmap.org/search.php?q=restaurant+near+"+lat+"%2C"+lon+"&format=jsonv2"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("RESTAURANTS = "+response.body());
        return response.body();
    }

    public String getParkingsByLatLon(String lat , String lon) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://nominatim.openstreetmap.org/search.php?q=parking+near+"+lat+"%2C"+lon+"&format=jsonv2"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("PARKINGS = "+response.body());
        return response.body();
    }

    public String getGasStationByLatLon(String lat , String lon) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://nominatim.openstreetmap.org/search.php?q=gas+near+"+lat+"%2C"+lon+"&format=jsonv2"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("GAS STATIONS = "+response.body());
        return response.body();
    }



    //this one can be optionnal
    public String getParksByLatLon(String lat , String lon) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://nominatim.openstreetmap.org/search.php?q=park+near+"+lat+"%2C"+lon+"&format=jsonv2"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("PARKS = "+response.body());
        return response.body();
    }

    // only working in London
    public String getSupermarketByLatLon(String lat , String lon) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://nominatim.openstreetmap.org/search.php?q=shop%3Dsupermarket+near+"+lat+"%2C"+lon+"&format=jsonv2"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("SUPERMARKETS = "+response.body());
        return response.body();
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        OpenStreetMapAPI api = new OpenStreetMapAPI();
        NominatimAPI api2 = new NominatimAPI();
        String json = api2.getLatLonByCityName("Trento");
        List<String> latlon = api2.getLatLonFromJson(json);
        api.getHotelsByLatLon(latlon.get(0), latlon.get(1));
        api.getRestaurantsByLatLon(latlon.get(0), latlon.get(1));
        api.getParkingsByLatLon(latlon.get(0), latlon.get(1));
        api.getGasStationByLatLon(latlon.get(0), latlon.get(1));
        api.getParksByLatLon(latlon.get(0), latlon.get(1));
        api.getSupermarketByLatLon(latlon.get(0), latlon.get(1));
    }
}
