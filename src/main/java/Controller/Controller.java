package Controller;

import Model.*;

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
        return new RestaurantParser().parseJson(latlon);
    }

    public String getParkingsByCityName(String cityName) throws IOException, InterruptedException {
        latlon = nominatimAPI.getLatLonFromJson(nominatimAPI.getLatLonByCityName(cityName));
        return new ParkingParser().parseJson(latlon);
    }

    public String getMuseumsByCityName(String cityName) throws IOException, InterruptedException {
        latlon = nominatimAPI.getLatLonFromJson(nominatimAPI.getLatLonByCityName(cityName));
        return new MuseumParser().parseJson(latlon);
    }

    public String getGasStationsByCityName(String cityName) throws IOException, InterruptedException {
        latlon = nominatimAPI.getLatLonFromJson(nominatimAPI.getLatLonByCityName(cityName));
        return new GasStationParser().parseJson(latlon);
    }

    public String getWeatherByCityName(String cityName) throws IOException, InterruptedException {
        latlon = nominatimAPI.getLatLonFromJson(nominatimAPI.getLatLonByCityName(cityName));
        return new WeatherParser().parseJson(latlon);
    }

}
