package Controller;

import Model.NominatimAPI;
import Model.OpenStreetMapAPI;
import Model.WeatherAPI;

import java.io.IOException;
import java.util.List;

public class Controller {
    OpenStreetMapAPI openStreetMapAPI = new OpenStreetMapAPI();
    NominatimAPI nominatimAPI = new NominatimAPI();
    WeatherAPI weatherAPI = new WeatherAPI();
    List<String> latlon;

    public String getHotelsByCityName(String cityName) throws IOException, InterruptedException {
        latlon = nominatimAPI.getLatLonFromJson(nominatimAPI.getLatLonByCityName(cityName));
        return null;
    }

    public String getRestaurantsByCityName(String cityName) throws IOException, InterruptedException {
        latlon = nominatimAPI.getLatLonFromJson(nominatimAPI.getLatLonByCityName(cityName));
        return null;
    }

    public String getParkingsByCityName(String cityName) throws IOException, InterruptedException {
        latlon = nominatimAPI.getLatLonFromJson(nominatimAPI.getLatLonByCityName(cityName));
        return null;
    }

    public String getMuseumsByCityName(String cityName) throws IOException, InterruptedException {
        latlon = nominatimAPI.getLatLonFromJson(nominatimAPI.getLatLonByCityName(cityName));
        return null;
    }


}
