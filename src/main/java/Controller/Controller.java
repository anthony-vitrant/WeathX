package Controller;

import Model.HotelParser;
import Model.NominatimAPI;
import Model.OpenStreetMapAPI;
import Model.WeatherAPI;

import java.io.IOException;
import java.util.List;

public class Controller {
    NominatimAPI nominatimAPI = new NominatimAPI();
    List<String> latlon;

    public String getHotelsByCityName(String cityName) throws IOException, InterruptedException {
        latlon = nominatimAPI.getLatLonFromJson(nominatimAPI.getLatLonByCityName(cityName));
        return new HotelParser().parseJson(latlon);
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

    public String getGasStationsByCityName(String cityName) throws IOException, InterruptedException {
        latlon = nominatimAPI.getLatLonFromJson(nominatimAPI.getLatLonByCityName(cityName));
        return null;
    }

}
